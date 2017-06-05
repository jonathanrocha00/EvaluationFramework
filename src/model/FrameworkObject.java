package model;

public abstract class FrameworkObject {
	
	// Attributes =====================================================
	protected String name;
	protected String description;
	
	// Constructors ===================================================
	public FrameworkObject(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// Methods ========================================================
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
