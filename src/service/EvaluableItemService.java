package service;

import java.util.List;

import dao.DaoInterface;
import model.EvaluableItem;

public class EvaluableItemService implements ServiceInterface<EvaluableItem>{
	
	// Attributes ====================================================
	private DaoInterface<EvaluableItem> evaluableItemDAO;
	
	// Constructors ==================================================
	public EvaluableItemService(DaoInterface<EvaluableItem> evaluableItemDAO) {
		this.evaluableItemDAO = evaluableItemDAO;
	} 
	
	// Methods =======================================================
	public List<EvaluableItem> searchAll() {
		return evaluableItemDAO.searchAll();
	}
	
	public EvaluableItem search(String elementName) {
		return evaluableItemDAO.search(elementName);
	}
	
	public void insert(EvaluableItem newElement) {
		evaluableItemDAO.insert(newElement);
	}
	
	// Not implemented.
	public void update() {
		evaluableItemDAO.update();
	}
	
	public void delete(EvaluableItem element) {
		evaluableItemDAO.delete(element);
	}
	
}
