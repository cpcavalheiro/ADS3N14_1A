package com.senac.apps;

import java.util.Random;

public class ContactGenerator {

	private Random rand = new Random();

	private StringBuilder stb = new StringBuilder();

	private int nameLength = 20;

	private int phoneLength = 8;

	public String getNewRandomName() {
		return nameGenerator(nameLength);
	}

	/**
	 * Pega o numero aleatorio e converte para um formato mais parecido com o de
	 * um telefone
	 * 
	 * @return o numero
	 */
	public String getNewRandomNumber() {
		String convertedNumber = Integer.toString(numberGenerator(phoneLength));
		return convertedNumber.substring(0, 4) + "-"
				+ convertedNumber.substring(4, convertedNumber.length());
	}

	/**
	 * Gerador de nomes
	 * 
	 */
	private String nameGenerator(int length) {
		stb.delete(0, stb.length()); // limpar o stringBuilder
		String characters = "abcdefghijklmnopqrstuvxz";
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rand.nextInt(characters.length()));
		}
		String newName = new String(text);

		return newName.substring(1, 10) + " "
				+ newName.substring(12, newName.length());
	}

	/**
	 * Gerador de numeros
	 * 
	 */
	public int numberGenerator(int length) {
		return rand.nextInt(9999999) + 30000000;
	}
}
