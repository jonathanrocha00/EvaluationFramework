package instanciaturistica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.CriterionType;
import model.EvaluableItem;
import model.ItemEvaluation;
import model.ObjectiveCriterion;
import model.SubjectiveCriterion;
import service.EvaluableItemService;
import service.ItemEvaluationService;
import service.UserService;

public class Main {

	public Main() {
		
	}

	public static void main(String[] args) {
		UserService userService = new UserService();
		EvaluableItemService evaluableItemService = new EvaluableItemService();
		ItemEvaluationService itemEvaluationService = new ItemEvaluationService();
		
		evaluableItemService.insert(new PontoTuristico("Morro do Careca", "Natal"));
		evaluableItemService.insert(new PontoTuristico("Museu do Louvre", "Paris"));
		evaluableItemService.insert(new PontoTuristico("Central Park", "Nova York"));
		
		evaluableItemService.insert(new Estabelecimento("Midway Mall", "Natal", "Shopping"));
		evaluableItemService.insert(new Estabelecimento("Starbucks", "Recife", "Café"));
		evaluableItemService.insert(new Estabelecimento("Riachuelo", "Fortaleza", "Loja"));
		
		Scanner scanner = new Scanner(System.in);
		int inputNum = 0;
		String inputText;
		
		System.out.println("=== Bem vindo ao FiveSquare ===");
		System.out.println("");
		
		// Criando um usuário para a pessoa que iniciou o sistema
		System.out.println("=== Qual seu nome? ===");
		String nome = scanner.nextLine();
		System.out.println("=== Onde você mora? ===");
		String cidade = scanner.nextLine();
		Usuario usuarioAvaliando = new Usuario(nome, cidade);
		userService.insert(usuarioAvaliando);
		
		while (true) {
			System.out.println("");
			System.out.println("");
			
			// Pergunta ao usuário se ele deseja avalair professores ou disciplinas e recebe a resposta
			System.out.println("=== O que deseja fazer? ===");
			System.out.println("=== Insira [1] para avaliar pontos turisticos ===");
			System.out.println("=== Insira [2] para avaliar estabelecimentos ===");
			System.out.println("=== Insira [3] para ver avaliações sobre pontos turisticos ===");
			System.out.println("=== Insira [4] para ver avaliações sobre estabelecimentos ===");
			System.out.println("=== Insira [5] para logar como outro usuario ===");
			
			inputText = scanner.nextLine();
			inputNum = parseInt(inputText);

			// Caso tenha escolhido [1] - avaliando pontos turísticos
			if (inputNum == 1) {
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					
					if (evaluableItemService.searchAll().get(i).getClass() == PontoTuristico.class) {
						System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
					}
				}
				
				System.out.println("=== Insira o número do ponto turístico que deseja avaliar ===");
				
				inputText = scanner.nextLine();
				inputNum = parseInt(inputText);
				
				EvaluableItem pontoTuristicoSendoAvaliado = evaluableItemService.search(inputNum);
				
				// Ponto turístico encontrado
				if (pontoTuristicoSendoAvaliado != null) {
					
					System.out.println("=== Você está avaliando o(a) " + pontoTuristicoSendoAvaliado.getName() + " ===");
					
					// Avaliando critérios objetivos
					ArrayList<ObjectiveCriterion> criteriosObjetivos = pontoTuristicoSendoAvaliado.getObjectiveCriteriaToBeEvaluated();
					for (ObjectiveCriterion criterio: criteriosObjetivos) {
						
						// Checa o tipo do critério
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
					
					System.out.println("=== Você avaliou " + pontoTuristicoSendoAvaliado.getName() + " dessa maneira: ===");
					for (ObjectiveCriterion criterio: criteriosObjetivos) {
						System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
					}
					
					// Avaliando critérios subjetivos
					ArrayList<SubjectiveCriterion> criteriosSubjetivos = pontoTuristicoSendoAvaliado.getSubjectiveCriteriaToBeEvaluated();
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
						
						inputText = scanner.nextLine();
						criterio.setComment(inputText);
					}
					System.out.println("=== Você avaliou " + pontoTuristicoSendoAvaliado.getName() + " dessa maneira: ===");
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println(">>> " + criterio.getName() + ": ");
						System.out.println(criterio.getComment());
					}
					
					// Criando objeto da avaliação
					ItemEvaluation avaliacao = new ItemEvaluation(pontoTuristicoSendoAvaliado, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					
					
					// TODO: Lógica de validação da avaliação
					
					
					itemEvaluationService.insert(avaliacao);
					
				}
				
				// Ponto turístico não encontrado
				else {
					System.out.println("=== Não existe nenhum ponto turístico com esse número. Você voltará ao menu inicial. ===");
				}
			}
			
			// Caso tenha escolhido [2] - avaliando estabelecimentos
			else if (inputNum == 2){
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					
					if (evaluableItemService.searchAll().get(i).getClass() == Estabelecimento.class) {
						System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
					}
				}
				
				System.out.println("=== Insira o número do estabelecimento que deseja avaliar ===");
				
				inputText = scanner.nextLine();
				inputNum = parseInt(inputText);
				
				EvaluableItem estabelecimentoSendoAvaliado = evaluableItemService.search(inputNum);
				
				// Estabelecimento encontrado
				if (estabelecimentoSendoAvaliado != null) {
					
					System.out.println("=== Você está avaliando o estabelecimento " + estabelecimentoSendoAvaliado.getName() + " ===");
					
					// Avaliando critérios objetivos
					ArrayList<ObjectiveCriterion> criteriosObjetivos = estabelecimentoSendoAvaliado.getObjectiveCriteriaToBeEvaluated();
					for (ObjectiveCriterion criterio: criteriosObjetivos) {
						
						// Checa o tipo do critério
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
					
					System.out.println("=== Você avaliou " + estabelecimentoSendoAvaliado.getName() + " dessa maneira: ===");
					for (ObjectiveCriterion criterio: criteriosObjetivos) {
						System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
					}
					
					// Avaliando critérios subjetivos
					ArrayList<SubjectiveCriterion> criteriosSubjetivos = estabelecimentoSendoAvaliado.getSubjectiveCriteriaToBeEvaluated();
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
						
						inputText = scanner.nextLine();
						
						criterio.setComment(inputText);
					}
					System.out.println("=== Você avaliou " + estabelecimentoSendoAvaliado.getName() + " dessa maneira: ===");
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println(">>> " + criterio.getName() + ": ");
						System.out.println(criterio.getComment());
					}
					
					// Criando objeto da avaliação
					ItemEvaluation avaliacao = new ItemEvaluation(estabelecimentoSendoAvaliado, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					
					
					// TODO: Lógica de validação da avaliação
					
					
					itemEvaluationService.insert(avaliacao);
				}
				
				// Disciplina não encontrada
				else {
					System.out.println("=== Não existe nenhum estabelecimento com esse número. Você voltará ao menu inicial. ===");
				}			
			}
			
			// Caso tenha escolhido [3] - ver avaliações de pontos turísticos
			else if (inputNum == 3){
				verAvaliacoesDePontosTuristicos(itemEvaluationService);
			}
			
			// Caso tenha escolhido [4] - ver avaliações de disciplinas
			else if (inputNum == 4){
				verAvaliacoesDeEstabelecimentos(itemEvaluationService);
			}
			
			// Caso tenha escolhido [5] - trocar de usuário
			else if (inputNum == 5) {
				usuarioAvaliando = logarComNovoUsuario(userService, scanner);
			}
			
			// Caso tenha sido escolhido numero inexistente
			else{
				System.out.println("=== Não existe essa opção no menu. ===");
			}
		}
	}
	
	private static void verAvaliacoesDePontosTuristicos(ItemEvaluationService itemEvaluationService) {
		System.out.println("=== Mostrando avaliações feitas sobre pontos turísticos... ===");
		
		ArrayList<ItemEvaluation> avaliacoesDePontosTuristicos = new ArrayList<ItemEvaluation>();
		ArrayList<ItemEvaluation> listaAuxiliar = (ArrayList<ItemEvaluation>) itemEvaluationService.searchAll();
		
		for (ItemEvaluation item: listaAuxiliar) {
			if (item.getEvaluatedItem().getClass() == PontoTuristico.class) {
				avaliacoesDePontosTuristicos.add(item);
			}
		}
		
		for (ItemEvaluation avaliacao: avaliacoesDePontosTuristicos) {
			System.out.println("Avaliação feita por " + avaliacao.getUser().getName() + " sobre " + avaliacao.getEvaluatedItem().getName());
		
			for (ObjectiveCriterion criterio: avaliacao.getRates()) {
				System.out.println("\t> " + criterio.getName() + ": " + criterio.getRate());
			}
			for (SubjectiveCriterion criterio: avaliacao.getComments()) {
				System.out.println("\t> " + criterio.getName() + ": ");
				System.out.println("\t\t" + criterio.getComment());
			}				
		}
	}
	
	private static void verAvaliacoesDeEstabelecimentos(ItemEvaluationService itemEvaluationService) {
		System.out.println("=== Mostrando avaliações feitas sobre pontos turísticos... ===");
		
		ArrayList<ItemEvaluation> avaliacoesDeEstabelecimentos = new ArrayList<ItemEvaluation>();
		ArrayList<ItemEvaluation> listaAuxiliar = (ArrayList<ItemEvaluation>) itemEvaluationService.searchAll();
		
		for (ItemEvaluation item: listaAuxiliar) {
			if (item.getEvaluatedItem().getClass() == Estabelecimento.class) {
				avaliacoesDeEstabelecimentos.add(item);
			}
		}
		
		for (ItemEvaluation avaliacao: avaliacoesDeEstabelecimentos) {
			System.out.println("Avaliação feita por " + avaliacao.getUser().getName() + " sobre " + avaliacao.getEvaluatedItem().getName());
		
			for (ObjectiveCriterion criterio: avaliacao.getRates()) {
				System.out.println("\t> " + criterio.getName() + ": " + criterio.getRate());
			}
			for (SubjectiveCriterion criterio: avaliacao.getComments()) {
				System.out.println("\t> " + criterio.getName() + ": ");
				System.out.println("\t\t" + criterio.getComment());
			}				
		}
	}

	private static Usuario logarComNovoUsuario(UserService userService, Scanner scanner) {
		String inputText;
		Usuario usuarioAvaliando;
		System.out.println("=== Qual seu nome? ===");
		String nome = scanner.nextLine();
		System.out.println("=== Onde você mora? ===");
		String cidade = scanner.nextLine();
		
		usuarioAvaliando = new Usuario(nome, cidade);
		userService.insert(usuarioAvaliando);
		return usuarioAvaliando;
	}	
	
	public static int parseInt(String opcao){
		Scanner scn = new Scanner(System.in);
		
		while(!opcao.matches("^\\d+(\\.\\d+)?")){
			System.out.println("=== Não existe essa opção no menu. ===");
			opcao = scn.nextLine();
		}
		return Integer.parseInt(opcao);
	}

}
