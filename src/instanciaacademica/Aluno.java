package instanciaacademica;

import model.User;

public class Aluno extends User {
	
	private int periodo;
	
	public Aluno(String name, int id, int periodo) {
		super(name, id);
		this.periodo = periodo;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

}
