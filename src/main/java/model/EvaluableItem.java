package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="evaluable_item")
public class EvaluableItem extends FrameworkObject {
	
	// Attributes ====================================================
	
	// Constructors ==================================================
	public EvaluableItem() {}
	
	public EvaluableItem(int id, String name, String description) {
		super(id, name, description);
	}
	// Methods =======================================================
	public List<Evaluation> getReceivedEvaluations() {
		
		// TODO
		
		return null;
	}
}
