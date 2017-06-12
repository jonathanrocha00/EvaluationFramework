package instanciaacademica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.*;
import service.*;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		EvaluableUserService evaluableUserService = new EvaluableUserService();
		EvaluableItemService evaluableItemService = new EvaluableItemService();
		UserEvaluationService userEvaluationService = new UserEvaluationService();
		ItemEvaluationService itemEvaluationService = new ItemEvaluationService();
		
		evaluableUserService.insert(new Professor("Joao", "CCHLA"));
		evaluableUserService.insert(new Professor("Maria", "DIMAP"));
		evaluableUserService.insert(new Professor("Joana", "CCET"));
		
		evaluableItemService.insert(new Disciplina("FMC", "DIMAP"));
		evaluableItemService.insert(new Disciplina("Literatura", "CCHLA"));
		evaluableItemService.insert(new Disciplina("F�sica", "CCET"));
		
		Scanner scanner = new Scanner(System.in);
		int inputNum;
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
			System.out.println("=== Insira [4] para logar como outro usuario ===");
			inputNum = scanner.nextInt();
			
			// Caso tenha escolhido [1] - avaliando professores
			if (inputNum == 1) {
				for (int i = 0; i < evaluableUserService.searchAll().size(); i++) {
					System.out.println(evaluableUserService.searchAll().get(i).getId() + " - " + evaluableUserService.searchAll().get(i).getName() + ", " + evaluableUserService.searchAll().get(i).getDescription());
				}
				
				System.out.println("=== Insira o n�mero do professor que deseja avaliar ===");
				
				inputNum = scanner.nextInt();
				
				EvaluableUser professorSendoAvaliado = evaluableUserService.search(inputNum);
				
				// Professor encontrado
				if (professorSendoAvaliado != null) {
					
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

						inputNum = scanner.nextInt();
						
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
						
						// Precisa disso pro Java ler a linha certa (aiai Java...)
						String clearBuffer = scanner.nextLine();
						
						inputText = scanner.nextLine();
						
						criterio.setComment(inputText);
					}
					System.out.println("=== Voc� avaliou " + professorSendoAvaliado.getName() + " dessa maneira: ===");
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println(">>> " + criterio.getName() + ": ");
						System.out.println(criterio.getComment());
					}
					
					// Criando objeto da avalia��o
					UserEvaluation avaliacao = new UserEvaluation(professorSendoAvaliado, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					
					userEvaluationService.insert(avaliacao);
					
				}
				
				// Professor n�o encontrado
				else {
					System.out.println("=== N�o existe nenhum professor com esse n�mero. O sistema ser� encerrado. ===");
				}
			}
			
			// Caso tenha escolhido [2] - avaliando disciplinas
			else if (inputNum == 2){
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
				}
				
				System.out.println("=== Insira o n�mero da disciplina que deseja avaliar ===");
				
				inputNum = scanner.nextInt();
				
				EvaluableItem disciplinaSendoAvaliada = evaluableItemService.search(inputNum);
				
				// Disciplina encontrado
				if (disciplinaSendoAvaliada != null) {
					
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
						
						inputNum = scanner.nextInt();
						
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
						
						// Precisa disso pro Java ler a linha certa (aiai Java...)
						String clearBuffer = scanner.nextLine();
						
						inputText = scanner.nextLine();
						
						criterio.setComment(inputText);
					}
					System.out.println("=== Voc� avaliou " + disciplinaSendoAvaliada.getName() + " dessa maneira: ===");
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println(">>> " + criterio.getName() + ": ");
						System.out.println(criterio.getComment());
					}
					
					// Criando objeto da avalia��o
					ItemEvaluation avaliacao = new ItemEvaluation(disciplinaSendoAvaliada, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					
					itemEvaluationService.insert(avaliacao);
					
				}
				
				// Disciplina n�o encontrada
				else {
					System.out.println("=== N�o existe nenhuma disciplina com esse n�mero. O sistema ser� encerrado. ===");
				}			
			}
			
			// Caso tenha escolhido [2] - ver avalia��es de professores
			else if (inputNum == 3){
				
				System.out.println("=== Mostrando avalia��es feitas sobre professores... ===");
				
				ArrayList<UserEvaluation> avaliacoesDeProfessores = (ArrayList<UserEvaluation>) userEvaluationService.searchAll();
				
				for (UserEvaluation avaliacao: avaliacoesDeProfessores) {
					System.out.println("Avalia��o feita por " + avaliacao.getUser().getName() + " sobre o professor " + avaliacao.getEvaluatedItem().getName());
				}
			}
			
			// Caso tenha escolhido [4] - ver avalia��es de professores
			else if (inputNum == 4){
				
				System.out.println("=== Mostrando avalia��es feitas sobre disciplinas... ===");
				
				ArrayList<ItemEvaluation> avaliacoesDeDisciplinas = (ArrayList<ItemEvaluation>) itemEvaluationService.searchAll();
				
				for (ItemEvaluation avaliacao: avaliacoesDeDisciplinas) {
					System.out.println("Avalia��o feita por " + avaliacao.getUser().getName() + " sobre o professor " + avaliacao.getEvaluatedItem().getName());
				}
			}
			
			else if (inputNum == 5) {
				System.out.println("=== Quem � voc�? ===");
				inputText = scanner.nextLine();
				usuarioAvaliando = new User(inputText);
				userService.insert(usuarioAvaliando);
			}
			
			// Caso tenha sido escolhido numero inexistente
			else {
				System.out.println("=== N�o existe essa op��o no menu. ===");
			}
		}
		
		
		
	}
}
