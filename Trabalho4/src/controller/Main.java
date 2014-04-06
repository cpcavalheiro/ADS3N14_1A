package controller;

import view.Imprime;

public class Main {

	public static void main(String[] args) {

		Controller implementa = new Controller();
		Imprime imprime = new Imprime();
		int dado = 0;
		/**
		 * Implementa a Matriz utilizada para o teste;
		 */
		implementa.geraMatriz();

		/**
		 * Efetua a ordenação pelo QuickSort e imprime a lista ordenada na tela.
		 */
		implementa.quickSort(implementa.mostraQuick(), 0, 99);
		for (int cont = 0; cont < implementa.mostraQuick().length; cont++) {
			dado = implementa.mostraQuick()[cont];
			imprime.imprime(dado);

		}
		/**
		 * Imprime na tela o tempo utilizado com o QuickSort.
		 */
		imprime.tempo("Tempo gasto com Quick: " + implementa.tempoQuick());
		System.out.println("\n");
		/**
		 * Efetua a ordenação pelo QuickSort e imprime a lista ordenada na tela.
		 */
		for (int cont = 0; cont < implementa.mostraBubble().length; cont++) {
			dado = implementa.bubbleSort(implementa.mostraBubble())[cont];
			imprime.imprime(dado);

		}
		/**
		 * Imprime na tela o tempo utilizado com o BubbleSort.
		 */
		imprime.tempo("Tempo gasto com Bubble: " + implementa.tempoBubble());

	}
}
