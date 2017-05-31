package service;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserService implements ServiceInterface<User>{
	
	// Attributes ====================================================
	private UserDao userDao;
	
	// Constructors ==================================================
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	} 
	
	// Methods =======================================================

	@Override
	public List<User> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User search(User elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(User novo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User elemento) {
		// TODO Auto-generated method stub
		
	}

}
