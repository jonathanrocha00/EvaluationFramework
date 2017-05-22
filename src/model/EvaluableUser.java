package model;

import java.util.List;

public class EvaluableUser extends User {
	
	// Attributes ====================================================
	private String description;

	// Constructor ===================================================
	public EvaluableUser(String name, String description) {
		super(name);
		this.description = description;
	}
	
	// Methods =======================================================
	public List<Evaluation> getReceivedEvaluations() {
		
		// TODO
		
		return null;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
