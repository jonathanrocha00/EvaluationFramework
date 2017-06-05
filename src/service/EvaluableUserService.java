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

	public EvaluableUser search(String elementName) {
		return evaluableUserDao.search(elementName);
	}

	public void insert(EvaluableUser newElement) {
		evaluableUserDao.insert(newElement);
	}

	public void update() {
		evaluableUserDao.update();
	}

	public void delete(EvaluableUser element) {
		evaluableUserDao.delete(element);
	}

}
