package dao;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao implements DaoInterface<User> {
	
	private ArrayList<User> userList;
	
	public UserDao() {
		userList = new ArrayList<User>();
	}
	
	public List<User> searchAll() {
		return userList;
	}
	
	public User search(String elementName) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().equals(elementName)) {
				return userList.get(i);
			}
		}
		
		return null;
	}
	
	public void insert(User newElement) {
		userList.add(newElement);
	}
	
	// Not implemented.
	public void update() {
		throw new UnsupportedOperationException();
	}
	
	public void delete(User element) {
		userList.remove(element);
	}
}
