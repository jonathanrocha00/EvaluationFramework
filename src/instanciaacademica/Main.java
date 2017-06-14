package instanciaacademica;

import java.util.ArrayList;
import java.util.Date;
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
		evaluableItemService.insert(new Disciplina("Fisica", "CCET"));
		
		RegraAcademica regra = new RegraAcademica();
		User usuarioAvaliando = null;
		
		Scanner scanner = new Scanner(System.in);
		int inputNum = 0;
		String inputText;
		String inputText2;
		
		System.out.println("=== Bem vindo ao AvAliado ===");
		System.out.println("");
		
		// Criando um usu�rio para a pessoa que iniciou o sistema
		System.out.println("=== Voce e 1 - aluno, 2 - professor? ===");
		inputText = scanner.nextLine();
		while(!inputText.equals("1") && !inputText.equals("2")){
			System.out.println("=== Valor invalido, tente novamente. 1 - aluno, 2 - professor ===");
			inputText = scanner.nextLine();
		}
		
		System.out.println("=== Quem eh voce? ===");
		
		if (inputText.equals("1")){
			inputText = scanner.nextLine();
			System.out.println("=== Qual o seu periodo? ===");
			inputText2 = scanner.nextLine();
			usuarioAvaliando = new Aluno(inputText, Integer.parseInt(inputText2));
			userService.insert(usuarioAvaliando);
		}else if (inputText.equals("2")){
			inputText = scanner.nextLine();
			System.out.println("=== Qual o seu departamento? ===");
			inputText2 = scanner.nextLine();
			usuarioAvaliando = new Professor(inputText, inputText2);
			userService.insert(usuarioAvaliando);
			evaluableUserService.insert((Professor) usuarioAvaliando);
		}
		
		while (true) {
			System.out.println("");
			System.out.println("");
			
			// Pergunta ao usuurio se ele deseja avalair professores ou disciplinas e recebe a resposta
			System.out.println("=== O que deseja fazer? ===");
			System.out.println("=== Insira [1] para avaliar professores ===");
			System.out.println("=== Insira [2] para avaliar disciplinas ===");
			System.out.println("=== Insira [3] para ver avaliacoes sobre professores ===");
			System.out.println("=== Insira [4] para ver avaliacoes sobre disciplinas ===");
			System.out.println("=== Insira [5] para logar como outro usuario ===");
			
			
			inputText = scanner.nextLine();
			
			inputNum = parseInt(inputText);

			// Caso tenha escolhido [1] - avaliando professores
			if (inputNum == 1) {
				for (int i = 0; i < evaluableUserService.searchAll().size(); i++) {
					System.out.println(evaluableUserService.searchAll().get(i).getId() + " - " + evaluableUserService.searchAll().get(i).getName() + ", " + evaluableUserService.searchAll().get(i).getDescription());
				}
				
				System.out.println("=== Insira o numero do professor que deseja avaliar ===");
				
				
				inputText = scanner.nextLine();
				
				inputNum = parseInt(inputText);
				
				EvaluableUser professorSendoAvaliado = evaluableUserService.search(inputNum);
				
				// Professor encontrado
				if (professorSendoAvaliado != null) {
					
					// Clona o objeto a ser avaliado para nao modificar o original
					professorSendoAvaliado = Professor.clone((Professor) professorSendoAvaliado);
					
					if (regra.validateEvaluation(professorSendoAvaliado, usuarioAvaliando)){
						System.out.println("=== Voce esta avaliando o(a) professor(a) " + professorSendoAvaliado.getName() + " ===");
						
						// Avaliando criterios objetivos
						ArrayList<ObjectiveCriterion> criteriosObjetivos = professorSendoAvaliado.getObjectiveCriteriaToBeEvaluated();
						for (ObjectiveCriterion criterio: criteriosObjetivos) {
							
							// Checa o tipo do criterio
							if (criterio.getCriterionType() == CriterionType.RATE) {
								System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com uma nota de 0 a 10 ===");
							}
							else {
								System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com 1 ou 0 ===");
							}
	
							
							inputText = scanner.nextLine();
							inputNum = parseInt(inputText);
							while (!EvaluationManagerSingleton.getInstance().validateRate(inputNum, criterio.getCriterionType())){
								System.out.println("=== Valor invalido para este tipo de avaliacao. ===");
								inputText = scanner.nextLine();
								inputNum = parseInt(inputText);
							}
							criterio.setRate(inputNum);
						}
						
						System.out.println("=== Voce avaliou " + professorSendoAvaliado.getName() + " dessa maneira: ===");
						for (ObjectiveCriterion criterio: criteriosObjetivos) {
							System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
						}
						
						// Avaliando criterios subjetivos
						ArrayList<SubjectiveCriterion> criteriosSubjetivos = professorSendoAvaliado.getSubjectiveCriteriaToBeEvaluated();
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
							
							inputText = scanner.nextLine();
							criterio.setComment(inputText);
						}
						System.out.println("=== Voce avaliou " + professorSendoAvaliado.getName() + " dessa maneira: ===");
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println(">>> " + criterio.getName() + ": ");
							System.out.println(criterio.getComment());
						}
						
						// Criando objeto da avaliacao
						EvaluationManagerSingleton.getInstance().evaluateUser(professorSendoAvaliado, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					}
					
				}
				
				// Professor nao encontrado
				else {
					System.out.println("=== Nao existe nenhum professor com esse numero. Voce voltara ao menu inicial. ===");
				}
			}
			
			// Caso tenha escolhido [2] - avaliando disciplinas
			else if (inputNum == 2){
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
				}
				
				System.out.println("=== Insira o numero da disciplina que deseja avaliar ===");
				
				inputText = scanner.nextLine();
				
				inputNum = parseInt(inputText);
				
				EvaluableItem disciplinaSendoAvaliada = evaluableItemService.search(inputNum);
				
				// Disciplina encontrada
				if (disciplinaSendoAvaliada != null) {
					
					// Clona o objeto a ser avaliado para não modificar o original
					disciplinaSendoAvaliada = Disciplina.clone((Disciplina)disciplinaSendoAvaliada);
					
					if (regra.validateEvaluation(disciplinaSendoAvaliada, usuarioAvaliando)){
						System.out.println("=== Voce esta avaliando a disciplina " + disciplinaSendoAvaliada.getName() + " ===");
						
						// Avaliando criterios objetivos
						ArrayList<ObjectiveCriterion> criteriosObjetivos = disciplinaSendoAvaliada.getObjectiveCriteriaToBeEvaluated();
						for (ObjectiveCriterion criterio: criteriosObjetivos) {
							
							// Checa o tipo do criterio
							if (criterio.getCriterionType() == CriterionType.RATE) {
								System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com uma nota de 0 a 10 ===");
							}
							else {
								System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com 1 ou 0 ===");
							}
							
							inputText = scanner.nextLine();
							inputNum = parseInt(inputText);
							while (!EvaluationManagerSingleton.getInstance().validateRate(inputNum, criterio.getCriterionType())){
								System.out.println("=== Valor invalido para este tipo de avaliacao. ===");
								inputText = scanner.nextLine();
								inputNum = parseInt(inputText);
							}
							criterio.setRate(inputNum);
						}
						
						System.out.println("=== Voce avaliou " + disciplinaSendoAvaliada.getName() + " dessa maneira: ===");
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
						System.out.println("=== Voce avaliou " + disciplinaSendoAvaliada.getName() + " dessa maneira: ===");
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println(">>> " + criterio.getName() + ": ");
							System.out.println(criterio.getComment());
						}
						
						// Criando objeto da avaliacao
						EvaluationManagerSingleton.getInstance().evaluateItem(disciplinaSendoAvaliada, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					}
				}
				
				// Disciplina nao encontrada
				else {
					System.out.println("=== Nao existe nenhuma disciplina com esse numero. Voce voltara ao menu inicial. ===");
				}			
			}
			
			// Caso tenha escolhido [3] - ver avaliacoes de professores
			else if (inputNum == 3){
				EvaluationManagerSingleton.getInstance().printUserEvaluations(Professor.class);
			}
			
			// Caso tenha escolhido [4] - ver avaliacoes de disciplinas
			else if (inputNum == 4){
				EvaluationManagerSingleton.getInstance().printItemEvaluations(Disciplina.class);
			}
			
			// Caso tenha escolhido [5] - trocar de usuario
			else if (inputNum == 5) {
				usuarioAvaliando = logarComNovoUsuario(userService, evaluableUserService, scanner);
			}
			
			// Caso tenha sido escolhido numero inexistente
			else{
				System.out.println("=== Nao existe essa opcao no menu. ===");
			}
		}
			
	}

	private static User logarComNovoUsuario(UserService userService, EvaluableUserService evaluableUserService, Scanner scanner) {
		String inputText;
		String inputText2;
		User usuarioAvaliando = null;
		
		System.out.println("=== Voce e 1 - aluno, 2 - professor? ===");
		inputText = scanner.nextLine();
		while(!inputText.equals("1") && !inputText.equals("2")){
			System.out.println("=== Valor invalido, tente novamente. 1 - aluno, 2 - professor ===");
			inputText = scanner.nextLine();
		}
		
		System.out.println("=== Quem e voce? ===");
		
		if (inputText.equals("1")){
			inputText = scanner.nextLine();
			System.out.println("=== Qual o seu periodo? ===");
			inputText2 = scanner.nextLine();
			usuarioAvaliando = new Aluno(inputText, Integer.parseInt(inputText2));
			userService.insert(usuarioAvaliando);
		}else if (inputText.equals("2")){
			inputText = scanner.nextLine();
			System.out.println("=== Qual o seu departamento? ===");
			inputText2 = scanner.nextLine();
			usuarioAvaliando = new Professor(inputText, inputText2);
			userService.insert(usuarioAvaliando);
			evaluableUserService.insert((Professor) usuarioAvaliando);
		}
		
		return usuarioAvaliando;
	}
	
	public static int parseInt(String opcao){
		Scanner scn = new Scanner(System.in);
		
		while(!opcao.matches("^\\d+(\\.\\d+)?")){
			System.out.println("=== Nao existe essa opcao no menu. ===");
			opcao = scn.nextLine();
		}
		return Integer.parseInt(opcao);
	}
}
