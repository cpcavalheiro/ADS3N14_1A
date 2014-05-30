package com.senac.apps;

import java.io.IOException;

import com.senac.apps.views.ConsoleView;


public class Principal {

	/**
	 * Metodo main
	 *
	 * @param args
	 * @throws IOException Erro de IO. Vem de controller
	 */
	public static void main(String[] args) throws IOException {
		Controller controller = new Controller();
		ConsoleView console = new ConsoleView(controller);
		console.run();
	}

}
