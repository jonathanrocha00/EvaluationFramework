package instanciacinematografica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Desenho extends EvaluableItem{
	
	private int ano;
	private String estudio;
	private int classificacao;
	
	ObjectiveCriterion recomendacao = new ObjectiveCriterion("Recomendação", "Você gostou do desenho?", 0, CriterionType.BOOL);
	ObjectiveCriterion qualidade = new ObjectiveCriterion("Qualidade", "Qual a nota para a qualidade desta animação?", 0, CriterionType.RATE);
	ObjectiveCriterion personagens = new ObjectiveCriterion("Personagens", "O que achou dos personagens?", 0, CriterionType.RATE);
	ObjectiveCriterion episodios = new ObjectiveCriterion("Episódios", "Que nota você daria para os episódios no geral?", 0, CriterionType.RATE);
	
	SubjectiveCriterion comentario = new SubjectiveCriterion("Coment�rio geral", "Sua hora de bancar o cr�tico", null);
	
	ArrayList<ObjectiveCriterion> criteriosObjetivosDoDesenho = new ArrayList<ObjectiveCriterion>();

	ArrayList<SubjectiveCriterion> criteriosSubjetivosDoDesenho = new ArrayList<SubjectiveCriterion>();

	public Desenho(String name, int ano, String estudio, int classificacao) {
		super(name, "Desenho do(a) " + estudio + ", criado em " + ano + " com classificação +" + classificacao + ".");
		
		criteriosObjetivosDoDesenho.add(recomendacao);
		criteriosObjetivosDoDesenho.add(qualidade);
		criteriosObjetivosDoDesenho.add(personagens);
		criteriosObjetivosDoDesenho.add(episodios);
		
		criteriosSubjetivosDoDesenho.add(comentario);
		
		this.setSubjectiveCriteriaToBeEvaluated(criteriosSubjetivosDoDesenho);
		this.setObjectiveCriteriaToBeEvaluated(criteriosObjetivosDoDesenho);
		
		this.ano = ano;
		this.estudio = estudio;
		this.classificacao = classificacao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	
	static public Desenho clone(Desenho desenho) {
		Desenho retorno = new Desenho(desenho.name, desenho.ano, desenho.estudio, desenho.classificacao);
		return retorno;
	}

}
