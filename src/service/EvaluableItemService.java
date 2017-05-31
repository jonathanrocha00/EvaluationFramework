package service;

import java.util.List;

import dao.EvaluableItemDao;
import model.EvaluableItem;

public class EvaluableItemService implements ServiceInterface<EvaluableItem>{
	
	// Attributes ====================================================
	private EvaluableItemDao evaluableItemDAO;
	
	// Constructors ==================================================
	public EvaluableItemService(EvaluableItemDao evaluableItemDAO) {
		this.evaluableItemDAO = evaluableItemDAO;
	} 
	
	// Methods =======================================================
	@Override
	public List<EvaluableItem> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EvaluableItem search(EvaluableItem elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(EvaluableItem novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EvaluableItem elemento) {
		// TODO Auto-generated method stub
		
	}
	
}
