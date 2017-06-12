package service;

import java.util.List;

import dao.UserEvaluationDao;
import model.UserEvaluation;

public class UserEvaluationService implements ServiceInterface<UserEvaluation>{

	// Attributes ====================================================
	private UserEvaluationDao userEvaluationDao;
	
	// Constructors ==================================================
	public UserEvaluationService() {
		userEvaluationDao = new UserEvaluationDao();
	} 

	// Methods =======================================================
	
	@Override
	public List<UserEvaluation> searchAll() {
		return userEvaluationDao.searchAll();
	}

	public UserEvaluation search(UserEvaluation element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserEvaluation newElement) {
		userEvaluationDao.insert(newElement);
		
	}

	@Override
	public void update(UserEvaluation element) {
		userEvaluationDao.update(element);
	}

	@Override
	public void delete(UserEvaluation element) {
		userEvaluationDao.delete(element);
	}

	@Override
	public UserEvaluation search(int element) {
		return userEvaluationDao.search(element);
	}
	
	

}
