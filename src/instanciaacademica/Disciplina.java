package instanciaacademica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Disciplina extends EvaluableItem {
	
	private String departamento;
	
	ObjectiveCriterion dificuldade = new ObjectiveCriterion(5, "Dificuldade", 
			"O qu�o dif�cil � essa disciplina", 0, CriterionType.RATE);
	ObjectiveCriterion relevancia = new ObjectiveCriterion(6, "Relevancia", 
			"O qu�o relevante � essa disciplina para o curr�culo", 0, CriterionType.RATE);
	ObjectiveCriterion dedicacao = new ObjectiveCriterion(7, "Dedicacao", 
			"O quanto voc� precisa se dedicar nessa disciplina", 0, CriterionType.RATE);
	SubjectiveCriterion comentario = new SubjectiveCriterion(8, "Coment�rio geral",
			"O que voc� gostaria de dizer para as outras pessoas sobre esta disciplina de maneira geral", null);
	
	static ArrayList<ObjectiveCriterion> criteriosObjetivosDaDisciplina = new ArrayList<ObjectiveCriterion>();
	
	static ArrayList<SubjectiveCriterion> criteriosSubjetivosDaDisciplina = new ArrayList<SubjectiveCriterion>();
	

	public Disciplina(int id, String name, String departamento) {
		super(id, name, "Disciplina " + name + " do departamento " + departamento, 
				criteriosObjetivosDaDisciplina, criteriosSubjetivosDaDisciplina);
		
		criteriosObjetivosDaDisciplina.add(dificuldade);
		criteriosObjetivosDaDisciplina.add(relevancia);
		criteriosObjetivosDaDisciplina.add(dedicacao);
		
		criteriosSubjetivosDaDisciplina.add(comentario);
		
		this.departamento = departamento;
	}
	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}

