package instanciaturistica;

import model.EvaluationRule;

public class RegraTuristica implements EvaluationRule<Object, Object>{

	@Override
	public boolean validateEvaluation(Object item, Object user) {
		//Caso houvesse regra, seria tratada aqui
		return true;
	}

}
