package instanciaturistica;

import model.User;

public class Usuario extends User {

	private String cidade;

	public Usuario(String name, String cidade) {
		super(name);
		
		this.cidade = cidade;
	}
	
	public String getLugar() {
		return cidade;
	}

	public void setLugar(String lugar) {
		this.cidade = lugar;
	}

}
