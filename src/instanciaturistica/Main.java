package instanciaturistica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import control.EvaluationManagerSingleton;
import model.CriterionType;
import model.EvaluableItem;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;
import service.EvaluableItemService;
import service.UserService;

public class Main {

	public Main() {
		
	}

	public static void main(String[] args) {
		UserService userService = new UserService();
		EvaluableItemService evaluableItemService = new EvaluableItemService();
		
		evaluableItemService.insert(new PontoTuristico("Morro do Careca", "Natal"));
		evaluableItemService.insert(new PontoTuristico("Museu do Louvre", "Paris"));
		evaluableItemService.insert(new PontoTuristico("Central Park", "Nova York"));
		
		evaluableItemService.insert(new Estabelecimento("Midway Mall", "Natal", "Shopping"));
		evaluableItemService.insert(new Estabelecimento("Starbucks", "Recife", "Cafe"));
		evaluableItemService.insert(new Estabelecimento("Riachuelo", "Fortaleza", "Loja"));
		
		Scanner scanner = new Scanner(System.in);
		int inputNum = 0;
		String inputText;
		
		System.out.println("=== Bem vindo ao FiveSquare ===");
		System.out.println("");
		
		// Criando um usuario para a pessoa que iniciou o sistema
		System.out.println("=== Qual seu nome? ===");
		String nome = scanner.nextLine();
		System.out.println("=== Onde voce mora? ===");
		String cidade = scanner.nextLine();
		Usuario usuarioAvaliando = new Usuario(nome, cidade);
		userService.insert(usuarioAvaliando);
		
		while (true) {
			System.out.println("");
			System.out.println("");
			
			// Pergunta ao usuario se ele deseja avalair pontos turisticos ou estabelecimentos e recebe a resposta
			System.out.println("=== O que deseja fazer? ===");
			System.out.println("=== Insira [1] para avaliar pontos turisticos ===");
			System.out.println("=== Insira [2] para avaliar estabelecimentos ===");
			System.out.println("=== Insira [3] para ver avaliacoes sobre pontos turisticos ===");
			System.out.println("=== Insira [4] para ver avaliacoes sobre estabelecimentos ===");
			System.out.println("=== Insira [5] para logar como outro usuario ===");
			
			inputText = scanner.nextLine();
			inputNum = parseInt(inputText);

			// Caso tenha escolhido [1] - avaliando pontos turisticos
			if (inputNum == 1) {
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					
					if (evaluableItemService.searchAll().get(i).getClass() == PontoTuristico.class) {
						System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
					}
				}
				
				System.out.println("=== Insira o numero do ponto turistico que deseja avaliar ===");
				
				inputText = scanner.nextLine();
				inputNum = parseInt(inputText);
				
				EvaluableItem pontoTuristicoSendoAvaliado = evaluableItemService.search(inputNum);
				
				// Ponto turistico encontrado
				if (pontoTuristicoSendoAvaliado != null) {
					
					// Clona o objeto a ser avaliado para não modificar o original
					pontoTuristicoSendoAvaliado = PontoTuristico.clone((PontoTuristico) pontoTuristicoSendoAvaliado);
					
					System.out.println("=== Voce esta avaliando o(a) " + pontoTuristicoSendoAvaliado.getName() + " ===");
					
					// Avaliando critirios objetivos
					ArrayList<ObjectiveCriterion> criteriosObjetivos = pontoTuristicoSendoAvaliado.getObjectiveCriteriaToBeEvaluated();
					
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
					
					System.out.println("=== Voce avaliou " + pontoTuristicoSendoAvaliado.getName() + " dessa maneira: ===");
					for (ObjectiveCriterion criterio: criteriosObjetivos) {
						System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
					}
					
					// Avaliando critirios subjetivos
					ArrayList<SubjectiveCriterion> criteriosSubjetivos = pontoTuristicoSendoAvaliado.getSubjectiveCriteriaToBeEvaluated();
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
						
						inputText = scanner.nextLine();
						criterio.setComment(inputText);
					}
					System.out.println("=== Voce avaliou " + pontoTuristicoSendoAvaliado.getName() + " dessa maneira: ===");
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println(">>> " + criterio.getName() + ": ");
						System.out.println(criterio.getComment());
					}
					
					// Criando objeto da avaliacao
					EvaluationManagerSingleton.getInstance().evaluateItem(pontoTuristicoSendoAvaliado, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					
				}
				
				// Ponto turistico nao encontrado
				else {
					System.out.println("=== Nao existe nenhum ponto turistico com esse numero. Voce voltara ao menu inicial. ===");
				}
			}
			
			// Caso tenha escolhido [2] - avaliando estabelecimentos
			else if (inputNum == 2){
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					
					if (evaluableItemService.searchAll().get(i).getClass() == Estabelecimento.class) {
						System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
					}
				}
				
				System.out.println("=== Insira o numero do estabelecimento que deseja avaliar ===");
				
				inputText = scanner.nextLine();
				inputNum = parseInt(inputText);
				
				EvaluableItem estabelecimentoSendoAvaliado = evaluableItemService.search(inputNum);
				
				// Estabelecimento encontrado
				if (estabelecimentoSendoAvaliado != null) {
					
					// Clona o objeto a ser avaliado para não modificar o original
					estabelecimentoSendoAvaliado = Estabelecimento.clone((Estabelecimento) estabelecimentoSendoAvaliado);
					
					System.out.println("=== Voce esta avaliando o estabelecimento " + estabelecimentoSendoAvaliado.getName() + " ===");
					
					// Avaliando criterios objetivos
					ArrayList<ObjectiveCriterion> criteriosObjetivos = estabelecimentoSendoAvaliado.getObjectiveCriteriaToBeEvaluated();
					
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
					
					System.out.println("=== Voce avaliou " + estabelecimentoSendoAvaliado.getName() + " dessa maneira: ===");
					for (ObjectiveCriterion criterio: criteriosObjetivos) {
						System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
					}
					
					// Avaliando criterios subjetivos
					ArrayList<SubjectiveCriterion> criteriosSubjetivos = estabelecimentoSendoAvaliado.getSubjectiveCriteriaToBeEvaluated();
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
						
						inputText = scanner.nextLine();
						
						criterio.setComment(inputText);
					}
					System.out.println("=== Voce avaliou " + estabelecimentoSendoAvaliado.getName() + " dessa maneira: ===");
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println(">>> " + criterio.getName() + ": ");
						System.out.println(criterio.getComment());
					}
					
					// Criando objeto da avaliacao
					EvaluationManagerSingleton.getInstance().evaluateItem(estabelecimentoSendoAvaliado, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
				}
				
				// Disciplina nao encontrada
				else {
					System.out.println("=== Nao existe nenhum estabelecimento com esse numero. Voce voltara ao menu inicial. ===");
				}			
			}
			
			// Caso tenha escolhido [3] - ver avaliacoes de pontos turisticos
			else if (inputNum == 3){
				EvaluationManagerSingleton.getInstance().printItemEvaluations(PontoTuristico.class);
			}
			
			// Caso tenha escolhido [4] - ver avaliacoes de disciplinas
			else if (inputNum == 4){
				EvaluationManagerSingleton.getInstance().printItemEvaluations(Estabelecimento.class);
			}
			
			// Caso tenha escolhido [5] - trocar de usuario
			else if (inputNum == 5) {
				usuarioAvaliando = logarComNovoUsuario(userService, scanner);
			}
			
			// Caso tenha sido escolhido numero inexistente
			else{
				System.out.println("=== Nao existe essa opcao no menu. ===");
			}
		}
	}

	private static Usuario logarComNovoUsuario(UserService userService, Scanner scanner) {
		Usuario usuarioAvaliando;
		System.out.println("=== Qual seu nome? ===");
		String nome = scanner.nextLine();
		System.out.println("=== Onde voce mora? ===");
		String cidade = scanner.nextLine();
		
		usuarioAvaliando = new Usuario(nome, cidade);
		userService.insert(usuarioAvaliando);
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
