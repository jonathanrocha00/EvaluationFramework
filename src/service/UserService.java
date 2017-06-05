package service;

import java.util.List;

import dao.DaoInterface;
import model.User;

public class UserService implements ServiceInterface<User>{
	
	// Attributes ====================================================
	private DaoInterface<User> userDao;
	
	// Constructors ==================================================
	public UserService(DaoInterface<User> userDao) {
		this.userDao = userDao;
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
