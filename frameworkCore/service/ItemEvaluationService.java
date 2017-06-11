package service;

import java.util.List;

import dao.ItemEvaluationDao;
import model.ItemEvaluation;

public class ItemEvaluationService implements ServiceInterface<ItemEvaluation>{
	
	// Attributes ====================================================
	private ItemEvaluationDao itemEvaluationDao;
	
	// Constructors ==================================================
	public ItemEvaluationService() {
		itemEvaluationDao = new ItemEvaluationDao();
	} 

	// Methods =======================================================

	@Override
	public List<ItemEvaluation> searchAll() {
		return itemEvaluationDao.searchAll();
	}

	public ItemEvaluation search(ItemEvaluation element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ItemEvaluation newElement) {
		itemEvaluationDao.insert(newElement);
	}

	@Override
	public void update(ItemEvaluation element) {
		itemEvaluationDao.update(element);
	}

	@Override
	public void delete(ItemEvaluation element) {
		itemEvaluationDao.delete(element);
	}

	@Override
	public ItemEvaluation search(int element) {
		return itemEvaluationDao.search(element);
	}

}
