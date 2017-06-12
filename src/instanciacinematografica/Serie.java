package instanciacinematografica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Serie extends EvaluableItem {

	private int numeroDeEpisodios;
	private String genero;
	
	ObjectiveCriterion recomendacao = new ObjectiveCriterion(15, "Recomenda��o", "Voc� gostou da serie?", 0, CriterionType.BOOL);
	
	ObjectiveCriterion personagens = new ObjectiveCriterion(16, "Personagens", "O que achou dos personagens?", 0, CriterionType.BOOL);
	ObjectiveCriterion musicas = new ObjectiveCriterion(17, "M�sicas", "As m�sicas merecem ser baixadas?", 0, CriterionType.BOOL);
	ObjectiveCriterion duracao = new ObjectiveCriterion(18, "Dura��o", "A s�rie dura o quanto tem que durar?", 0, CriterionType.BOOL);

	SubjectiveCriterion comentario = new SubjectiveCriterion(12, "Coment�rio geral", "Sua hora de bancar o cr�tico", null);
	
	static ArrayList<ObjectiveCriterion> criteriosObjetivosDaSerie = new ArrayList<ObjectiveCriterion>();

	static ArrayList<SubjectiveCriterion> criteriosSubjetivosDaSerie = new ArrayList<SubjectiveCriterion>();
	
	public Serie(int id, String name, int numeroDeEpisodios, String genero) {
		super(id, name, "S�rie com " + numeroDeEpisodios + " de " + genero + ".", criteriosObjetivosDaSerie, criteriosSubjetivosDaSerie);

		criteriosObjetivosDaSerie.add(personagens);
		criteriosObjetivosDaSerie.add(musicas);
		criteriosObjetivosDaSerie.add(duracao);
		
		criteriosSubjetivosDaSerie.add(comentario);
		
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
