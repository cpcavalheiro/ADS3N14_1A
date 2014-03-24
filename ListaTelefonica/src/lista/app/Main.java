package lista.app;

import lista.controller.Controller;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Controller controller = new Controller();
		controller.iniciaLista();
		controller.imprimeLista();

	}

}
