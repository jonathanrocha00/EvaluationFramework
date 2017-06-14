package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.EvaluableUser;

public class EvaluableUserDao implements DaoInterface<EvaluableUser>{

	private ArrayList<EvaluableUser> evaluableUserList;
	
	public EvaluableUserDao() {
		evaluableUserList = new ArrayList<EvaluableUser>();
	}
	
	@Override
	public List<EvaluableUser> searchAll() {
		return evaluableUserList;
	}
	
	@Override
	public EvaluableUser search(int element) {
		for (int i = 0; i < evaluableUserList.size(); i++) {
			if (evaluableUserList.get(i).getId() == element) {
				return evaluableUserList.get(i);
			}
		}
		
		return null;
	}
	
	public boolean doesExist(EvaluableUser user){
		for (EvaluableUser eu: evaluableUserList){
			if (eu.getName().equals(user.getName())){
				user.setId(eu.getId());
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void insert(EvaluableUser newElement) {
		
		System.out.println("Entrei nesse método");
		
		if (doesExist(newElement)){
			System.out.println("Entrei!");
			update(newElement);
		}else{
			evaluableUserList.add(newElement);
		}
	}
	
	@Override
	public void update(EvaluableUser element) {
		Iterator<EvaluableUser> it = evaluableUserList.iterator();
		while(it.hasNext()) {
			EvaluableUser eu = it.next();
			
			if(eu.getId() == element.getId()) {
				eu.setName(element.getName());
				eu.setDescription(element.getDescription());
			}
		}
	}
	
	@Override
	public void delete(EvaluableUser element) {
		evaluableUserList.remove(element);
	}
}
