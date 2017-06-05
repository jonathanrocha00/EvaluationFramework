package model;


public class User {
	// Attributes ====================================================
	protected String name;

	// Constructors ==================================================
	public User(String name) {
		this.name = name;
	}
	
	// Methods =======================================================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
