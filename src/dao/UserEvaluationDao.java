package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.UserEvaluation;

public class UserEvaluationDao implements DaoInterface<UserEvaluation>{
	
	private ArrayList<UserEvaluation> userEvaluationList;
	
	public UserEvaluationDao(){
		userEvaluationList = new ArrayList<UserEvaluation>();
	}

	@Override
	public List<UserEvaluation> searchAll() {
		return userEvaluationList;
	}

	public UserEvaluation search(int element) {
		return null;
	}

	@Override
	public void insert(UserEvaluation newElement) {
		userEvaluationList.add(newElement);
	}

	@Override
	public void update(UserEvaluation element) {
		Iterator<UserEvaluation> it = userEvaluationList.iterator();
		while(it.hasNext()) {
			UserEvaluation ue = it.next();
			
			if(ue.getUser() == element.getUser() && ue.getEvaluatedItem() == element.getEvaluatedItem()) {
				ue.setDate(element.getDate());
				ue.setObjectiveCriteria(element.getObjectiveCriteria());
				ue.setSubjectiveCriteria(element.getSubjectiveCriteria());
			}
		}
	}

	@Override
	public void delete(UserEvaluation element) {
		userEvaluationList.remove(element);
	}

}
