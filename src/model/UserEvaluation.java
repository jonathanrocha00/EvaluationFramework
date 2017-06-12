package model;

import java.util.Date;
import java.util.List;

public class UserEvaluation extends Evaluation {

	// Attributes ====================================================
	private EvaluableUser evaluatedUser;
	
	// Constructors ==================================================
	public UserEvaluation(EvaluableUser evaluatedUser, User user, List<SubjectiveCriterion> comments, List<ObjectiveCriterion> rates, Date date) {
		super(user, comments, rates, date);
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
