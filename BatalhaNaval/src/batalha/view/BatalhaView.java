package batalha.view;

import batalha.controller.Controller;

public class BatalhaView {
	Controller imprime = new Controller();

	public void imprimeTabuleiro(int[][] array) {
		int b = 0;
		System.out.println("  A B C D E F G H I J");
		for (int[]a : array) {
			System.out.print(b++ + " ");
			for (int s : a) {
				if (s == -1) {
					System.out.print(". ");
				} else if (s == 0) {
					System.out.print("~ ");
				} else if (s == 1) {
					System.out.print("O ");
				}
			}

			System.out.println();
		}
	}
}
