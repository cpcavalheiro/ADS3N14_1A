package com.senac.apps;

import java.io.IOException;

import com.senac.estruturas.ListaOrdenada;
import com.senac.estruturas.Nodo;
import com.senac.model.Contact;

public class Controller {

	private ContactGenerator contactGenerator;

	private FileManagement fileManager;

	private ContactsLoad loadContacts;

	private ListaOrdenada<Contact> lista = new ListaOrdenada<Contact>();

	private String fileName;

	public Controller() throws IOException {
		fileName = "contatos.txt";
		loadContacts = new ContactsLoad(fileName, this);
		loadContacts.run();
		fileManager = new FileManagement(fileName);
	}

	/**
	 * Cria um novo contato na lista
	 * 
	 * @param name
	 *            nome
	 * @param phone
	 *            telefone
	 */
	public void newContact(String name, String phone) {
		// se o telefone vier com 8 digitos, colocamos um - no meio para
		// melhorar a visualização.
		if (phone.length() == 8) {
			phone = phone.substring(0, 4) + "-"
					+ phone.substring(4, phone.length());
		}
		Contact newContact = new Contact(name, phone);
		Nodo<Contact> novo = new Nodo<Contact>(newContact);
		lista.insert(novo);
		fileManager.addData(novo.getChave());
	}

	/**
	 * Essa classe é diferente da newContact por que não adciona o contato no
	 * arquivo, só na lista
	 * 
	 * @param name
	 *            o nome
	 * @param phone
	 *            o telefone
	 */
	public void newContactFromFile(String name, String phone) {
		Contact newContact = new Contact(name, phone);
		Nodo<Contact> novo = new Nodo<Contact>(newContact);
		lista.insert(novo);
	}

	/**
	 * Usa a classe GenerateContacts para criar contatos aleatorios
	 */
	public void generateContacts() {
		contactGenerator = new ContactGenerator();
		for (int i = 0; i < 50; ++i) {
			newContact(contactGenerator.getNewRandomName(),
					contactGenerator.getNewRandomNumber());
		}
	}

	/**
	 * Imprime lista.
	 */
	public void printList() {
		Nodo<Contact> nodo = lista.getHead();
		while (nodo != null) {
			System.out.println(nodo.getChave());
			nodo = nodo.getNext();
		}

	}

	/**
	 * Gets the lista. É usado pela view.
	 * 
	 * @return the lista
	 */
	public ListaOrdenada<Contact> getLista() {
		return lista;
	}
}