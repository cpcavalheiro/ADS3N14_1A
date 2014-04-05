package controller;

import view.Imprime;

public class Main {

	public static void main(String[] args) {

		Controller cont = new Controller();
		Imprime imprime = new Imprime();
		int dado = 0;
		cont.geraMatriz();

		for (int con = 0; con < cont.mostra().length; con++) {
			dado = cont.bubbleSort(cont.mostra())[con];
			imprime.imprime(dado);

		}

		cont.quick_sort(cont.mostra(), 0, 99);

		for (int con = 0; con < cont.mostra().length; con++) {
			dado = cont.mostra()[con];
			imprime.imprime(dado);

		}
	}
}
