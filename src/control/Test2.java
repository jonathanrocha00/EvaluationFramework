package control;

import model.EvaluableUser;
import model.EvaluationRule;
import model.User;

public class Test2 implements EvaluationRule<EvaluableUser, User>{

	@Override
	public boolean validateEvaluation(EvaluableUser item, User user) {
		
		if (item.getName() == "Joao"){
			System.out.println("Pode avaliar!");
		}else{
			System.out.println("Nao pode ser avaliado");
			return false;
		}
		
		return true;
	}
	
}
