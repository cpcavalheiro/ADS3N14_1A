package controller;

import view.Imprime;

public class Main {

	public static void main(String[] args) {

		Controller implementa = new Controller();
		Imprime imprime = new Imprime();
		int dado = 0;
		implementa.geraMatriz();

		implementa.quickSort(implementa.mostraQuick(), 0, 9998);

		for (int cont = 0; cont < implementa.mostraQuick().length; cont++) {
			dado = implementa.mostraQuick()[cont];
			imprime.imprime(dado);

		}
		imprime.tempo("Tempo gasto com Quick: " + implementa.tempoQuick());
		System.out.println("\n");
		for (int cont = 0; cont < implementa.mostraBubble().length; cont++) {
			dado = implementa.bubbleSort(implementa.mostraBubble())[cont];
			imprime.imprime(dado);

		}
		imprime.tempo("Tempo gasto com Bubble: " + implementa.tempoBubble());

	}
}
