package instanciacinematografica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import control.EvaluationManagerSingleton;
import instanciaacademica.Professor;
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
		
		evaluableItemService.insert(new Desenho("Gravity Falls", 2012, "Disney Television Animation", 12));
		evaluableItemService.insert(new Desenho("Steven Universe", 2013, "Cartoon Network Studios", 10));
		evaluableItemService.insert(new Desenho("BoJack Horseman", 2014, "Netflix", 16));

		evaluableItemService.insert(new Serie("Narcos", 20, "Crime", 16));
		evaluableItemService.insert(new Serie("Orange Is The New Black", 65, "Drama", 18));
		evaluableItemService.insert(new Serie("Stranger Things", 8, "Ficção Científica", 16));
		
		evaluableItemService.insert(new Filme("Nerve", 2016, "Henry Joost", 12));
		evaluableItemService.insert(new Filme("Moonlight", 2016, "Barry Jenkins", 16));
		evaluableItemService.insert(new Filme("Mommy", 2014, "Xavier Dolan", 14));
		
		RegraCinematografica regra = new RegraCinematografica();
		
		Scanner scanner = new Scanner(System.in);
		int inputNum = 0;
		String inputText;
		
		System.out.println("=== Bem vindo ao TV-Rate ===");
		System.out.println("");
		
		// Criando um espectador para a pessoa que iniciou o sistema
		System.out.println("=== Qual seu nome? ===");
		String nome = scanner.nextLine();
		System.out.println("=== Qual a sua idade? ===");
		String idadeTxt = scanner.nextLine();
		int idade = parseInt(idadeTxt);
		Espectador usuarioAvaliando = new Espectador(nome, idade);
		userService.insert(usuarioAvaliando);
		
		while (true) {
			System.out.println("");
			System.out.println("");
			
			// Pergunta ao espectador se ele deseja avalair desenhos, series ou filmes e recebe a resposta
			System.out.println("=== O que deseja fazer? ===");
			System.out.println("=== Insira [1] para avaliar desenhos ===");
			System.out.println("=== Insira [2] para avaliar series ===");
			System.out.println("=== Insira [3] para avaliar filmes ===");
			System.out.println("=== Insira [4] para ver avaliacoes sobre desenhos ===");
			System.out.println("=== Insira [5] para ver avaliacoes sobre series ===");
			System.out.println("=== Insira [6] para ver avaliacoes sobre filmes ===");
			System.out.println("=== Insira [7] para logar como outro usuario ===");
			
			inputText = scanner.nextLine();
			inputNum = parseInt(inputText);

			// Caso tenha escolhido [1] - avaliando desenhos
			if (inputNum == 1) {
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					
					if (evaluableItemService.searchAll().get(i).getClass() == Desenho.class) {
						System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
					}
				}
				
				System.out.println("=== Insira o numero do desenho que deseja avaliar ===");
				
				inputText = scanner.nextLine();
				inputNum = parseInt(inputText);
				
				EvaluableItem desenhoSendoAvaliado = evaluableItemService.search(inputNum);
				
				// Desenho encontrado
				if (desenhoSendoAvaliado != null) {
					
					// Clona o objeto a ser avaliado para nao modificar o original
					desenhoSendoAvaliado = Desenho.clone((Desenho) desenhoSendoAvaliado);
					
					if (regra.validateEvaluation(desenhoSendoAvaliado, usuarioAvaliando)){
					
						System.out.println("=== Você esta avaliando o(a) " + desenhoSendoAvaliado.getName() + " ===");
						
						// Avaliando criterios objetivos
						ArrayList<ObjectiveCriterion> criteriosObjetivos = desenhoSendoAvaliado.getObjectiveCriteriaToBeEvaluated();
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
						
						System.out.println("=== Voce avaliou " + desenhoSendoAvaliado.getName() + " dessa maneira: ===");
						for (ObjectiveCriterion criterio: criteriosObjetivos) {
							System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
						}
						
						// Avaliando criterios subjetivos
						ArrayList<SubjectiveCriterion> criteriosSubjetivos = desenhoSendoAvaliado.getSubjectiveCriteriaToBeEvaluated();
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
							
							inputText = scanner.nextLine();
							criterio.setComment(inputText);
						}
						System.out.println("=== Voce avaliou " + desenhoSendoAvaliado.getName() + " dessa maneira: ===");
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println(">>> " + criterio.getName() + ": ");
							System.out.println(criterio.getComment());
						}
						
						// Criando objeto da avaliacao
						EvaluationManagerSingleton.getInstance().evaluateItem(desenhoSendoAvaliado, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					}
				}
				
				// Desenho nao encontrado
				else {
					System.out.println("=== Nao existe nenhum desenho com esse numero. Voce voltara ao menu inicial. ===");
				}
			}
			
			// Caso tenha escolhido [2] - avaliando series
			else if (inputNum == 2){
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					
					if (evaluableItemService.searchAll().get(i).getClass() == Serie.class) {
						System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
					}
				}
				
				System.out.println("=== Insira o numero da serie que deseja avaliar ===");
				
				inputText = scanner.nextLine();
				inputNum = parseInt(inputText);
				
				EvaluableItem serieSendoAvaliada = evaluableItemService.search(inputNum);
				
				// Serie encontrada
				if (serieSendoAvaliada != null) {
					
					// Clona o objeto a ser avaliado para nao modificar o original
					serieSendoAvaliada = Serie.clone((Serie) serieSendoAvaliada);
					
					if (regra.validateEvaluation(serieSendoAvaliada, usuarioAvaliando)){
					
						System.out.println("=== Voce esta avaliando a serie " + serieSendoAvaliada.getName() + " ===");
						
						// Avaliando criterios objetivos
						ArrayList<ObjectiveCriterion> criteriosObjetivos = serieSendoAvaliada.getObjectiveCriteriaToBeEvaluated();
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
						
						System.out.println("=== Voce avaliou " + serieSendoAvaliada.getName() + " dessa maneira: ===");
						for (ObjectiveCriterion criterio: criteriosObjetivos) {
							System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
						}
						
						// Avaliando criterios subjetivos
						ArrayList<SubjectiveCriterion> criteriosSubjetivos = serieSendoAvaliada.getSubjectiveCriteriaToBeEvaluated();
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
							
							inputText = scanner.nextLine();
							
							criterio.setComment(inputText);
						}
						System.out.println("=== Voce avaliou " + serieSendoAvaliada.getName() + " dessa maneira: ===");
						for (SubjectiveCriterion criterio: criteriosSubjetivos) {
							System.out.println(">>> " + criterio.getName() + ": ");
							System.out.println(criterio.getComment());
						}
						
						// Criando objeto da avaliacao
						EvaluationManagerSingleton.getInstance().evaluateItem(serieSendoAvaliada, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
					}
				}
				
				// Serie n�o encontrada
				else {
					System.out.println("=== Nao existe nenhuma serie com esse numero. Voce voltara ao menu inicial. ===");
				}			
			}
			
			// Caso tenha escolhido [3] - avaliando filme
			else if (inputNum == 3){
				for (int i = 0; i < evaluableItemService.searchAll().size(); i++) {
					
					if (evaluableItemService.searchAll().get(i).getClass() == Filme.class) {
						System.out.println(evaluableItemService.searchAll().get(i).getId() + " - " + evaluableItemService.searchAll().get(i).getName() + ", " + evaluableItemService.searchAll().get(i).getDescription());
					}
				}
				
			System.out.println("=== Insira o numero da filme que deseja avaliar ===");
				
			inputText = scanner.nextLine();
			inputNum = parseInt(inputText);
			
			EvaluableItem filmeSendoAvaliado = evaluableItemService.search(inputNum);
			
			// Filme encontrado
			if (filmeSendoAvaliado != null) {
				
				// Clona o objeto a ser avaliado para nao modificar o original
				filmeSendoAvaliado = Filme.clone((Filme)filmeSendoAvaliado);
				
				if (regra.validateEvaluation(filmeSendoAvaliado, usuarioAvaliando)){
					
					System.out.println("=== Voce esta avaliando a filme " + filmeSendoAvaliado.getName() + " ===");
					
					// Avaliando criterios objetivos
					ArrayList<ObjectiveCriterion> criteriosObjetivos = filmeSendoAvaliado.getObjectiveCriteriaToBeEvaluated();
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
					
					System.out.println("=== Voce avaliou " + filmeSendoAvaliado.getName() + " dessa maneira: ===");
					for (ObjectiveCriterion criterio: criteriosObjetivos) {
						System.out.println(">>> " + criterio.getName() + ": " + criterio.getRate());
					}
					
					// Avaliando criterios subjetivos
					ArrayList<SubjectiveCriterion> criteriosSubjetivos = filmeSendoAvaliado.getSubjectiveCriteriaToBeEvaluated();
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println("=== Avaliando " + criterio.getName() + " (" + criterio.getDescription() + ") com um texto ===");
						
						inputText = scanner.nextLine();
						
						criterio.setComment(inputText);
					}
					System.out.println("=== Voce avaliou " + filmeSendoAvaliado.getName() + " dessa maneira: ===");
					for (SubjectiveCriterion criterio: criteriosSubjetivos) {
						System.out.println(">>> " + criterio.getName() + ": ");
						System.out.println(criterio.getComment());
					}
					
					// Criando objeto da avaliacao
					EvaluationManagerSingleton.getInstance().evaluateItem(filmeSendoAvaliado, usuarioAvaliando, criteriosSubjetivos, criteriosObjetivos, new Date());
				}
			}
			
			// Filme nao encontrado
			else {
				System.out.println("=== Nao existe nenhuma filme com esse numero. Voce voltara ao menu inicial. ===");
			}			
		}			
			
			// Caso tenha escolhido [4] - ver avaliacoes de desenhos
			else if (inputNum == 4){
				EvaluationManagerSingleton.getInstance().printItemEvaluations(Desenho.class);
			}
			
			// Caso tenha escolhido [5] - ver avaliacoes de series
			else if (inputNum == 5){
				EvaluationManagerSingleton.getInstance().printItemEvaluations(Serie.class);
			}
			
			// Caso tenha escolhido [6] - ver avaliacoes de filmes
			else if (inputNum == 6){
				EvaluationManagerSingleton.getInstance().printItemEvaluations(Filme.class);
			}
			
			// Caso tenha escolhido [7] - trocar de usuario
			else if (inputNum == 7) {
				usuarioAvaliando = new Espectador(null, 0);
				usuarioAvaliando = logarComNovoUsuario(userService, scanner);
			}
			
			// Caso tenha sido escolhido numero inexistente
			else{
				System.out.println("=== Nao existe essa opcao no menu. ===");
			}
		}
	}
	
	private static Espectador logarComNovoUsuario(UserService userService, Scanner scanner) {
		Espectador usuarioAvaliando;
		System.out.println("=== Qual seu nome? ===");
		String nome = scanner.nextLine();
		System.out.println("=== Qual a sua idade? ===");
		String idadeTxt = scanner.nextLine();
		int idade = parseInt(idadeTxt);
		
		usuarioAvaliando = new Espectador(nome, idade);
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
