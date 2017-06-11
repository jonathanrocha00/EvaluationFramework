package modelo;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableUser;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Professor extends EvaluableUser {
	
	private String departamento;
	
	ObjectiveCriterion personalidade = new ObjectiveCriterion(1, "Personalidade", 
			"O quão legal o professor é como pessoa", 0, CriterionType.RATE);
	ObjectiveCriterion provas = new ObjectiveCriterion(2, "Provas", 
			"O quão adequadas são as provas do professor em relação ao que ele ensina em sala", 0, CriterionType.RATE);
	ObjectiveCriterion metodologia = new ObjectiveCriterion(3, "Metodologia", 
			"O quão boa é a metodologia do professor", 0, CriterionType.RATE);
	SubjectiveCriterion comentario = new SubjectiveCriterion(4, "Comentário geral",
			"O que você gostaria de dizer para as outras pessoas sobre este professor de maneira geral", null);
	
	static ArrayList<ObjectiveCriterion> criteriosObjetivosDoProfessor = new ArrayList<ObjectiveCriterion>();
	
	static ArrayList<SubjectiveCriterion> criteriosSubjetivosDoProfessor = new ArrayList<SubjectiveCriterion>();
	
	public Professor(String name, int id, String description, String departamento) {
		
		super(name, id, description, criteriosObjetivosDoProfessor, criteriosSubjetivosDoProfessor);
		
		criteriosObjetivosDoProfessor.add(personalidade);
		criteriosObjetivosDoProfessor.add(provas);
		criteriosObjetivosDoProfessor.add(metodologia);
		
		criteriosSubjetivosDoProfessor.add(comentario);
		
		this.departamento = departamento;
	}
	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}

