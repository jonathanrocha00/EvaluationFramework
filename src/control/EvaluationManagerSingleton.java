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
	
	public void evaluateItem(EvaluationRule<Object, Object> evaluationRuleItem, EvaluableItem evaluatedItem, User user, List<SubjectiveCriterion> comments, List<ObjectiveCriterion> rates, Date date) {
		
		if (evaluationRuleItem.validateEvaluation(evaluatedItem, user) == true){
			itemEvaluationService.insert(new ItemEvaluation(evaluatedItem, user, comments, rates, date));
		}else{
			System.out.println("Não é possível fazer a avaliação!");
		}
	}
	
	public void evaluateUser(EvaluationRule<Object, Object> evaluationRuleUser, EvaluableUser evaluatedUser, User user, List<SubjectiveCriterion> comments, List<ObjectiveCriterion> rates, Date date) {
		
		if (evaluationRuleUser.validateEvaluation(evaluatedUser, user) == true){
			userEvaluationService.insert(new UserEvaluation(evaluatedUser, user, comments, rates, date));
		}
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
	
}
