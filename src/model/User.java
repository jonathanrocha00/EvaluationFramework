package model;


public class User {
	// Attributes ====================================================
	protected String name;
	protected int id;
	static int currentId = 1;

	// Constructors ==================================================
	public User(String name) {
		this.name = name;
		this.id = currentId;
		
		currentId++;
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
