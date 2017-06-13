package instanciacinematografica;

import model.User;

public class Espectador extends User{
	
	private int idade;

	public Espectador(String name, int idade) {
		super(name);
		this.idade = idade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
