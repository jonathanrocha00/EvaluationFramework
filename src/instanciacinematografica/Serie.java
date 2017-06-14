package instanciacinematografica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Serie extends EvaluableItem {

	private int numeroDeEpisodios;
	private String genero;
	private int classificacao;
	
	ObjectiveCriterion recomendacao = new ObjectiveCriterion("Recomendacao", "Voce gostou da serie?", 0, CriterionType.BOOL);
	ObjectiveCriterion personagens = new ObjectiveCriterion("Personagens", "O que achou dos personagens?", 0, CriterionType.RATE);
	ObjectiveCriterion musicas = new ObjectiveCriterion("Musicas", "As musicas merecem ser baixadas?", 0, CriterionType.BOOL);
	ObjectiveCriterion duracao = new ObjectiveCriterion("Duracao", "A serie dura o quanto tem que durar?", 0, CriterionType.BOOL);

	SubjectiveCriterion comentario = new SubjectiveCriterion("Comentario geral", "Sua hora de bancar o critico", null);
	
	ArrayList<ObjectiveCriterion> criteriosObjetivosDaSerie = new ArrayList<ObjectiveCriterion>();

	ArrayList<SubjectiveCriterion> criteriosSubjetivosDaSerie = new ArrayList<SubjectiveCriterion>();
	
	public Serie(String name, int numeroDeEpisodios, String genero, int classificacao) {
		super(name, "Serie com " + numeroDeEpisodios + " de " + genero + " e classificacao +" + classificacao + ".");

		criteriosObjetivosDaSerie.add(recomendacao);
		criteriosObjetivosDaSerie.add(personagens);
		criteriosObjetivosDaSerie.add(musicas);
		criteriosObjetivosDaSerie.add(duracao);
		
		criteriosSubjetivosDaSerie.add(comentario);
		
		this.setObjectiveCriteriaToBeEvaluated(criteriosObjetivosDaSerie);
		this.setSubjectiveCriteriaToBeEvaluated(criteriosSubjetivosDaSerie);
		
		this.numeroDeEpisodios = numeroDeEpisodios;
		this.genero = genero;
		this.classificacao = classificacao;
	}
	
	public int getNumeroDeEpisodios() {
		return numeroDeEpisodios;
	}

	public void setNumeroDeEpisodios(int numeroDeEpisodios) {
		this.numeroDeEpisodios = numeroDeEpisodios;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	
	static public Serie clone(Serie serie) {
		Serie retorno = new Serie(serie.name, serie.numeroDeEpisodios, serie.genero, serie.classificacao);
		return retorno;
	}
	
}
