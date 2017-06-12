package controladores;

import java.util.ArrayList;

import model.*;
import modelo.Aluno;
import modelo.Disciplina;
import modelo.Professor;
import service.*;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		EvaluableUserService evaluableUserService = new EvaluableUserService();
		EvaluableItemService evaluableItemService = new EvaluableItemService();
		
		userService.insert(new Aluno("Pedro", 1, 6));
		userService.insert(new Aluno("Davi", 2, 2));
		userService.insert(new Aluno("Lucio", 3, 3));
		
		evaluableUserService.insert(new Professor("Joao", 1, "Prof. do Centro de...", "CCHLA"));
		evaluableUserService.insert(new Professor("Maria", 2, "Prof. do Departamento de Informática...", "DIMAP"));
		evaluableUserService.insert(new Professor("Joana", 3, "Prof. do Centro de...", "CCET"));
		
		evaluableItemService.insert(new Disciplina(9, "FMC", "DIMAP"));
		evaluableItemService.insert(new Disciplina(10, "Literatura", "CCHLA"));
		evaluableItemService.insert(new Disciplina(9, "Física", "CCET"));
		
		System.out.println("=== Bem vindo ao AvAliado ===");
		System.out.println("");
		System.out.println("=== O que deseja avaliar? ===");
<<<<<<< HEAD:instanciaAcademica/controladores/Main.java
		System.out.println("=== Insira [1] para avaliar professores ===");
		System.out.println("=== Insira [2] para avaliar disciplinas ===");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		// Caso tenha escolhido [1] - professores
		if (input == 1) {
			for (int i = 0; i < evaluableUserService.searchAll().size(); i++) {
				System.out.println(evaluableUserService.searchAll().get(i).getId() + " - " + evaluableUserService.searchAll().get(i).getName() + ", " + evaluableUserService.searchAll().get(i).getDescription());
			}
			
			
			
			
			
		}
		// Caso tenha escolhido [1] - disciplinas
		else if (input == 2){
			for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
				System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
			}
			
			
			
			
			
			
		}
		
		// Mostra os itens e usuários que podem ser avaliados
		
		
		
		// Recebe qual item ou usuário será avaliado
		input = scanner.nextInt();
		System.out.println("Você inseriu " + input);
=======
>>>>>>> parent of 74a0b04... Encaminhando Main do Avaliado:src/instanciaacademica/Main.java
		
		for (int i = 0; i < evaluableUserService.searchAll().size(); i++) {
			System.out.println(evaluableUserService.searchAll().get(i).getName() + " - " + evaluableUserService.searchAll().get(i).getDescription());
		}
		for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
			System.out.println(evaluableItemService.searchAll().get(i).getName() + " - " + evaluableItemService.searchAll().get(i).getDescription());
		}
		
	}

}
