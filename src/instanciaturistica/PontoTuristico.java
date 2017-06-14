package instanciaturistica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class PontoTuristico extends EvaluableItem {
	
	private String cidade;

	ObjectiveCriterion recomendacao = new ObjectiveCriterion("Recomenda��o", "Voc� recomendaria este lugar?", 0, CriterionType.BOOL);
	ObjectiveCriterion periculosidade = new ObjectiveCriterion("Periculosidade", "Este lugar � perigoso?", 0, CriterionType.BOOL);
	ObjectiveCriterion acessibilidade = new ObjectiveCriterion("Acessibilidade", "Este lugar � acess�vel?", 0, CriterionType.BOOL);

	SubjectiveCriterion comentario = new SubjectiveCriterion("Coment�rio geral", "O que voc� achou da experi�ncia nesse local?", null);

	ArrayList<ObjectiveCriterion> criteriosObjetivosDoPontoTuristico = new ArrayList<ObjectiveCriterion>();

	ArrayList<SubjectiveCriterion> criteriosSubjetivosDoPontoTuristico = new ArrayList<SubjectiveCriterion>();
	
	public PontoTuristico(String name, String cidade) {
		super(name, "localizado em " + cidade);
		
		criteriosObjetivosDoPontoTuristico.add(acessibilidade);
		criteriosObjetivosDoPontoTuristico.add(periculosidade);
		criteriosObjetivosDoPontoTuristico.add(recomendacao);
		
		criteriosSubjetivosDoPontoTuristico.add(comentario);
		
		this.setObjectiveCriteriaToBeEvaluated(criteriosObjetivosDoPontoTuristico);
		this.setSubjectiveCriteriaToBeEvaluated(criteriosSubjetivosDoPontoTuristico);

		this.cidade = cidade;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	static public PontoTuristico clone(PontoTuristico pontoTuristico) {
		PontoTuristico retorno = new PontoTuristico(pontoTuristico.name, pontoTuristico.cidade);
		return retorno;
	}

}
