package model;

import java.util.Date;
import java.util.List;

public abstract class Evaluation extends FrameworkObject {
	// Attributes =================================================
	protected User user;
	protected List<SubjectiveCriterion> subjectiveCriteria;
	protected List<ObjectiveCriterion> objectiveCriteria;
	protected Date date;
	
	// Constructors ================================================
	public Evaluation(User user, List<SubjectiveCriterion> subjectiveCriteria,
			List<ObjectiveCriterion> objectiveCriteria, Date date) {
		super();
		this.user = user;
		this.subjectiveCriteria = subjectiveCriteria;
		this.objectiveCriteria = objectiveCriteria;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
