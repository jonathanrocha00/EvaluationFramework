package instanciacinematografica;

import model.EvaluationRule;

public class RegraCinematografica implements EvaluationRule<Object, Object>{

	@Override
	public boolean validateEvaluation(Object item, Object user) {
		
		if (item instanceof Filme){
			if (((Espectador) user).getIdade() < ((Filme) item).getClassificacao()){
				System.out.println("Avaliacao nao permitida, o usuario nao tem idade suficiente para avaliar este filme");
				return false;
			}else{
				return true;
			}
		}else if (item instanceof Desenho){
			if (((Espectador) user).getIdade() < ((Desenho) item).getClassificacao()){
				System.out.println("Avaliacao nao permitida, o usuario nao tem idade suficiente para avaliar este desenho");
				return false;
			}else{
				return true;
			}
		}else if (item instanceof Serie){
			if (((Espectador) user).getIdade() < ((Serie) item).getClassificacao()){
				System.out.println("Avaliacao nao permitida, o usuario nao tem idade suficiente para avaliar esta serie");
				return false;
			}else if (((Espectador) user).getIdade() >= ((Serie) item).getClassificacao()){
				return true;
			}
		}
		
		return false;
	}
	

}
