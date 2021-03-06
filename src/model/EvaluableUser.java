package model;

import java.util.ArrayList;

public class EvaluableUser extends User {
	
	// Attributes ====================================================
	private String description;
	private ArrayList<ObjectiveCriterion> objectiveCriteriaToBeEvaluated;
	private ArrayList<SubjectiveCriterion> subjectiveCriteriaToBeEvaluated;

	// Constructor ===================================================
	public EvaluableUser(String name, String description) {
		super(name);
		
		this.description = description;
	}
	
	// Methods =======================================================	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
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