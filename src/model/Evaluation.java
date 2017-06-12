package model;

import java.util.Date;
import java.util.List;

public abstract class Evaluation {
	// Attributes =================================================
	protected User user;
	protected List<SubjectiveCriterion> comments;
	protected List<ObjectiveCriterion> rates;
	protected Date date;
	
	// Constructors ================================================
	public Evaluation(User user, List<SubjectiveCriterion> comments,
			List<ObjectiveCriterion> rates, Date date) {
		super();
		this.user = user;
		this.comments = comments;
		this.rates = rates;
		this.date = date;
	}
	
	// Methods ====================================================
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<SubjectiveCriterion> getComments() {
		return comments;
	}

	public void setComments(List<SubjectiveCriterion> comments) {
		this.comments = comments;
	}

	public List<ObjectiveCriterion> getRates() {
		return rates;
	}

	public void setRates(List<ObjectiveCriterion> rates) {
		this.rates = rates;
	}
	
	
}
