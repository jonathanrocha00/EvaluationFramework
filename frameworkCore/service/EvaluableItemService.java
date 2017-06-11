package service;

import java.util.List;

import dao.EvaluableItemDao;
import model.EvaluableItem;

public class EvaluableItemService implements ServiceInterface<EvaluableItem>{
	
	// Attributes ====================================================
	private EvaluableItemDao evaluableItemDAO;
	
	// Constructors ==================================================
	public EvaluableItemService() {
		evaluableItemDAO = new EvaluableItemDao();
	} 
	
	// Methods =======================================================
	public List<EvaluableItem> searchAll() {
		return evaluableItemDAO.searchAll();
	}
	
	public EvaluableItem search(int element) {
		return evaluableItemDAO.search(element);
	}
	
	public void insert(EvaluableItem newElement) {
		evaluableItemDAO.insert(newElement);
	}
	
	// Not implemented.
	public void update(EvaluableItem element) {
		evaluableItemDAO.update(element);
	}
	
	public void delete(EvaluableItem element) {
		evaluableItemDAO.delete(element);
	}
	
}
