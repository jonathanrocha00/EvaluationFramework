package model;

public abstract class FrameworkObject {
	
	// Attributes =====================================================
	protected int id;
	protected String name;
	protected String description;
	
	static int currentId = 1;
	
	// Constructors ===================================================
	public FrameworkObject(String name, String description) {
		this.id = currentId;
		this.name = name;
		this.description = description;
		
		currentId++;
	}
	
	// Methods ========================================================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}