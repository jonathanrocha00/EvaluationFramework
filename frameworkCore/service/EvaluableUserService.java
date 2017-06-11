package service;

import java.util.List;

import dao.EvaluableUserDao;
import model.EvaluableUser;

public class EvaluableUserService implements ServiceInterface<EvaluableUser> {

	// Attributes ====================================================
	private EvaluableUserDao evaluableUserDao;

	// Constructors ==================================================
	public EvaluableUserService() {
		evaluableUserDao = new EvaluableUserDao();
	}

	// Methods =======================================================
	public List<EvaluableUser> searchAll() {
		return evaluableUserDao.searchAll();
	}

	public EvaluableUser search(int element) {
		return evaluableUserDao.search(element);
	}

	public void insert(EvaluableUser newElement) {
		evaluableUserDao.insert(newElement);
	}

	public void update(EvaluableUser element) {
		evaluableUserDao.update(element);
	}

	public void delete(EvaluableUser element) {
		evaluableUserDao.delete(element);
	}

}
