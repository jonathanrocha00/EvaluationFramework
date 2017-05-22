package model;

public class SubjectiveCriterion extends FrameworkObject {
	// Attributes =====================================================
	private String comment;
	
	// Constructors ====================================================
	public SubjectiveCriterion(int id, String name, String description, String comment) {
		super(id, name, description);
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
