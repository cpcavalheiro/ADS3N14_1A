package lista.controller;

import java.io.File;
import java.io.IOException;

public class ArquivoController {

	/**
	 * Instância objeto file com caminho relativo do arquivo de dados
	 * 
	 * @author Cássio P Cavalheiro
	 */

	File file = new File("./dados/ListaTelefone.txt");

	/**
	 * Testa se arquivo de dados existe.
	 * Se não existir chama o metodo geraArquivo()
	 * Se existir chama o metodo acessaArquivo()
	 * dados.
	 * 
	 * @author Cássio P Cavalheiro
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
