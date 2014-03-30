package batalha.controller;

import batalha.view.BatalhaView;

public class BatalhaNaval {

	public static void main(String[] args) {
		BatalhaView view = new BatalhaView();
		Controller controller = new Controller();

		view.imprimeTabuleiro(controller.iniciaJogo());
		controller.jogada();
		controller.geraEmbarcacao();

		/*
		 * do {
		 * 
		 * } while (tabuleiro.getTiros() > 0);
		 */
		System.out.println("Fim do jogo!");

	}

}
