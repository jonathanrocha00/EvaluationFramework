package model;

import java.util.List;

public class EvaluableItem extends FrameworkObject {
	
	// Attributes ====================================================
	
	// Constructors ==================================================
	public EvaluableItem(String name, String description) {
		super(name, description);
	}
	// Methods =======================================================
	public List<Evaluation> getReceivedEvaluations() {
		
		// TODO
		
		return null;
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
