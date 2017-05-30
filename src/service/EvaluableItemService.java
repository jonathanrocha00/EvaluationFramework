package service;

import java.util.List;

import dao.EvaluableItemDAOInterface;
import model.EvaluableItem;
import model.Evaluation;

public class EvaluableItemService {
	// Attributes ====================================================
	private EvaluableItemDAOInterface evaluableItemDAO;
	
	// Constructors ==================================================
	public EvaluableItemService(EvaluableItemDAOInterface evaluableItemDAO) {
		this.evaluableItemDAO = evaluableItemDAO;
	}
	
	// Methods =======================================================
	public List<Evaluation> getAllEvaluationsAbout(EvaluableItem item) {
		
		return evaluableItemDAO.getAllEvaluationsAbout(item);
	}
}
