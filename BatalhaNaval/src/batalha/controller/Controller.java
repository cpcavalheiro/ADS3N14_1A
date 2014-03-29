package batalha.controller;

import batalha.model.TabuleiroModel;
import batalha.view.BatalhaView;

public class Controller {

	public static void main(String[] args) {
		TabuleiroModel tabuleiro1 = new TabuleiroModel();
		BatalhaView view = new BatalhaView();

		tabuleiro1.setTabuleiro(-1);
		view.imprimeTabuleiro(tabuleiro1.getArray());

	}
}
