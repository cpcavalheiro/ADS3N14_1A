package com.senac.apps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ContactsLoad {

	private final File filePath;

	Scanner scan;

	Scanner lineFilter;

	Controller controller;

	public ContactsLoad(String fileToBeRead, Controller controller) {
		filePath = new File(fileToBeRead);
		if (!filePath.exists()) {
			try {
				filePath.createNewFile();
			} catch (IOException e) {
				System.out.println("Impossivel criar o arquivo!");
			}
		}
		this.controller = controller;
	}

	public void run() throws IOException {
		getLinesFromFile();
	}

	public void getLinesFromFile() throws IOException {

		scan = new Scanner(filePath);
		while (scan.hasNextLine()) {
			processLine(scan.nextLine());
		}
	}

	/**
	 * Processa as linhas.
	 * 
	 * @param nextLine
	 *            a linha a ser processada
	 */
	private void processLine(String nextLine) {
		String name = null;
		String phone = null;
		lineFilter = new Scanner(nextLine);
		lineFilter.useDelimiter(",");
		if (lineFilter.hasNext()) {
			name = lineFilter.next();
			// uso um replaceAll para remover as aspas. Isso provavelmente
			// poderia ser feito de uma forma melhor
			name = name.replaceAll("\"", "");
			phone = lineFilter.next();
			phone = phone.replaceAll("\"", "");
			controller.newContactFromFile(name, phone);
		}
	}
}