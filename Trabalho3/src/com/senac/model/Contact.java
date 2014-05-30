package com.senac.model;

/**
 * The Class Contact.
 */
public class Contact implements Comparable<Contact> {
	
	/** The nome. */
	private String nome;
	
	/** The telefone. */
	private String telefone;
	
	/** The is active. */
	private boolean isActive;

	/**
	 * Instantiates a new contact.
	 *
	 * @param nome the nome
	 * @param telefone the telefone
	 */
	public Contact(String nome, String telefone) {
		this.setNome(nome);
		this.setTelefone(telefone);
	}
	
	/**
	 * Gets the chave.
	 *
	 * @return the chave
	 */
	public String getChave() {
		return this.getNome();
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	private void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 *
	 * @param telefone the new telefone
	 */
	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Nome: " + this.getNome() + " Telefone: " + this.getTelefone();
	}

	// metodo abaixo necessario para que a listaOrdenada aceite a classe Contato
	// como parametro generico
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Contact contact) {
		return this.getNome().compareTo(contact.getNome());
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets the active.
	 *
	 * @param isActive the new active
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
