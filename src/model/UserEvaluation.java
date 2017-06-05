package model;

import java.util.Date;
import java.util.List;

public class UserEvaluation extends Evaluation {

	// Attributes ====================================================
	private EvaluableUser evaluatedUser;
	
	// Constructors ==================================================
	public UserEvaluation(EvaluableUser evaluatedUser, User user, List<SubjectiveCriterion> subjectiveCriteria, List<ObjectiveCriterion> objectiveCriteria, Date date) {
		super(user, subjectiveCriteria, objectiveCriteria, date);
		this.evaluatedUser = evaluatedUser;
	}

	// Methods =======================================================
	public EvaluableUser getEvaluatedItem() {
		return evaluatedUser;
	}

	public void setEvaluatedItem(EvaluableUser evaluatedUser) {
		this.evaluatedUser = evaluatedUser;
	}
}
