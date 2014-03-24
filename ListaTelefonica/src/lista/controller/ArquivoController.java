package lista.controller;

import java.io.File;
import java.io.IOException;

public class ArquivoController {

	/**
	 * Inst�ncia objeto file com caminho relativo do arquivo de dados
	 * 
	 * @author C�ssio P Cavalheiro
	 */

	File file = new File("./dados/ListaTelefone.txt");

	/**
	 * Testa se arquivo de dados existe.
	 * Se n�o existir chama o metodo geraArquivo()
	 * Se existir chama o metodo acessaArquivo()
	 * dados.
	 * 
	 * @author C�ssio P Cavalheiro
	 */
	public void verificaArquivo() {
		if (!file.exists()) {
			geraArquivo();
		}else{
			acessaArquivo();
		}
	}

	private void acessaArquivo() {
		
	}

	private void geraArquivo() {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Erro ao criar arquivo.");
			e.printStackTrace();
		}

	}
}
