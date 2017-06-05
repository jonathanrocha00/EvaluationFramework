package service;

import java.util.List;

import dao.DaoInterface;
import model.EvaluableUser;

public class EvaluableUserService implements ServiceInterface<EvaluableUser> {

	// Attributes ====================================================
	private DaoInterface<EvaluableUser> evaluableUserDao;

	// Constructors ==================================================
	public EvaluableUserService(DaoInterface<EvaluableUser> evaluableUserDao) {
			this.evaluableUserDao = evaluableUserDao;
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
