package instanciaacademica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Disciplina extends EvaluableItem {
	
	private String departamento;
	
	ObjectiveCriterion dificuldade = new ObjectiveCriterion("Dificuldade", "O quão difícil é essa disciplina", 0, CriterionType.RATE);
	ObjectiveCriterion relevancia = new ObjectiveCriterion("Relevancia", "O quão relevante é essa disciplina para o currículo", 0, CriterionType.RATE);
	ObjectiveCriterion dedicacao = new ObjectiveCriterion("Dedicacao", "O quanto você precisa se dedicar nessa disciplina", 0, CriterionType.RATE);
	SubjectiveCriterion comentario = new SubjectiveCriterion("Comentário geral", "O que você gostaria de dizer para as outras pessoas sobre esta disciplina de maneira geral", null);
	
	ArrayList<ObjectiveCriterion> criteriosObjetivosDaDisciplina = new ArrayList<ObjectiveCriterion>();
	
	ArrayList<SubjectiveCriterion> criteriosSubjetivosDaDisciplina = new ArrayList<SubjectiveCriterion>();
	
	public Disciplina(String name, String departamento) {
		super(name, "disciplina do departamento " + departamento);
		
		criteriosObjetivosDaDisciplina.add(dificuldade);
		criteriosObjetivosDaDisciplina.add(relevancia);
		criteriosObjetivosDaDisciplina.add(dedicacao);
		
		criteriosSubjetivosDaDisciplina.add(comentario);
		
		this.setObjectiveCriteriaToBeEvaluated(criteriosObjetivosDaDisciplina);
		this.setSubjectiveCriteriaToBeEvaluated(criteriosSubjetivosDaDisciplina);
		
		this.departamento = departamento;
	}
	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}

