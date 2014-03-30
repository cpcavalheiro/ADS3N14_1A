package batalha.controller;

import batalha.view.BatalhaView;

public class BatalhaNaval {

	public static void main(String[] args) {
		BatalhaView view = new BatalhaView();
		Controller controller = new Controller();

		view.imprimeTabuleiro(controller.iniciaJogo());
		controller.geraEmbarcacao();
		/**
		 * Inicia um laço de repetição, para somente quando o numero de tiros
		 * chegar a zero ou quando todos os "navios" forem "destruidos".
		 */
		do {
			controller.jogada();
			view.imprimeTabuleiro(controller.atualizaTabuleiro());
			view.imprimeDisparos(controller.tiros());
			view.imprimeAcertoErro(controller.acerto(), controller.erros(),
					controller.acerto() + controller.erros());
		} while (controller.tiros() > 0);

		System.out.println("Fim do jogo!");

	}

}
