package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="user")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User extends FrameworkObject {
	
	// Attributes ====================================================
	
	// Constructors ==================================================
	public User() {}
	
	public User(String name) {
		this.name = name;
	}
	
	// Methods =======================================================
	public List<Evaluation> getMadeEvaluations() {
		
		// TODO
		
		return null;
	}
}
