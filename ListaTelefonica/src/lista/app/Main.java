package lista.app;

import lista.controller.ArquivoController;
import lista.controller.Controller;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArquivoController arquivoController = new ArquivoController();
		Controller controller = new Controller();

		// arquivoController.verificaArquivo();
		 controller.insereDados();

		controller.iniciaLista();
		controller.imprimeLista();

	}

}
