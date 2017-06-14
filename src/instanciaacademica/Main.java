package instanciaacademica;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import control.EvaluationManagerSingleton;
import model.*;
import service.*;

public class Main {
	
	

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		EvaluableUserService evaluableUserService = new EvaluableUserService();
		EvaluableItemService evaluableItemService = new EvaluableItemService();
		
		evaluableUserService.insert(new Professor("Joao", "CCHLA"));
		evaluableUserService.insert(new Professor("Maria", "DIMAP"));
		evaluableUserService.insert(new Professor("Joana", "CCET"));
		
		evaluableItemService.insert(new Disciplina("FMC", "DIMAP"));
		evaluableItemService.insert(new Disciplina("Literatura", "CCHLA"));
		evaluableItemService.insert(new Disciplina("F�sica", "CCET"));
		
		RegraAcademica regra = new RegraAcademica();
		
		Scanner scanner = new Scanner(System.in);
		int inputNum = 0;
		String inputText;
		
		System.out.println("=== Bem vindo ao AvAliado ===");
		System.out.println("");
		
		// Criando um usu�rio para a pessoa que iniciou o sistema
		System.out.println("=== Quem � voc�? ===");
		inputText = scanner.nextLine();
		User usuarioAvaliando = new User(inputText);
		userService.insert(usuarioAvaliando);
		
		while (true) {
			System.out.println("");
			System.out.println("");
			
			// Pergunta ao usu�rio se ele deseja avalair professores ou disciplinas e recebe a resposta
			System.out.println("=== O que deseja fazer? ===");
			System.out.println("=== Insira [1] para avaliar professores ===");
			System.out.println("=== Insira [2] para avaliar disciplinas ===");
			System.out.println("=== Insira [3] para ver avalia��es sobre professores ===");
			System.out.println("=== Insira [4] para ver avalia��es sobre disciplinas ===");
			System.out.println("=== Insira [5] para logar como outro usuario ===");
			
			
			inputText = scanner.nextLine();
			
			inputNum = parseInt(inputText);

			// Caso tenha escolhido [1] - avaliando professores
			if (inputNum == 1) {
				for (int i = 0; i < evaluableUserService.searchAll().size(); i++) {
					System.out.println(evaluableUserService.searchAll().get(i).getId() + " - " + evaluableUserService.searchAll().get(i).getName() + ", " + evaluableUserService.searchAll().get(i).getDescription());
				}
				
				System.out.println("=== Insira o n�mero do professor que deseja avaliar ===");
				
				
				inputText = scanner.nextLine();
				
				inputNum = parseInt(inputText);
				
				EvaluableUser professorSendoAvaliado = evaluableUserService.search(inputNum);
				
				// Professor encontrado
				if (professorSendoAvaliado != null) {
					
					if (regra.validateEvaluation(professorSendoAvaliado, usuarioAvaliando)){
						System.out.println("=== Voc� est� avaliando o(a) professor(a) " + professorSendoAvaliado.getName() + " ===");
						
						// Avaliando crit�rios objetivos
						ArrayList<ObjectiveCriterion> criteriosObjetivos = professorSendoAvaliado.getObjectiveCriteriaToBeEvaluated();
						for (ObjectiveCriterion criterio: criteriosObjetivos) {
							
							// Checa o tipo do crit�rio
							if (criterio.getCriterionType() == CriterionType.RATE) {
								System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com uma nota de 0 a 10 ===");
							}
							else {
								System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com 1 ou 0 ===");
							}
	
							
							inputText = scanner.nextLine();
							
							inputNum = parseInt(inputText);
							
							criterio.setRate(inputNum);
						}
						
						System.out.println("=== Voc� avaliou " + professorSendoAvaliado.getName() + " dessa maneira: ===");
						for (ObjectiveCriterion criterio: criteriosObjetivos) {
							System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
						}
						
						// Avaliando crit�rios subjetivos
						ArrayList<SubjectiveCriterion> criteriosSubjetivos = professorSendoAvaliado.getSubjectiveCriteriaToBeEvaluated();
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
							
							inputText = scanner.nextLine();
							criterio.setComment(inputText);
						}
						System.out.println("=== Voc� avaliou " + professorSendoAvaliado.getName() + " dessa maneira: ===");
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println(">>> " + criterio.getName() + ": ");
							System.out.println(criterio.getComment());
						}
						
						// Criando objeto da avalia��o
						EvaluationManagerSingleton.getInstance().evaluateUser(professorSendoAvaliado, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					}
					
				}
				
				// Professor n�o encontrado
				else {
					System.out.println("=== N�o existe nenhum professor com esse n�mero. Voc� voltar� ao menu inicial. ===");
				}
			}
			
			// Caso tenha escolhido [2] - avaliando disciplinas
			else if (inputNum == 2){
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
				}
				
				System.out.println("=== Insira o n�mero da disciplina que deseja avaliar ===");
				
				inputText = scanner.nextLine();
				
				inputNum = parseInt(inputText);
				
				EvaluableItem disciplinaSendoAvaliada = evaluableItemService.search(inputNum);
				
				// Disciplina encontrada
				if (disciplinaSendoAvaliada != null) {
					
					if (regra.validateEvaluation(disciplinaSendoAvaliada, usuarioAvaliando)){
						System.out.println("=== Voc� est� avaliando a disciplina " + disciplinaSendoAvaliada.getName() + " ===");
						
						// Avaliando crit�rios objetivos
						ArrayList<ObjectiveCriterion> criteriosObjetivos = disciplinaSendoAvaliada.getObjectiveCriteriaToBeEvaluated();
						for (ObjectiveCriterion criterio: criteriosObjetivos) {
							
							// Checa o tipo do crit�rio
							if (criterio.getCriterionType() == CriterionType.RATE) {
								System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com uma nota de 0 a 10 ===");
							}
							else {
								System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com 1 ou 0 ===");
							}
							
							inputText = scanner.nextLine();
							
							inputNum = parseInt(inputText);
							
							criterio.setRate(inputNum);
						}
						
						System.out.println("=== Voc� avaliou " + disciplinaSendoAvaliada.getName() + " dessa maneira: ===");
						for (ObjectiveCriterion criterio: criteriosObjetivos) {
							System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
						}
						
						// Avaliando crit�rios subjetivos
						ArrayList<SubjectiveCriterion> criteriosSubjetivos = disciplinaSendoAvaliada.getSubjectiveCriteriaToBeEvaluated();
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
							
							
							inputText = scanner.nextLine();
							
							criterio.setComment(inputText);
						}
						System.out.println("=== Voc� avaliou " + disciplinaSendoAvaliada.getName() + " dessa maneira: ===");
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println(">>> " + criterio.getName() + ": ");
							System.out.println(criterio.getComment());
						}
						
						// Criando objeto da avalia��o
						EvaluationManagerSingleton.getInstance().evaluateItem(disciplinaSendoAvaliada, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					}
				}
				
				// Disciplina n�o encontrada
				else {
					System.out.println("=== N�o existe nenhuma disciplina com esse n�mero. Voc� voltar� ao menu inicial. ===");
				}			
			}
			
			// Caso tenha escolhido [3] - ver avalia��es de professores
			else if (inputNum == 3){
				EvaluationManagerSingleton.getInstance().printUserEvaluations(Professor.class);
			}
			
			// Caso tenha escolhido [4] - ver avalia��es de disciplinas
			else if (inputNum == 4){
				EvaluationManagerSingleton.getInstance().printItemEvaluations(Disciplina.class);
			}
			
			// Caso tenha escolhido [5] - trocar de usu�rio
			else if (inputNum == 5) {
				usuarioAvaliando = logarComNovoUsuario(userService, scanner);
			}
			
			// Caso tenha sido escolhido numero inexistente
			else{
				System.out.println("=== N�o existe essa op��o no menu. ===");
			}
		}
		
		
		
	}

	private static User logarComNovoUsuario(UserService userService, Scanner scanner) {
		String inputText;
		User usuarioAvaliando;
		System.out.println("=== Quem � voc�? ===");
		
		inputText = scanner.nextLine();
		
		usuarioAvaliando = new User(inputText);
		userService.insert(usuarioAvaliando);
		return usuarioAvaliando;
	}
	
	public static int parseInt(String opcao){
		Scanner scn = new Scanner(System.in);
		
		while(!opcao.matches("^\\d+(\\.\\d+)?")){
			System.out.println("=== N�o existe essa op��o no menu. ===");
			opcao = scn.nextLine();
		}
		return Integer.parseInt(opcao);
	}
}
