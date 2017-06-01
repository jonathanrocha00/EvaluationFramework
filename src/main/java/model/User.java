package model;

import java.util.List;

public class User extends FrameworkObject {
	
	// Attributes ====================================================
	protected String name;
	
	// Constructors ==================================================
	public User() {
		
	}
	
	public User(String name) {
		this.name = name;
	}
	
	// Methods =======================================================
	public List<Evaluation> getMadeEvaluations() {
		
		// TODO
		
		return null;
	}
}
