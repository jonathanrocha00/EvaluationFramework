package dao;

import java.util.ArrayList;
import java.util.List;

import model.EvaluableUser;

public class EvaluableUserDao implements DaoInterface<EvaluableUser>{

	private ArrayList<EvaluableUser> evaluableUserList;
	
	public EvaluableUserDao() {
		evaluableUserList = new ArrayList<EvaluableUser>();
	}
	
	public List<EvaluableUser> searchAll() {
		return evaluableUserList;
	}
	
	public EvaluableUser search(String elementName) {
		for (int i = 0; i < evaluableUserList.size(); i++) {
			if (evaluableUserList.get(i).getName().equals(elementName)) {
				return evaluableUserList.get(i);
			}
		}
		
		return null;
	}
	
	public void insert(EvaluableUser newElement) {
		evaluableUserList.add(newElement);
	}
	
	// Not implemented.
	public void update() {
		throw new UnsupportedOperationException("Not implemented.");
	}
	
	public void delete(EvaluableUser element) {
		evaluableUserList.remove(element);
	}
}
