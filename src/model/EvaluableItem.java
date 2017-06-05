package model;

import java.util.ArrayList;

public class EvaluableItem extends FrameworkObject {
	
	// Attributes ====================================================
	private ArrayList<ObjectiveCriterion> objectiveCriteriaToBeEvaluated;
	private ArrayList<SubjectiveCriterion> subjectiveCriteriaToBeEvaluated;
	
	// Constructors ==================================================
	public EvaluableItem(int id, String name, String description, 
			ArrayList<ObjectiveCriterion> objectiveCriteriaToBeEvaluated, 
			ArrayList<SubjectiveCriterion> subjectiveCriteriaToBeEvaluated) {
		super(id, name, description);
		
		this.objectiveCriteriaToBeEvaluated = objectiveCriteriaToBeEvaluated;
		this.subjectiveCriteriaToBeEvaluated = subjectiveCriteriaToBeEvaluated;
	}
	// Methods =======================================================
	public ArrayList<ObjectiveCriterion> getObjectiveCriteriaToBeEvaluated() {
		return objectiveCriteriaToBeEvaluated;
	}

	public void setObjectiveCriteriaToBeEvaluated(ArrayList<ObjectiveCriterion> objectiveCriteriaToBeEvaluated) {
		this.objectiveCriteriaToBeEvaluated = objectiveCriteriaToBeEvaluated;
	}

	public ArrayList<SubjectiveCriterion> getSubjectiveCriteriaToBeEvaluated() {
		return subjectiveCriteriaToBeEvaluated;
	}

	public void setSubjectiveCriteriaToBeEvaluated(ArrayList<SubjectiveCriterion> subjectiveCriteriaToBeEvaluated) {
		this.subjectiveCriteriaToBeEvaluated = subjectiveCriteriaToBeEvaluated;
	}
	
}