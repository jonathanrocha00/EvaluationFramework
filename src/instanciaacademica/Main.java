package instanciaacademica;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;
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
		evaluableItemService.insert(new Disciplina(50, "Física", "CCET"));
		
		System.out.println("=== Bem vindo ao AvAliado ===");
		System.out.println("");
		
		// Pergunta ao usuário se ele deseja avalair professores ou disciplinas e recebe a resposta
		System.out.println("=== O que deseja avaliar? ===");
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
		else if (input == 2){
			for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
				System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
			}
			
			
			
			
			
			
		}
		
		// Mostra os itens e usuários que podem ser avaliados
		
		
		
		// Recebe qual item ou usuário será avaliado
		// Scanner scanner = new Scanner(System.in);
		// int input = scanner.nextInt();
		System.out.println("Você inseriu " + input);
		
		for (int i = 0; i < evaluableUserService.searchAll().size(); i++) {
			if (evaluableUserService.searchAll().get(i).getId() == input) {
				EvaluableUser usuarioSendoAvaliado = evaluableUserService.searchAll().get(i);
			}
		}
		for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
			if (evaluableItemService.searchAll().get(i).getId() == input) {
				EvaluableItem itemSendoAvaliado = evaluableItemService.searchAll().get(i);
			}
		}
		
		System.out.println("=== Você quer avaliar o ");
	}

}
