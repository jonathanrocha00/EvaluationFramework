package dao;

import java.util.List;

import model.EvaluableUser;

public class EvaluableUserDao implements DaoInterface<EvaluableUser> {

	private Dao<EvaluableUser> daoAdapter = new Dao<EvaluableUser>(EvaluableUser.class);
	
	@Override
	public List<EvaluableUser> searchAll() {
		return daoAdapter.findAll();
	}

	@Override
	public EvaluableUser search(int elemento) {
		return daoAdapter.findById(elemento);
	}

	@Override
	public void insert(EvaluableUser novo) {
		daoAdapter.saveOrUpdate(novo);
	}

	@Override
	public void update(EvaluableUser obj) {
		daoAdapter.saveOrUpdate(obj);		
	}

	@Override
	public void delete(EvaluableUser elemento) {
		daoAdapter.delete(elemento);
	}

	

}
