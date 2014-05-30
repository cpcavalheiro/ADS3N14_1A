package com.senac.apps.views;

import java.util.Scanner;

import com.senac.apps.Controller;
import com.senac.apps.PesquisaBinaria;
import com.senac.estruturas.Nodo;
import com.senac.model.Contact;


public class ConsoleView {
	

	private boolean isRunning;
	

	private boolean firstRun;
	

	private Scanner scanInput;
	

	private String input;
	

	private Controller controller;
	

	private String name;
	

	private String phone;
	

	private Nodo<Contact> nodo;

	private enum InputValues {
		

		NOVO {
			public void execute(Controller controller, ConsoleView consoleView) {
				consoleView.getContactFromUser();
				controller.newContact(consoleView.getName(),
						consoleView.getPhone());
			}
		},
		

		GERAR {
			public void execute(Controller controller, ConsoleView consoleView) {
				controller.generateContacts();
				System.out.println("Contatos gerados com sucesso");
			}
		},
		

		LISTAR {
			public void execute(Controller controller, ConsoleView consoleView) {
				controller.printList();
			}

		},
		

		NAVEGAR {

			public void execute(Controller controller, ConsoleView consoleView) {
				consoleView.navigate();
			}

		},
		

		PESQUISAR{
			public void execute(Controller controller, ConsoleView consoleView) {
				consoleView.searchByName();
			}
			
		},
		BINARIA{
			public void execute(Controller controller, ConsoleView consoleView) {
				consoleView.binarySearch();				
			}
			
		},
		
		
		SAIR {

			@Override
			public void execute(Controller controller, ConsoleView consoleView) {
				System.exit(0);
			}

		};
		
		
		public abstract void execute(Controller controller,
				ConsoleView consoleView);
	}

	
	public ConsoleView(Controller controller) {
		scanInput = new Scanner(System.in);
		this.controller = controller;
		isRunning = true;
		firstRun = true;
	}

	
	public void run() {
				showMenu();
	}

	
	private void setNodoFromController() {
		this.nodo = controller.getLista().getHead();
	}

	
	
	private void binarySearch(){
		System.out.println("Digite o inicio do nome: \n");
		String valueToFind = scanInput.nextLine();
		PesquisaBinaria pesquisar = new PesquisaBinaria(valueToFind, controller);
		System.out.println(pesquisar.search().getChave().toString());
		System.out.println("TEste \n");
	}
	private void searchByName() {
		setNodoFromController();
		System.out.println("Digite o inicio do nome: \n");
		String letter = scanInput.nextLine();
		while (nodo != null) {
			if (nodo.getChave().getNome().substring(0, letter.length())
					.equalsIgnoreCase(letter)) {
				System.out.println(nodo.getChave());
			}
			nodo = nodo.getNext();
		}
	}

	/**
	 * Navegador. Avançar, voltar, etc
	 */
	private void navigate() {
		setNodoFromController();
		boolean isNavigating = true;
		System.out
				.println("Digite avançar, voltar ou pesquisar para procurar pelo nome \n"
						+ "Qualquer outra coisa: sair");

		System.out.println(nodo.getChave());

		while (isNavigating) {
			String input = scanInput.nextLine();

			if (input.equalsIgnoreCase("avancar")) {
				nodo = nodo.getNext();
				System.out.println(nodo.getChave());

			} else if (input.equalsIgnoreCase("voltar")) {
				System.out.println("TODO");
			} else if (input.equalsIgnoreCase("pesquisar")) {
				searchByName();
			} else {
				System.out.println("Saindo");
				isNavigating = false;
			}
		}
	}

	/**
	 * Mostra o menu de comandos inicial
	 */
	private void showMenu() {
		while (isRunning) {
			if (firstRun) {
				System.out
						.println("Comando(novo,listar,gerar,navegar,pesquisar): \n");
				firstRun = false;
			}
			System.out.println("Comando(novo,listar,gerar,navegar,pesquisar): \n");
			input = scanInput.nextLine();
			try {
				//Repassa o valor do comando a ser tratado
				processCommand(InputValues.valueOf(input.toUpperCase()));
			} catch (Exception e) {
				System.out.println("Comando inválido \n");
			} finally {
				//em todos os casos espera o comando novamente
				showMenu();
			}

		}

	}

	
	private void processCommand(final InputValues command) {
		command.execute(controller, this);
	}

	
	private void getContactFromUser() {
		System.out.println("Digite o nome do contato: \n");
		input = scanInput.nextLine();
		setName(input);
		System.out.println("Digite o telefone do contato \n");
		input = scanInput.nextLine();
		setPhone(input);
	}

	
	private String getName() {
		return name;
	}

	
	private void setName(String name) {
		this.name = name;
	}

	
	private String getPhone() {
		return phone;
	}

	
	private void setPhone(String phone) {
		this.phone = phone;
	}

}
