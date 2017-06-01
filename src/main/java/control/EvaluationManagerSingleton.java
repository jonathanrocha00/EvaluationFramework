package control;

import java.util.Date;
import java.util.List;

import dao.ItemEvaluationDao;
import dao.UserEvaluationDao;
import model.*;

public class EvaluationManagerSingleton {

	// Attributes ====================================================
	private static EvaluationManagerSingleton singletonInstance;
	private ItemEvaluationDao itemEvaluationDao;
	private UserEvaluationDao userEvaluationDao;

	// Constructors ==================================================
	private EvaluationManagerSingleton() {
	}
	
	// Methods =======================================================
	public static EvaluationManagerSingleton getInstance() {
		if (singletonInstance == null) {
			singletonInstance = new EvaluationManagerSingleton();
		}
		
		return singletonInstance;
	}
	
	public void evaluateItem(EvaluableItem itemToBeEvaluated, User userWhoEvaluated, List<SubjectiveCriterion> subjectiveCriteria, List<ObjectiveCriterion> objectiveCriteria, Date date) {
		
		itemEvaluationDao.insert(new ItemEvaluation(itemToBeEvaluated, userWhoEvaluated, subjectiveCriteria, objectiveCriteria, date));
		
	}
	
	public void evaluateUser(EvaluableUser userToBeEvaluated, User userWhoEvaluated, List<SubjectiveCriterion> subjectiveCriteria, List<ObjectiveCriterion> objectiveCriteria, Date date) {
		
		userEvaluationDao.insert(new UserEvaluation(userToBeEvaluated, userWhoEvaluated, subjectiveCriteria, objectiveCriteria, date));
		
	}
}
