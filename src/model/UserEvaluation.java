package model;

public class UserEvaluation extends FrameworkObject {

	// Attributes ====================================================
	private EvaluableItem evaluatedItem;
	
	// Constructors ==================================================
	public UserEvaluation(EvaluableItem evaluatedItem, int id, String name, String description) {
		super(id, name, description);
		this.evaluatedItem = evaluatedItem;
	}

	// Methods =======================================================
	public EvaluableItem getEvaluatedItem() {
		return evaluatedItem;
	}

	public void setEvaluatedItem(EvaluableItem evaluatedItem) {
		this.evaluatedItem = evaluatedItem;
	}
}
