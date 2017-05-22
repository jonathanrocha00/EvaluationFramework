package control;

import java.util.Date;
import java.util.List;

import model.*;

public class EvaluationManagerSingleton {

	// Attributes ====================================================
	private static EvaluationManagerSingleton singletonInstance;

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
		
		// TODO
		
	}
	
	public void evaluateUser(EvaluableUser userToBeEvaluated, User userWhoEvaluated, List<SubjectiveCriterion> subjectiveCriteria, List<ObjectiveCriterion> objectiveCriteria, Date date) {
		
		// TODO
		
	}
}
