package instanciacinematografica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Filme extends EvaluableItem {

	private int ano;
	private String diretor;
	private int classificacao;

	ObjectiveCriterion recomendacao = new ObjectiveCriterion("Recomendacao", "Voce gostou do filme?", 0, CriterionType.BOOL);
	ObjectiveCriterion atuacao = new ObjectiveCriterion("Atuacao", "Os atores te convenceram?", 0, CriterionType.BOOL);
	ObjectiveCriterion trilhaSonora = new ObjectiveCriterion("Trilha Sonora", "Os sons se encaixavam nas cenas?", 0, CriterionType.BOOL);
	ObjectiveCriterion direcao = new ObjectiveCriterion("Direcao", "E o diretor? Soube fazer seu papel?", 0, CriterionType.BOOL);

	SubjectiveCriterion comentario = new SubjectiveCriterion("Comenterio geral", "Sua hora de bancar o critico", null);

	ArrayList<ObjectiveCriterion> criteriosObjetivosDoFilme = new ArrayList<ObjectiveCriterion>();

	ArrayList<SubjectiveCriterion> criteriosSubjetivosDoFilme = new ArrayList<SubjectiveCriterion>();

	public Filme(String name, int ano, String diretor, int classificacao) {
		super(name, "Filme de " + ano + " dirigindo por " + diretor + "com classificacao +" + classificacao + ".");
		
		criteriosObjetivosDoFilme.add(recomendacao);
		criteriosObjetivosDoFilme.add(atuacao);
		criteriosObjetivosDoFilme.add(trilhaSonora);
		criteriosObjetivosDoFilme.add(direcao);
		
		criteriosSubjetivosDoFilme.add(comentario);
		
		this.setObjectiveCriteriaToBeEvaluated(criteriosObjetivosDoFilme);
		this.setSubjectiveCriteriaToBeEvaluated(criteriosSubjetivosDoFilme);
		
		this.ano = ano;
		this.diretor = diretor;
		this.classificacao = classificacao;
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

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	
	static public Filme clone(Filme filme) {
		Filme retorno = new Filme(filme.name, filme.ano, filme.diretor, filme.classificacao);
		return retorno;
	}

}
