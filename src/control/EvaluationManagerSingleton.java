package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.*;
import service.ItemEvaluationService;
import service.UserEvaluationService;

public class EvaluationManagerSingleton {

	// Attributes ====================================================
	private static EvaluationManagerSingleton singletonInstance;
	
	private ItemEvaluationService itemEvaluationService;
	private UserEvaluationService userEvaluationService;

	// Constructors ==================================================
	private EvaluationManagerSingleton() {
		itemEvaluationService = new ItemEvaluationService();
		userEvaluationService = new UserEvaluationService();
	}
	
	// Methods =======================================================
	public static EvaluationManagerSingleton getInstance() {
		if (singletonInstance == null) {
			singletonInstance = new EvaluationManagerSingleton();
		}
		
		return singletonInstance;
	}
	
	public void evaluateItem(EvaluableItem evaluatedItem, User user, List<SubjectiveCriterion> comments, List<ObjectiveCriterion> rates, Date date) {
		itemEvaluationService.insert(new ItemEvaluation(evaluatedItem, user, comments, rates, date));
	}
	
	public void evaluateUser(EvaluableUser evaluatedUser, User user, List<SubjectiveCriterion> comments, List<ObjectiveCriterion> rates, Date date) {
		userEvaluationService.insert(new UserEvaluation(evaluatedUser, user, comments, rates, date));
	}
	
	public List<ItemEvaluation> getAllItemEvaluations(){
		return itemEvaluationService.searchAll();
	}
	
	public List<UserEvaluation> getAllUserEvaluations(){
		return userEvaluationService.searchAll();
	}
	
	public void printItemEvaluations(Class<?> C){
		
		System.out.println("=== Mostrando avalia��es feitas sobre " + C.getSimpleName() + "... ===");
		
		ArrayList<ItemEvaluation> avaliacoes = new ArrayList<ItemEvaluation>();
		
		for (ItemEvaluation item: getAllItemEvaluations()) {
			if (item.getEvaluatedItem().getClass() == C) {
				avaliacoes.add(item);
			}
		}
		
		for (ItemEvaluation avaliacao: avaliacoes) {
			System.out.println("Avalia��o feita por " + avaliacao.getUser().getName() + " sobre " + avaliacao.getEvaluatedItem().getName());
		
			for (ObjectiveCriterion criterio: avaliacao.getRates()) {
				System.out.println("\t> " + criterio.getName() + ": " + criterio.getRate());
			}
			for (SubjectiveCriterion criterio: avaliacao.getComments()) {
				System.out.println("\t> " + criterio.getName() + ": ");
				System.out.println("\t\t" + criterio.getComment());
			}				
		}
	}
	
	public void printUserEvaluations(Class<?> C){
		
		System.out.println("=== Mostrando avalia��es feitas sobre " + C.getSimpleName() + "... ===");
		
		ArrayList<UserEvaluation> avaliacoes = new ArrayList<UserEvaluation>();
		
		for (UserEvaluation item: getAllUserEvaluations()) {
			if (item.getEvaluatedItem().getClass() == C) {
				avaliacoes.add(item);
			}
		}
		
		for (UserEvaluation avaliacao: avaliacoes) {
			System.out.println("Avalia��o feita por " + avaliacao.getUser().getName() + " sobre " + avaliacao.getEvaluatedItem().getName());
		
			for (ObjectiveCriterion criterio: avaliacao.getRates()) {
				System.out.println("\t> " + criterio.getName() + ": " + criterio.getRate());
			}
			for (SubjectiveCriterion criterio: avaliacao.getComments()) {
				System.out.println("\t> " + criterio.getName() + ": ");
				System.out.println("\t\t" + criterio.getComment());
			}				
		}
	}
	
}
