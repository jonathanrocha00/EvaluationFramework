package dao;

import java.util.ArrayList;
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
	
	public EvaluableItem search(String elementName) {
		for (int i = 0; i < evaluableItemList.size(); i++) {
			if (evaluableItemList.get(i).getName().equals(elementName)) {
				return evaluableItemList.get(i);
			}
		}
		
		return null;
	}
	public void insert(EvaluableItem newElement) {
		evaluableItemList.add(newElement);
	}
	
	// Not implemented.
	public void update() {
		throw new UnsupportedOperationException();
	}
	
	public void delete(EvaluableItem element) {
		evaluableItemList.remove(element);
	}
}
