package dao;

import java.util.List;

import model.UserEvaluation;

public class UserEvaluationDao implements DaoInterface<UserEvaluation>{

	private Dao<UserEvaluation> daoAdapter = new Dao<UserEvaluation>(UserEvaluation.class);
	
	@Override
	public List<UserEvaluation> searchAll() {
		return daoAdapter.findAll();
	}

	@Override
	public UserEvaluation search(int elemento) {
		return daoAdapter.findById(elemento);
	}

	@Override
	public void insert(UserEvaluation novo) {
		daoAdapter.saveOrUpdate(novo);
	}

	@Override
	public void update(UserEvaluation elemento) {
		daoAdapter.saveOrUpdate(elemento);
	}

	@Override
	public void delete(UserEvaluation elemento) {
		daoAdapter.delete(elemento);
	}

}
