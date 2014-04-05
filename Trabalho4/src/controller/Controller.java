package controller;

import java.util.Random;

import model.Matriz;
import model.TempoExecucao;

public class Controller {
	Matriz quick;
	Matriz bubble;
	Random random;
	TempoExecucao tempoBubble, tempoQuick;
	double ini, end;
	int[] lista;

	public Controller() {
		this.lista = new int[10000];
		this.random = new Random();
		this.quick = new Matriz();
		this.bubble = new Matriz();
		this.tempoBubble = new TempoExecucao();
		this.tempoQuick = new TempoExecucao();
		this.ini = 0;
		this.end = 0;

	}

	public void geraMatriz() {

		for (int cont = 0; cont < this.lista.length; cont++) {
			this.lista[cont] = random.nextInt(9999) + 1;
		}

		quick.setMatriz(lista);
		bubble.setMatriz(lista);
	}

	public int[] mostraQuick() {
		return quick.getMatriz();
	}

	public int[] mostraBubble() {
		return bubble.getMatriz();
	}

	public void quickSort(int[] matriz, int ini, int fim) {
		int meio;
		this.ini = System.currentTimeMillis();
		if (ini < fim) {
			meio = partition(matriz, ini, fim);
			quickSort(matriz, ini, meio);
			quickSort(matriz, meio + 1, fim);
		}
		this.end = System.currentTimeMillis();
		tempoQuick.setTempo((this.end - this.ini) / 1000.0);
	}

	public int partition(int[] matriz, int ini, int fim) {
		int pivo, topo, i;
		pivo = matriz[ini];
		topo = ini;

		for (i = ini + 1; i <= fim; i++) {
			if (matriz[i] < pivo) {
				matriz[topo] = matriz[i];
				matriz[i] = matriz[topo + 1];
				topo++;
			}
		}
		matriz[topo] = pivo;
		return topo;
	}

	public int[] bubbleSort(int[] matriz) {
		int aux = 0;
		this.ini = System.currentTimeMillis();
		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length - 1; j++) {
				if (matriz[j] > matriz[j + 1]) {
					aux = matriz[j];
					matriz[j] = matriz[j + 1];
					matriz[j + 1] = aux;

				}

			}

		}
		this.end = System.currentTimeMillis();
		tempoBubble.setTempo((this.end - this.ini) / 1000.0);
		this.bubble.setMatriz(matriz);
		return this.bubble.getMatriz();
	}

	public double tempoBubble() {
		return tempoBubble.getTempo();

	}

	public double tempoQuick() {
		return tempoQuick.getTempo();

	}

}
