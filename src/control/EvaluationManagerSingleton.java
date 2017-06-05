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

	public void evaluateItem(EvaluationRule<EvaluableItem, User> evaluationRuleItem, EvaluableItem itemToBeEvaluated,
			User userWhoEvaluated, Date date) {

		if (evaluationRuleItem.validateEvaluation(itemToBeEvaluated, userWhoEvaluated)) {
			itemEvaluationService.insert(new ItemEvaluation(itemToBeEvaluated, userWhoEvaluated,
					itemToBeEvaluated.getSubjectiveCriteriaToBeEvaluated(),
					itemToBeEvaluated.getObjectiveCriteriaToBeEvaluated(), date));
		}

		// Erases rates and comments from EvaluableItem list of criteria
		for (int i = 0; i < itemToBeEvaluated.getObjectiveCriteriaToBeEvaluated().size(); i++) {
			itemToBeEvaluated.getObjectiveCriteriaToBeEvaluated().get(i).setRate(0);
		}
		for (int i = 0; i < itemToBeEvaluated.getSubjectiveCriteriaToBeEvaluated().size(); i++) {
			itemToBeEvaluated.getSubjectiveCriteriaToBeEvaluated().get(i).setComment(null);
		}
	}

	public void evaluateUser(EvaluationRule<EvaluableUser, User> evaluationRuleUser, EvaluableUser userToBeEvaluated,
			User userWhoEvaluated, Date date) {

		if (evaluationRuleUser.validateEvaluation(userToBeEvaluated, userWhoEvaluated)) {
			userEvaluationService.insert(new UserEvaluation(userToBeEvaluated, userWhoEvaluated,
					userToBeEvaluated.getSubjectiveCriteriaToBeEvaluated(),
					userToBeEvaluated.getObjectiveCriteriaToBeEvaluated(), date));
		}

		// Erases rates and comments from EvaluableItem list of criteria
		for (int i = 0; i < userToBeEvaluated.getObjectiveCriteriaToBeEvaluated().size(); i++) {
			userToBeEvaluated.getObjectiveCriteriaToBeEvaluated().get(i).setRate(0);
		}
		for (int i = 0; i < userToBeEvaluated.getSubjectiveCriteriaToBeEvaluated().size(); i++) {
			userToBeEvaluated.getSubjectiveCriteriaToBeEvaluated().get(i).setComment(null);
		}
	}

	public List<ItemEvaluation> getAllItemEvaluations(){
		return itemEvaluationService.searchAll();
	}
	
	public List<UserEvaluation> getAllUserEvaluations(){
		return userEvaluationService.searchAll();
	}
	
}
