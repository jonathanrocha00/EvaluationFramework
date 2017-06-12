package model;

public class SubjectiveCriterion extends FrameworkObject {
	// Attributes =====================================================
	private String comment;
	
	// Constructors ====================================================
	public SubjectiveCriterion(String name, String description, String comment) {
		super(name, description);
		this.comment = comment;
	}
	
	// Methods ========================================================
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}