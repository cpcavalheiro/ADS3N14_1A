package lista.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;

public class ArquivoController {

	/**
	 * Instância objeto file com caminho relativo do arquivo de dados
	 * 
	 * @author Cássio P Cavalheiro
	 */

	File file = new File("./dados/ListaTelefone.txt");

	/**
	 * Testa se arquivo de dados existe. Se não existir chama o metodo
	 * geraArquivo() Se existir chama o metodo acessaArquivo()
	 * 
	 * @author Cássio P Cavalheiro
	 */
	public void verificaArquivo() {
		if (!file.exists()) {
			geraArquivo();
		} else {
			acessaArquivo();
		}
	}

	/**
	 * Faz a leitura do arquivo de dados.
	 * 
	 * @return ler
	 */
	public BufferedReader acessaArquivo() {
		FileReader arq = null;
		try {
			arq = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader ler = new BufferedReader(arq);
		return ler;
	}

	/**
	 * Gera o arquivos de dados caso ele não exista.
	 */
	public void geraArquivo() {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Erro ao criar arquivo.");
			e.printStackTrace();
		}

	}

	/**
	 * Grava informações no arquivo de dados.
	 */
	public void gravaArquivo(String linha) {
		try {
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter conexao = new BufferedWriter(fw);
		//RandomAccessFile grava = null;
		conexao.write(linha);  
        conexao.newLine();  
        conexao.close();		
			//grava = new RandomAccessFile(file, "rw");
			// System.out.println(linha);
			//grava.writeBytes(linha + "\r\n");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} /*finally {
			try {

				if (grava != null)
					grava.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}*/
	}
}
