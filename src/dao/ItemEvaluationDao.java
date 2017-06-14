package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.ItemEvaluation;

public class ItemEvaluationDao implements DaoInterface<ItemEvaluation>{
	
	private ArrayList<ItemEvaluation> itemEvaluationList;
	
	public ItemEvaluationDao(){
		itemEvaluationList = new ArrayList<ItemEvaluation>();
	}

	@Override
	public List<ItemEvaluation> searchAll() {
		return itemEvaluationList;
	}

	@Override
	public ItemEvaluation search(int element) {
		return null;
	}
	
	public boolean doesExist(ItemEvaluation item){
		
		for (ItemEvaluation ie: itemEvaluationList){
			if ((ie.getUser() == item.getUser()) && (ie.getEvaluatedItem() == item.getEvaluatedItem())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void insert(ItemEvaluation newElement) {
		
		if (doesExist(newElement)){
			update(newElement);
		}else{
			System.out.println("Devo entrar aqui...");
			itemEvaluationList.add(newElement);
		}
	}

	@Override
	public void update(ItemEvaluation element) {
		Iterator<ItemEvaluation> it = itemEvaluationList.iterator();
		while(it.hasNext()) {
			ItemEvaluation ie = it.next();
			
			if(ie.getUser() == element.getUser() && ie.getEvaluatedItem() == element.getEvaluatedItem()) {
				ie.setDate(element.getDate());
				ie.setComments(element.getComments());
				ie.setRates(element.getRates());
			}
		}
	}

	@Override
	public void delete(ItemEvaluation element) {
		itemEvaluationList.remove(element);
	}

	

}
