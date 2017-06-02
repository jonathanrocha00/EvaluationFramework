package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_evaluation")
public class ItemEvaluation extends Evaluation {
	// Attributes ====================================================
	
	@ManyToOne
	@JoinColumn(name="id_evaluable_item")
	private EvaluableItem evaluatedItem;
		
	// Constructors ==================================================
	public ItemEvaluation() {}
	
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
