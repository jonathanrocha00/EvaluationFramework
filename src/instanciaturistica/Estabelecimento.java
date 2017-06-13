package instanciaturistica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableUser;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Estabelecimento extends EvaluableUser {

	private String tipo;
	private String cidade;
	
	ObjectiveCriterion recomendacao = new ObjectiveCriterion("Recomendação", "Você recomendaria este estabelecimento?", 0, CriterionType.BOOL);
	ObjectiveCriterion preco = new ObjectiveCriterion("Preço", "O quão caro é esse lugar?", 0, CriterionType.RATE);
	ObjectiveCriterion acessibilidade = new ObjectiveCriterion("Acessibilidade", "Este estabelecimento é acessível?", 0, CriterionType.BOOL);

	SubjectiveCriterion comentario = new SubjectiveCriterion("Comentário geral", "O que você achou da experiência nesse estabelecimento?", null);

	ArrayList<ObjectiveCriterion> criteriosObjetivosDoEstabalecimento = new ArrayList<ObjectiveCriterion>();

	ArrayList<SubjectiveCriterion> criteriosSubjetivosDoEstabalecimento = new ArrayList<SubjectiveCriterion>();
	
	public Estabelecimento(String name, String cidade, String tipo) {
		super(name, tipo + " localizado na cidade de " + cidade);

		criteriosObjetivosDoEstabalecimento.add(recomendacao);
		criteriosObjetivosDoEstabalecimento.add(preco);
		criteriosObjetivosDoEstabalecimento.add(acessibilidade);
		
		criteriosSubjetivosDoEstabalecimento.add(comentario);
		
		this.setObjectiveCriteriaToBeEvaluated(criteriosObjetivosDoEstabalecimento);
		this.setSubjectiveCriteriaToBeEvaluated(criteriosSubjetivosDoEstabalecimento);
		
		this.cidade = cidade;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
