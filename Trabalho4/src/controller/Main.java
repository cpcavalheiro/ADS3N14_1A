package controller;

import java.util.Random;

import model.Matriz;
import tela.Imprime;

public class Main {

	private static Controller c = new Controller();
	private static Imprime view = new Imprime();
	private static Random random = new Random();
	private static final int[] LISTA = geraMatriz();
	static Matriz quick, insertion;

	public static void main(String[] args) {
		int[] matriz = new int[LISTA.length];
		for (int a = 0; a < matriz.length; a++) {
			matriz[a] = LISTA[a];
		}

		quickSort(LISTA);

		insertionSort(matriz);

	}

	private static void quickSort(int[] lista) {
		quick = c.quickSort(lista, 0, lista.length);
		view.imprime(quick);
	}

	private static void insertionSort(int[] lista) {
		insertion = c.insertionSort(lista);
		view.imprime(insertion);
	}

	/**
	 * Gera a matriz com o numero de campos indicados.
	 * 
	 * @return Matriz aleatoria.
	 */
	private static final int[] geraMatriz() {
		int[] dado = new int[100];

		for (int cont = 0; cont < dado.length; cont++) {
			dado[cont] = random.nextInt(dado.length);
		}
		return dado;
	}

}
