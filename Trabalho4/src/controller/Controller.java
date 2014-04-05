package controller;

import java.util.Random;

import model.Matriz;

public class Controller {
	Matriz quick;
	Matriz bubble;
	Random random;
	double ini, end, tempo;
	int[] lista;

	public Controller() {
		this.lista = new int[100];
		this.random = new Random();
		this.quick = new Matriz();
		this.bubble = new Matriz();
		this.ini = 0;
		this.end = 0;
		this.tempo = 0;
	}

	public void geraMatriz() {

		for (int cont = 0; cont < this.lista.length; cont++) {
			this.lista[cont] = random.nextInt(100) + 1;
		}

		quick.setMatriz(lista);
	}

	public int[] mostra() {
		return quick.getMatriz();
	}

	public void quick_sort(int[] v, int ini, int fim) {
		int meio;
		this.ini = System.currentTimeMillis();
		if (ini < fim) {
			meio = partition(v, ini, fim);
			quick_sort(v, ini, meio);
			quick_sort(v, meio + 1, fim);
		}
		this.end = System.currentTimeMillis();
		this.tempo = ((this.end - this.ini)/1000.0);
	}

	public int partition(int[] v, int ini, int fim) {
		int pivo, topo, i;
		pivo = v[ini];
		topo = ini;

		for (i = ini + 1; i <= fim; i++) {
			if (v[i] < pivo) {
				v[topo] = v[i];
				v[i] = v[topo + 1];
				topo++;
			}
		}
		v[topo] = pivo;
		return topo;
	}

	public int[] bubbleSort(int[] vet) {
		int aux = 0;

		for (int i = 0; i < vet.length; i++) {

			for (int j = 0; j < vet.length - 1; j++) {
				if (vet[j] > vet[j + 1]) {
					aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;

				}

			}

		}
		this.bubble.setMatriz(vet);
		return this.bubble.getMatriz();
	}

}
