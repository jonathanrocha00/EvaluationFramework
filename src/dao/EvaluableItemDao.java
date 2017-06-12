package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.EvaluableItem;

public class EvaluableItemDao implements DaoInterface<EvaluableItem>{
	
	private ArrayList<EvaluableItem> evaluableItemList;
	
	public EvaluableItemDao() {
		evaluableItemList = new ArrayList<EvaluableItem>();
	}
	
	public List<EvaluableItem> searchAll() {
		return evaluableItemList;
	}
	
	@Override
	public EvaluableItem search(int element) {
		for (int i = 0; i < evaluableItemList.size(); i++) {
			if (evaluableItemList.get(i).getId() == element) {
				return evaluableItemList.get(i);
			}
		}
		return null;
	}
	
	public void insert(EvaluableItem newElement) {
		evaluableItemList.add(newElement);
	}
	
	public void update(EvaluableItem element) {
		Iterator<EvaluableItem> it = evaluableItemList.iterator();
		while(it.hasNext()) {
			EvaluableItem ei = it.next();
			
			if(ei.getId() == element.getId()) {
				ei.setName(element.getName());
				ei.setDescription(element.getDescription());
			}
		}
	}
	
	public void delete(EvaluableItem element) {
		evaluableItemList.remove(element);
	}
}
