package instanciaturistica;

import java.util.ArrayList;

import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;

public class Estabelecimento extends EvaluableItem {

	private String tipo;
	private String cidade;
	
	ObjectiveCriterion recomendacao = new ObjectiveCriterion("Recomenda��o", "Voc� recomendaria este estabelecimento?", 0, CriterionType.BOOL);
	ObjectiveCriterion preco = new ObjectiveCriterion("Pre�o", "O qu�o caro � esse lugar?", 0, CriterionType.RATE);
	ObjectiveCriterion acessibilidade = new ObjectiveCriterion("Acessibilidade", "Este estabelecimento � acess�vel?", 0, CriterionType.BOOL);

	SubjectiveCriterion comentario = new SubjectiveCriterion("Coment�rio geral", "O que voc� achou da experi�ncia nesse estabelecimento?", null);

	ArrayList<ObjectiveCriterion> criteriosObjetivosDoEstabalecimento = new ArrayList<ObjectiveCriterion>();

	ArrayList<SubjectiveCriterion> criteriosSubjetivosDoEstabalecimento = new ArrayList<SubjectiveCriterion>();
	
	public Estabelecimento(String name, String cidade, String tipo) {
		super(name, tipo + " localizado em " + cidade);

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
	
	static public Estabelecimento clone(Estabelecimento estabelecimento) {
		Estabelecimento retorno = new Estabelecimento(estabelecimento.name, estabelecimento.cidade, estabelecimento.tipo);
		return retorno;
	}
}
