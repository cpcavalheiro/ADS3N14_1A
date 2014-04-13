package model;

public class Matriz {
	private int[] matriz;
	private int comparacao, swap;
	private TempoExecucao tempo;

	public int[] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[] matriz) {
		this.matriz = matriz;
	}

	public int getComparacao() {
		return comparacao;
	}

	public void setComparacao(int comparacao) {
		this.comparacao = comparacao;
	}

	public TempoExecucao getTempo() {
		return tempo;
	}

	public void setTempo(TempoExecucao tempo) {
		this.tempo = tempo;
	}

	public int getSwap() {
		return swap;
	}

	public void setSwap(int swap) {
		this.swap = swap;
	}

}
