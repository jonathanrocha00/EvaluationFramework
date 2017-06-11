package model;

import java.util.Date;
import java.util.List;

public abstract class Evaluation {
	// Attributes =================================================
	protected User user;
	protected List<String> comments;
	protected List<Integer> rates;
	protected Date date;
	
	// Constructors ================================================
	public Evaluation(User user, List<String> comments,
			List<Integer> rates, Date date) {
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

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<Integer> getRates() {
		return rates;
	}

	public void setRates(List<Integer> rates) {
		this.rates = rates;
	}
	
	
}
