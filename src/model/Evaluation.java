package model;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;

public abstract class Evaluation {
	// Attributes =================================================
	protected User user;
	protected List<SubjectiveCriterion> subjectiveCriteria;
	protected List<ObjectiveCriterion> objectiveCriteria;
	protected EvaluableUser evaluableUser;
	protected EvaluableItem evaluableItem;
	protected EvaluationType evaluationType;
	protected Date date;
	
	// Constructors ================================================
	public Evaluation(User user, List<SubjectiveCriterion> subjectiveCriteria,
			List<ObjectiveCriterion> objectiveCriteria, EvaluableUser evaluableUser, 
			EvaluableItem evaluableItem, Date date) {
		this.user = user;
		this.subjectiveCriteria = subjectiveCriteria;
		this.objectiveCriteria = objectiveCriteria;
		this.date = date;
		
		if (evaluableUser != null && evaluableItem == null) {
			evaluationType = EvaluationType.USER;
		}
		else if (evaluableUser == null && evaluableItem != null) {
			evaluationType = EvaluationType.ITEM;
		}
		else {
			throw new InvalidParameterException("Either one evaluableItem AND a evaluableUser were inserted together or no evaluable object was inserted.");
		}
	}
	
	// Methods ====================================================
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SubjectiveCriterion> getSubjectiveCriteria() {
		return subjectiveCriteria;
	}

	public void setSubjectiveCriteria(List<SubjectiveCriterion> subjectiveCriteria) {
		this.subjectiveCriteria = subjectiveCriteria;
	}

	public List<ObjectiveCriterion> getObjectiveCriteria() {
		return objectiveCriteria;
	}

	public void setObjectiveCriteria(List<ObjectiveCriterion> objectiveCriteria) {
		this.objectiveCriteria = objectiveCriteria;
	}

	public EvaluableUser getEvaluableUser() {
		
		if (this.evaluationType == EvaluationType.ITEM) {
			throw new UnsupportedOperationException("This is an evaluation about an evaluable item, not user.");
		}
		
		return evaluableUser;
	}

	public void setEvaluableUser(EvaluableUser evaluableUser) {
		
		if (this.evaluationType == EvaluationType.ITEM) {
			throw new UnsupportedOperationException("This is an evaluation about an evaluable item, not user.");
		}
		
		this.evaluableUser = evaluableUser;
	}

	public EvaluableItem getEvaluableItem() {
		
		if (this.evaluationType == EvaluationType.USER) {
			throw new UnsupportedOperationException("This is an evaluation about an evaluable user, not item.");
		}
		
		return evaluableItem;
	}

	public void setEvaluableItem(EvaluableItem evaluableItem) {
		
		if (this.evaluationType == EvaluationType.USER) {
			throw new UnsupportedOperationException("This is an evaluation about an evaluable user, not item.");
		}
		
		this.evaluableItem = evaluableItem;
	}

	public EvaluationType getEvaluationType() {
		return evaluationType;
	}

	public void setEvaluationType(EvaluationType evaluationType) {
		this.evaluationType = evaluationType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
