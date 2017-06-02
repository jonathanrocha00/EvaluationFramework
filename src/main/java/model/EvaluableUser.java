package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="evaluable_user")
public class EvaluableUser extends User {
	
	// Attributes ====================================================
	@Column
	private String description;

	// Constructor ===================================================
	public EvaluableUser() {}
	
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
