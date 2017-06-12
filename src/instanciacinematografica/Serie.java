package instanciacinematografica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Serie extends EvaluableItem {

	private int numeroDeEpisodios;
	private String genero;
	
	ObjectiveCriterion recomendacao = new ObjectiveCriterion("Recomendação", "Você gostou da serie?", 0, CriterionType.BOOL);
	
	ObjectiveCriterion personagens = new ObjectiveCriterion("Personagens", "O que achou dos personagens?", 0, CriterionType.BOOL);
	ObjectiveCriterion musicas = new ObjectiveCriterion("Músicas", "As músicas merecem ser baixadas?", 0, CriterionType.BOOL);
	ObjectiveCriterion duracao = new ObjectiveCriterion("Duração", "A série dura o quanto tem que durar?", 0, CriterionType.BOOL);

	SubjectiveCriterion comentario = new SubjectiveCriterion("Comentário geral", "Sua hora de bancar o crítico", null);
	
	ArrayList<ObjectiveCriterion> criteriosObjetivosDaSerie = new ArrayList<ObjectiveCriterion>();

	ArrayList<SubjectiveCriterion> criteriosSubjetivosDaSerie = new ArrayList<SubjectiveCriterion>();
	
	public Serie(String name, int numeroDeEpisodios, String genero) {
		super(name, "Série com " + numeroDeEpisodios + " de " + genero + ".");

		criteriosObjetivosDaSerie.add(personagens);
		criteriosObjetivosDaSerie.add(musicas);
		criteriosObjetivosDaSerie.add(duracao);
		
		criteriosSubjetivosDaSerie.add(comentario);
		
		this.setObjectiveCriteriaToBeEvaluated(criteriosObjetivosDaSerie);
		this.setSubjectiveCriteriaToBeEvaluated(criteriosSubjetivosDaSerie);
		
		this.numeroDeEpisodios = numeroDeEpisodios;
		this.genero = genero;
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
	
}
