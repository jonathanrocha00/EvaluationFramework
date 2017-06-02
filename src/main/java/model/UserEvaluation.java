package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_evaluation")
public class UserEvaluation extends Evaluation {

	// Attributes ====================================================
	@ManyToOne
	@JoinColumn(name="id_evaluable_user")
	private EvaluableUser evaluatedUser;
	
	// Constructors ==================================================
	public UserEvaluation() {}
	
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
