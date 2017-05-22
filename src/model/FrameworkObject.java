package model;

public abstract class FrameworkObject {
	
	// Attributes =====================================================
	protected int id;
	protected String name;
	protected String description;
	
	// Constructors ===================================================
	public FrameworkObject(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	// Methods ========================================================
}
