package model;

public class Matriz {
	int[] matriz;
	int comp, swap;

	public Matriz() {
		this.comp = 0;
		this.swap = 0;

		this.matriz = new int[100];
	}

	public int getComp() {
		return comp;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}

	public int getSwap() {
		return swap;
	}

	public void setSwap(int swap) {
		this.swap = swap;
	}

	public void setMatriz(int[] matriz) {
		this.matriz = matriz;
	}

	public int[] getMatriz() {
		return matriz;
	}

}
