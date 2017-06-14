package instanciaacademica;

import model.EvaluationRule;

public class RegraAcademica implements EvaluationRule<Object, Object>{

	@Override
	public boolean validateEvaluation(Object item, Object user) {
		
		if (user instanceof Professor && item instanceof Professor){
			System.out.println("Avaliacao nao permitida, professor nao tem competencia para avaliar outro.");
			return false;
		}
		
		return true;
	}

}
