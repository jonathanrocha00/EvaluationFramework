package service;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserService implements ServiceInterface<User>{
	
	// Attributes ====================================================
	private UserDao userDao;
	
	// Constructors ==================================================
	public UserService() {
		userDao = new UserDao();
	} 
	
	// Methods =======================================================
	public List<User> searchAll() {
		return userDao.searchAll();
	}
	
	public User search(int element) {
		return userDao.search(element);
	}
	
	public void insert(User newElement) {
		userDao.insert(newElement);
	}
	
	public void update(User element) {
		userDao.update(element);
	}
	
	public void delete(User element) {
		userDao.delete(element);
	}
}
