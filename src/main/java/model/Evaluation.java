package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class Evaluation extends FrameworkObject {
	
	// Attributes =================================================
	@ManyToOne
	@JoinColumn(name="id_user")
	protected User user;
	
	@Transient
	protected List<SubjectiveCriterion> subjectiveCriteria;
	
	@Transient
	protected List<ObjectiveCriterion> objectiveCriteria;
	
	@Column
	@Temporal(TemporalType.DATE)
	protected Date date;
	
	// Constructors ================================================
	public Evaluation() {}
	
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
