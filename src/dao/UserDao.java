package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.User;

public class UserDao implements DaoInterface<User> {
	
	private ArrayList<User> userList;
	
	public UserDao() {
		userList = new ArrayList<User>();
	}
	
	@Override
	public List<User> searchAll() {
		return userList;
	}
	
	@Override
	public User search(int element) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == element) {
				return userList.get(i);
			}
		}
		
		return null;
	}
	
	@Override
	public void insert(User newElement) {
		userList.add(newElement);
	}
	
	@Override
	public void update(User element) {
		Iterator<User> it = userList.iterator();
		while(it.hasNext()) {
			User u = it.next();
			
			if(u.getId() == element.getId()) {
				u.setName(element.getName());
			}
		}
	}
	
	@Override
	public void delete(User element) {
		userList.remove(element);
	}
}
