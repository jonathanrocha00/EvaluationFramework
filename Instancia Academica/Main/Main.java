package Main;

import java.util.ArrayList;

import modelo.*;
import service.*;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		EvaluableUserService evaluableUserService = new EvaluableUserService();
		EvaluableItemService evaluableItemService = new EvaluableItemService();
		
		userService.insert(new Aluno("Pedro", 6));
		userService.insert(new Aluno("Davi", 2));
		userService.insert(new Aluno("Lucio", 3));
		
		evaluableUserService.insert(new Professor("Joao", "CCHLA"));
		evaluableUserService.insert(new Professor("Maria", "DIMAP"));
		evaluableUserService.insert(new Professor("Joana", "CCET"));
		
		evaluableItemService.insert(new Disciplina(9, "FMC", "DIMAP"));
		evaluableItemService.insert(new Disciplina(10, "Literatura", "CCHLA"));
		evaluableItemService.insert(new Disciplina(9, "Física", "CCET"));
		
		System.out.println("=== Bem vindo ao AvAliado ===");
		System.out.println("");
		System.out.println("=== O que deseja avaliar? ===");
		
		for (int i = 0; i < evaluableUserService.searchAll().size(); i++) {
			System.out.println(evaluableUserService.searchAll().get(i).getName() + " - " + evaluableUserService.searchAll().get(i).getDescription());
		}
		for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
			System.out.println(evaluableItemService.searchAll().get(i).getName() + " - " + evaluableItemService.searchAll().get(i).getDescription());
		}
		
	}

}
