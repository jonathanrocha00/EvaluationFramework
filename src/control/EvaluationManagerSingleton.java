package control;

import java.util.Date;
import java.util.List;

import model.*;
import service.ItemEvaluationService;
import service.UserEvaluationService;

public class EvaluationManagerSingleton {

	// Attributes ====================================================
	private static EvaluationManagerSingleton singletonInstance;
	
	private ItemEvaluationService itemEvaluationService;
	private UserEvaluationService userEvaluationService;

	// Constructors ==================================================
	private EvaluationManagerSingleton() {
		itemEvaluationService = new ItemEvaluationService();
		userEvaluationService = new UserEvaluationService();
	}
	
	// Methods =======================================================
	public static EvaluationManagerSingleton getInstance() {
		if (singletonInstance == null) {
			singletonInstance = new EvaluationManagerSingleton();
		}
		
		return singletonInstance;
	}
	
	public void evaluateItem(EvaluationRule<EvaluableItem, User> evaluationRuleItem, EvaluableItem itemToBeEvaluated, User userWhoEvaluated, List<SubjectiveCriterion> subjectiveCriteria, List<ObjectiveCriterion> objectiveCriteria, Date date) {
		
		if (evaluationRuleItem.validateEvaluation(itemToBeEvaluated, userWhoEvaluated) == true){
			itemEvaluationService.insert(new ItemEvaluation(itemToBeEvaluated, userWhoEvaluated, subjectiveCriteria, objectiveCriteria, date));
		}
	}
	
	public void evaluateUser(EvaluationRule<EvaluableUser, User> evaluationRuleUser, EvaluableUser userToBeEvaluated, User userWhoEvaluated, List<SubjectiveCriterion> subjectiveCriteria, List<ObjectiveCriterion> objectiveCriteria, Date date) {
		
		if (evaluationRuleUser.validateEvaluation(userToBeEvaluated, userWhoEvaluated) == true){
			userEvaluationService.insert(new UserEvaluation(userToBeEvaluated, userWhoEvaluated, subjectiveCriteria, objectiveCriteria, date));
		}
	}
	
	public List<ItemEvaluation> getAllItemEvaluations(){
		return itemEvaluationService.searchAll();
	}
	
	public List<UserEvaluation> getAllUserEvaluations(){
		return userEvaluationService.searchAll();
	}
	
}
