package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class FrameworkObject {
	
	// Attributes =====================================================
	@Id
	@GeneratedValue
	@Column(name="id")
	protected int id;
	
	@Column
	protected String name;
	
	@Column
	protected String description;
	
	// Constructors ===================================================
	public FrameworkObject() {}
	
	public FrameworkObject(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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
