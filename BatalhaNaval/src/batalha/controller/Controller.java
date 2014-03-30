package batalha.controller;

import batalha.model.EmbarcacaoModel;
import batalha.model.TabuleiroModel;
import batalha.view.BatalhaView;

import java.util.Random;
import java.util.Scanner;

public class Controller {

	private TabuleiroModel tabuleiro, rascunho;
	private int linha, coluna;
	private EmbarcacaoModel porta_aviao, destroyer, fragata, submarino,
			torpedeiro;
	private BatalhaView view;
	private Scanner input;
	private Random random;

	public Controller() {
		this.tabuleiro = new TabuleiroModel();
		this.rascunho = new TabuleiroModel();
		this.porta_aviao = new EmbarcacaoModel(5, 2);
		this.destroyer = new EmbarcacaoModel(8, 2);
		this.fragata = new EmbarcacaoModel(6, 2);
		this.submarino = new EmbarcacaoModel(5, 2);
		this.torpedeiro = new EmbarcacaoModel(6, 2);
		this.view = new BatalhaView();
		this.input = new Scanner(System.in);
		random = new Random();

	}

	/**
	 * Inicia o tabuleiro quando o jogo é iniciado.
	 * 
	 * @return retorna o tbuleiro criado;
	 */

	public int[][] iniciaJogo() {
		int[][] array = new int[10][10];

		for (linha = 0; linha < tabuleiro.getTabuleiro().length; linha++) {

			for (coluna = 0; coluna < tabuleiro.getTabuleiro()[linha].length; coluna++) {
				array[linha][coluna] = -1;
			}

		}
		this.tabuleiro.setTabuleiro(array);
		return this.tabuleiro.getTabuleiro();
	}

	/**
	 * Recebe os dados digitados pelo usuário. Testa se a Letra digitada consta
	 * no array de letras. Se sim registra o numero da posição para verificação
	 * do tabuleiro;
	 */

	public void jogada() {
		System.out.println("Informe o número da linha:\n");
		tabuleiro.setLinha(input.nextInt());
		System.out.println("Informe a letra da coluna:\n");
		tabuleiro.setLetras(input.next());
		for (int teste = 0; teste < tabuleiro.getColun().length; teste++) {
			String letra = this.tabuleiro.getColun()[teste];
			if (letra.equalsIgnoreCase(this.tabuleiro.getLetra())) {
				this.tabuleiro.setColuna(teste);
			}
		}
		System.out.println(tabuleiro.getLinha());
		System.out.println(tabuleiro.getColuna());
	}

	public void geraEmbarcacao() {

		int[][] embarcacao = new int[this.submarino.getLinha()][this.submarino
				.getColuna()];

		for (int cont = 0; cont < this.submarino.getEmbarcacao().length; cont++) {
			embarcacao[cont][0] = random.nextInt(10);
			embarcacao[cont][1] = random.nextInt(10);

			for (int anterior = 0; anterior < cont; anterior++) {
				if ((embarcacao[cont][0] == embarcacao[anterior][0])
						&& (embarcacao[cont][1] == embarcacao[anterior][1]))
					do {
						embarcacao[cont][0] = random.nextInt(10);
						embarcacao[cont][1] = random.nextInt(10);
					} while ((embarcacao[cont][0] == embarcacao[anterior][0])
							&& (embarcacao[cont][1] == embarcacao[anterior][1]));
			}
		}
		this.submarino.setEmbarcacao(embarcacao);

	}

	/**
	 * Testa Se a jogada acertou alguma embarcação ou se acertou a água. Se
	 * acertou retorna True, aumenta quantia de tiros, contabiliza 1 acerto. Se
	 * errou retorna False, diminui em 1 a quantia de tiros e contabiliza um
	 * erro.
	 * 
	 * @return
	 */
	private boolean testaJogada() {

		for (int embarcacao = 0; embarcacao < submarino.getEmbarcacao().length; embarcacao++) {
			if (this.tabuleiro.getLinha() == this.submarino.getEmbarcacao()[embarcacao][0]
					&& this.tabuleiro.getColuna() == this.submarino
							.getEmbarcacao()[embarcacao][1]) {
				System.out.printf("Você acertou o tiro (%d,%d)\n",
						this.tabuleiro.getLinha(), this.tabuleiro.getColuna());
				this.tabuleiro.setTiros(this.tabuleiro.getTiros() + 5);
				this.tabuleiro.setAcertos(this.tabuleiro.getAcertos() + 1);
				return true;
			}
		}
		this.tabuleiro.setTiros(this.tabuleiro.getTiros() - 1);
		this.tabuleiro.setErros(this.tabuleiro.getErros() + 1);
		return false;
	}

	public int acerto() {
		return this.tabuleiro.getAcertos();
	}

	public int erros() {
		return this.tabuleiro.getErros();
	}

	public int tiros() {
		return this.tabuleiro.getTiros();
	}

	/**
	 * Atualiza o Tabuleiro conforme a resposta booleana do metodo testaJogada.
	 * Se acertou algum "navio" registra 1 no ponto informado. Se acertou "água"
	 * registra 0.
	 * 
	 */
	public int[][] atualizaTabuleiro() {
		int[][] tabuleiro = new int[10][10];
		boolean retorno = this.testaJogada();

		if (retorno) {
			for (int linha = 0; linha < this.tabuleiro.getTabuleiro().length; linha++) {
				for (int coluna = 0; coluna < this.tabuleiro.getTabuleiro()[linha].length; coluna++) {
					if (linha == this.tabuleiro.getLinha()
							&& coluna == this.tabuleiro.getColuna()) {
						tabuleiro[this.tabuleiro.getLinha()][this.tabuleiro
								.getColuna()] = 1;
					} else {
						tabuleiro[linha][coluna] = this.tabuleiro.getTabuleiro()[linha][coluna];
					}
				}

			}
			this.tabuleiro.setTabuleiro(tabuleiro);
		} else {
			for (int linha = 0; linha < this.tabuleiro.getTabuleiro().length; linha++) {
				for (int coluna = 0; coluna < this.tabuleiro.getTabuleiro()[linha].length; coluna++) {
					if (linha == this.tabuleiro.getLinha()
							&& coluna == this.tabuleiro.getColuna()) {
						tabuleiro[this.tabuleiro.getLinha()][this.tabuleiro
								.getColuna()] = 0;
					} else {
						tabuleiro[linha][coluna] = this.tabuleiro.getTabuleiro()[linha][coluna];
					}

				}

			}
			this.tabuleiro.setTabuleiro(tabuleiro);
		}
		return this.tabuleiro.getTabuleiro();
	}
}
