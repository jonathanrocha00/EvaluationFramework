package model;

public class ObjectiveCriterion extends FrameworkObject {
	// Attributes =====================================================
	private int rate;
	private CriterionType criterionType;
	
	// Constructors =====================================================
	public ObjectiveCriterion(int id, String name, String description, int rate, CriterionType criterionType) {
		super(id, name, description);
		this.rate = rate;
		this.criterionType = criterionType;
	}
	
	// Methods =====================================================
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public CriterionType getCriterionType() {
		return criterionType;
	}

	public void setCriterionType(CriterionType criterionType) {
		this.criterionType = criterionType;
	}
}
