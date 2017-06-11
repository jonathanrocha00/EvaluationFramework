package model;


public class User {
	// Attributes ====================================================
	protected String name;
	protected int id;

	// Constructors ==================================================
	public User(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	// Methods =======================================================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
