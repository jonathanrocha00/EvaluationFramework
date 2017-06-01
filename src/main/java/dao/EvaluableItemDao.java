package dao;

import java.util.List;

import model.EvaluableItem;

public class EvaluableItemDao implements DaoInterface<EvaluableItem> {
	
	private Dao<EvaluableItem> daoAdapter = new Dao<EvaluableItem>(EvaluableItem.class);

	@Override
	public List<EvaluableItem> searchAll() {
		return daoAdapter.findAll();
	}

	@Override
	public EvaluableItem search(int elemento) {
		return daoAdapter.findById(elemento);
	}

	@Override
	public void insert(EvaluableItem novo) {
		daoAdapter.saveOrUpdate(novo);
	}

	@Override
	public void update(EvaluableItem elemento) {
		daoAdapter.saveOrUpdate(elemento);
	}

	@Override
	public void delete(EvaluableItem elemento) {
		daoAdapter.delete(elemento);
	}

}
