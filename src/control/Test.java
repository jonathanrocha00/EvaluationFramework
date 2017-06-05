package control;

import model.EvaluableItem;
import model.EvaluationRule;
import model.User;

public class Test implements EvaluationRule<EvaluableItem, User>{

	@Override
	public boolean validateEvaluation(EvaluableItem item, User user) {
		if (user.getName() == "carlosant"){
			System.out.println("Pode avaliar!");
		}else{
			System.out.println("Avaliacao nao permitida");
			return false;
		}
		
		return true;
	}

	
}
