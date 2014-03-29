package batalha.model;

public class TabuleiroModel {
	private int linha;
	private String colun;
	private int coluna;
	int acertos, erros;
	private int[][] array = new int[10][10];

	public int getAcertos() {
		return acertos;
	}

	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}

	public int getErros() {
		return erros;
	}

	public void setErros(int erros) {
		this.erros = erros;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public String getColuna() {
		return colun;
	}

	public void setColuna(String coluna) {
		this.colun = coluna;
	}

	public void setTabuleiro(int status) {

		for (linha = 0; linha < array.length; linha++) {

			for (coluna = 0; coluna < array[linha].length; coluna++) {
				this.array[linha][coluna] = status;
			}

		}
	}

	public int[][] getArray() {
		return array;
	}

}
