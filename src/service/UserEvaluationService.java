package service;

import java.util.List;

import dao.UserEvaluationDao;
import model.UserEvaluation;

public class UserEvaluationService implements ServiceInterface<UserEvaluation>{

	// Attributes ====================================================
	private UserEvaluationDao userEvaluationDao;
	
	// Constructors ==================================================
	public UserEvaluationService(UserEvaluationDao userEvaluationDao) {
		this.userEvaluationDao = userEvaluationDao;
	} 

	// Methods =======================================================
	
	@Override
	public List<UserEvaluation> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserEvaluation search(UserEvaluation elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserEvaluation novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserEvaluation elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserEvaluation search(String elementName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
