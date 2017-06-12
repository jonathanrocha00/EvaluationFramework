package instanciacinematografica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Filme extends EvaluableItem {

	private int ano;
	private String diretor;

	ObjectiveCriterion recomendacao = new ObjectiveCriterion("Recomendação", "Você gostou do filme?", 0, CriterionType.BOOL);
	ObjectiveCriterion atuacao = new ObjectiveCriterion("Atuação", "Os atores te convenceram?", 0, CriterionType.BOOL);
	ObjectiveCriterion trilhaSonora = new ObjectiveCriterion("Trilha Sonora", "Os sons se encaixavam nas cenas?", 0, CriterionType.BOOL);
	ObjectiveCriterion direcao = new ObjectiveCriterion("Direção", "E o diretor? Soube fazer seu papel?", 0, CriterionType.BOOL);

	SubjectiveCriterion comentario = new SubjectiveCriterion("Comentário geral", "Sua hora de bancar o crítico", null);

	ArrayList<ObjectiveCriterion> criteriosObjetivosDoFilme = new ArrayList<ObjectiveCriterion>();

	ArrayList<SubjectiveCriterion> criteriosSubjetivosDoFilme = new ArrayList<SubjectiveCriterion>();

	public Filme(int id, String name, int ano, String diretor) {
		super(name, "Filme de " + ano + " dirigindo por " + diretor + ".");
		
		criteriosObjetivosDoFilme.add(recomendacao);
		criteriosObjetivosDoFilme.add(atuacao);
		criteriosObjetivosDoFilme.add(direcao);
		
		criteriosSubjetivosDoFilme.add(comentario);
		
		this.setObjectiveCriteriaToBeEvaluated(criteriosObjetivosDoFilme);
		this.setSubjectiveCriteriaToBeEvaluated(criteriosSubjetivosDoFilme);
		
		
		this.ano = ano;
		this.diretor = diretor;
	}
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

}
