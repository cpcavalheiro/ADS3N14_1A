package com.senac.apps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.senac.model.Contact;

public class FileManagement {

	private String fileName;

	private BufferedWriter buffer;

	private FileWriter fileWriter;

	/**
	 * Construtor
	 * 
	 * @param fileName
	 *            vem do controller
	 * @throws IOException
	 *             Erro ao escrever
	 */
	public FileManagement(String fileName) throws IOException {
		setFilename(fileName);
		fileWriter = new FileWriter(getFilename(), true); // O TRUE faz append
															// ao
															// arquivo,
															// ao invÈs de
															// eliminar
															// o conteudo
		buffer = new BufferedWriter(fileWriter);

	}

	private void setFilename(String fileName) {
		this.fileName = fileName;
	}

	private String getFilename() {
		return fileName;
	}

	/**
	 * Recebe os dados dos nodos e transformar em uma linha CSV sem cabeçalho.
	 * 
	 * @param contact
	 *            o contato
	 */
	public void addData(Contact contact) {
		String dataFormat = "\"";
		dataFormat += contact.getNome();
		dataFormat += "\"";
		dataFormat += ",";
		dataFormat += "\"";
		dataFormat += contact.getTelefone();
		dataFormat += "\"";
		String dataToAdd = dataFormat;
		try {
			buffer.write(dataToAdd);
			buffer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buffer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
