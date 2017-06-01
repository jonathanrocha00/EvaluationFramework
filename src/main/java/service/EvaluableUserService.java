package service;

import java.util.List;

import dao.EvaluableUserDao;
import model.EvaluableUser;

public class EvaluableUserService implements ServiceInterface<EvaluableUser>{
	
	// Attributes ====================================================
	private EvaluableUserDao evaluableUserDao;
	
	// Constructors ==================================================
	public EvaluableUserService(EvaluableUserDao evaluableUserDAO) {
		this.evaluableUserDao = evaluableUserDAO;
	} 

	// Methods =======================================================
	@Override
	public List<EvaluableUser> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EvaluableUser search(EvaluableUser elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(EvaluableUser novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EvaluableUser elemento) {
		// TODO Auto-generated method stub
		
	}

}
