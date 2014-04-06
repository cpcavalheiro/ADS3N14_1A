package controller;

import java.util.Random;

import model.Matriz;
import model.TempoExecucao;

public class Controller {
	Matriz quick;
	Matriz bubble;
	Random random;
	TempoExecucao tempoBubble, tempoQuick;
	double inicio, termino;
	int[] lista;

	public Controller() {
		this.lista = new int[100];
		this.random = new Random();
		this.quick = new Matriz();
		this.bubble = new Matriz();
		this.tempoBubble = new TempoExecucao();
		this.tempoQuick = new TempoExecucao();
		this.inicio = 0;
		this.termino = 0;

	}
	/**
	 * Inicia a Matriz com dados aleatorios para ser ordenada.
	 */

	public void geraMatriz() {

		for (int cont = 0; cont < this.lista.length; cont++) {
			this.lista[cont] = random.nextInt(100);
		}

		quick.setMatriz(lista);
		bubble.setMatriz(lista);
	}

	/**
	 * Retorna a Matriz ordenada com o QuickSort 
	 * @return Matriz ordenada.
	 */
	public int[] mostraQuick() {
		return quick.getMatriz();
	}

	/**
	 * Retorna a Matriz ordenada com o BubbleSort 
	 * @return Matriz ordenada.
	 */
	public int[] mostraBubble() {
		return bubble.getMatriz();
	}
	
	/**
	 * Recebe a matriz, posição inicial e final da matriz para efetuar a ordenação.
	 * Define o "meio" da lista e separa em duas outras listas até organizar toda a matriz.
	 * @param matriz
	 * @param ini
	 * @param fim
	 */
	public void quickSort(int[] matriz, int ini, int fim) {
		int meio;
		this.inicio = System.currentTimeMillis();
		if (ini < fim) {
			meio = partition(matriz, ini, fim);
			quickSort(matriz, ini, meio);
			quickSort(matriz, meio + 1, fim);
		}
		this.termino = System.currentTimeMillis();
		tempoQuick.setTempo((this.termino - this.inicio) / 1000.0);
	}
	
	/**
	 * Recebe os dados do metodo quickSort, e retorna o "meio" da matriz.
	 * @param matriz
	 * @param ini
	 * @param fim
	 * @return Retorna a posição central da matriz
	 */
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
	
	/**
	 * Percorre a matriz comparando todas as suas posições até ordenar todas a matriz.
	 * @param matriz
	 * @return Matriz ordenada.
	 */

	public int[] bubbleSort(int[] matriz) {
		int aux = 0;
		this.inicio = System.currentTimeMillis();
		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length - 1; j++) {
				if (matriz[j] > matriz[j + 1]) {
					aux = matriz[j];
					matriz[j] = matriz[j + 1];
					matriz[j + 1] = aux;

				}

			}

		}
		this.termino = System.currentTimeMillis();
		tempoBubble.setTempo((this.termino - this.inicio) / 1000.0);
		this.bubble.setMatriz(matriz);
		return this.bubble.getMatriz();
	}
	
	/**
	 * Retorna o tempo gasto para efetuar o processo de ordenação.
	 * @return Tempo utilizado para ordenar a lista com o BubbleSort.
	 */

	public double tempoBubble() {
		return tempoBubble.getTempo();

	}
	
	/**
	 * Retorna o tempo gasto para efetuar o processo de ordenação.
	 * @return Tempo utilizado para ordenar a lista com o QuickSort.
	 */
	public double tempoQuick() {
		return tempoQuick.getTempo();

	}

}
