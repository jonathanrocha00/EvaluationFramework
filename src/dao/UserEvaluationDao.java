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
	
	public boolean doesExist(UserEvaluation item){
		
		for (UserEvaluation ue: userEvaluationList){
			if ((ue.getUser().getId() == item.getUser().getId()) && (ue.getEvaluatedItem().getName() == item.getEvaluatedItem().getName())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void insert(UserEvaluation newElement) {
		if (doesExist(newElement)){
			update(newElement);
		}else{
			userEvaluationList.add(newElement);
		}
	}

	@Override
	public void update(UserEvaluation element) {
		Iterator<UserEvaluation> it = userEvaluationList.iterator();
		while(it.hasNext()) {
			UserEvaluation ue = it.next();
			
			if(ue.getUser() == element.getUser() && ue.getEvaluatedItem().getName() == element.getEvaluatedItem().getName()) {
				ue.setDate(element.getDate());
				ue.setComments(element.getComments());
				ue.setRates(element.getRates());
			}
		}
	}

	@Override
	public void delete(UserEvaluation element) {
		userEvaluationList.remove(element);
	}

}
