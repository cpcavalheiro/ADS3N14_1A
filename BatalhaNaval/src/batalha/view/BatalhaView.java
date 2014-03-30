package batalha.view;

public class BatalhaView {

	/**
	 * Imprime na tela o tabuleiro do jogo.
	 * 
	 * @param array
	 */

	public void imprimeTabuleiro(int[][] array) {
		int b = 0;
		System.out.println("  A B C D E F G H I J");
		for (int[] a : array) {
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
	public void imprimeDisparos(int tiro){
		System.out.println(tiro+" Tiros disponiveis");
		
	}
	public void imprimeAcertoErro(int acerto, int erro, int total){
		System.out.printf("%d Acertos. \n%d Erros\n%d Disparos totais.\n",acerto,erro,total);
	}
}
