package model;

import java.util.Date;
import java.util.List;

public class ItemEvaluation extends Evaluation {
	// Attributes ====================================================
	private EvaluableItem evaluatedItem;
	
	// Constructors ==================================================
	public ItemEvaluation(EvaluableItem evaluatedItem, User user, List<SubjectiveCriterion> subjectiveCriteria, List<ObjectiveCriterion> objectiveCriteria, Date date) {
		super(user, subjectiveCriteria, objectiveCriteria, date);
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
