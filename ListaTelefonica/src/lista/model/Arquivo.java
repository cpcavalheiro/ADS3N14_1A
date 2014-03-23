package lista.model;

import java.io.File;
import java.io.IOException;

public class Arquivo {

	/**
	 * Inst�ncia objeto file com caminho relativo do arquivo de dados
	 * 
	 * @author C�ssio P Cavalheiro
	 */

	File file = new File("./dados/ListaTelefone.txt");

	/**
	 * Testa se arquivo de dados existe. Se n�o existir cria um novo arquivo de
	 * dados.
	 * 
	 * @author C�ssio P Cavalheiro
	 */
	public void geraArquivo() {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Erro ao criar arquivo.");
				e.printStackTrace();
			}
		}

	}
}
