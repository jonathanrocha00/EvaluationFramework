package instanciaacademica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableUser;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Professor extends EvaluableUser {
	
	private String departamento;
	
	ObjectiveCriterion personalidade = new ObjectiveCriterion("Personalidade", "O quao legal o professor eh como pessoa", 0, CriterionType.RATE);
	ObjectiveCriterion provas = new ObjectiveCriterion("Provas", "O quao adequadas sao as provas do professor em relacao ao que ele ensina em sala", 0, CriterionType.RATE);
	ObjectiveCriterion metodologia = new ObjectiveCriterion("Metodologia", "O quao boa eh a metodologia do professor", 0, CriterionType.RATE);
	SubjectiveCriterion comentario = new SubjectiveCriterion("Comentario geral", "O que voce gostaria de dizer para as outras pessoas sobre este professor de maneira geral", null);
	
	ArrayList<ObjectiveCriterion> criteriosObjetivosDoProfessor = new ArrayList<ObjectiveCriterion>();
	
	ArrayList<SubjectiveCriterion> criteriosSubjetivosDoProfessor = new ArrayList<SubjectiveCriterion>();
	
	public Professor(String name, String departamento) {
		
		super(name, "professor do departamento " + departamento);
		
		criteriosObjetivosDoProfessor.add(personalidade);		
		criteriosObjetivosDoProfessor.add(provas);
		criteriosObjetivosDoProfessor.add(metodologia);
		
		criteriosSubjetivosDoProfessor.add(comentario);
		
		this.setObjectiveCriteriaToBeEvaluated(criteriosObjetivosDoProfessor);
		this.setSubjectiveCriteriaToBeEvaluated(criteriosSubjetivosDoProfessor);
		
		this.departamento = departamento;
	}
	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	static public Professor clone(Professor professor) {
		Professor retorno = new Professor(professor.name, professor.departamento);
		return retorno;
	}
}

