package service;

import java.util.List;

import dao.ItemEvaluationDao;
import model.ItemEvaluation;

public class ItemEvaluationService implements ServiceInterface<ItemEvaluation>{
	
	// Attributes ====================================================
	private ItemEvaluationDao itemEvaluationDao;
	
	// Constructors ==================================================
	public ItemEvaluationService(ItemEvaluationDao itemEvaluationDao) {
		this.itemEvaluationDao = itemEvaluationDao;
	} 

	// Methods =======================================================

	@Override
	public List<ItemEvaluation> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemEvaluation search(ItemEvaluation elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ItemEvaluation novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ItemEvaluation elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemEvaluation search(String elementName) {
		// TODO Auto-generated method stub
		return null;
	}

}
