package dao;

import java.util.List;

import model.ItemEvaluation;

public class ItemEvaluationDao implements DaoInterface<ItemEvaluation> {
	
	private Dao<ItemEvaluation> daoAdapter = new Dao<ItemEvaluation>(ItemEvaluation.class);
	
	@Override
	public List<ItemEvaluation> searchAll() {
		return daoAdapter.findAll();
	}

	@Override
	public ItemEvaluation search(int elemento) {
		return daoAdapter.findById(elemento);
	}

	@Override
	public void insert(ItemEvaluation novo) {
		daoAdapter.saveOrUpdate(novo);
	}

	@Override
	public void update(ItemEvaluation elemento) {
		daoAdapter.saveOrUpdate(elemento);
	}

	@Override
	public void delete(ItemEvaluation elemento) {
		daoAdapter.delete(elemento);
	}

	

}
