package dao;

import java.util.ArrayList;
import java.util.List;

import model.Evaluation;

public class EvaluationDao implements DaoInterface<Evaluation>{
	
	private ArrayList<Evaluation> evaluationList;
	
	public EvaluationDao() {
		evaluationList = new ArrayList<Evaluation>();
	}
	
	public List<Evaluation> searchAll() {
		return evaluationList;
	}
	
	public Evaluation search(String elementName) {
		throw new UnsupportedOperationException("Not implemented.");
	}
	
	public void insert(Evaluation newElement) {
		evaluationList.add(newElement);
	}
	
	// Not implemented.
	public void update() {
		throw new UnsupportedOperationException("Not implemented.");
	}
	
	public void delete(Evaluation element) {
		evaluationList.remove(element);
	}
}
