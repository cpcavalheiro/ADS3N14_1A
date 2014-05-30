package com.senac.estruturas;

/**
 * The Class Nodo.
 *
 * @param <T> the generic type
 */
public class Nodo<T> {
	
	/** The chave. */
	private T chave;
	
	/** The next. */
	private Nodo<T> next;
	
	/**
	 * Instantiates a new nodo.
	 *
	 * @param i the i
	 */
	public Nodo(T i)
	{
		chave = i;
		next = null;
	}

	/**
	 * Gets the chave.
	 *
	 * @return the chave
	 */
	public T getChave() {
		return chave;
	}

	/**
	 * Sets the chave.
	 *
	 * @param chave the new chave
	 */
	public void setChave(T chave) {
		this.chave = chave;
	}

	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Nodo<T> getNext() {
		return next;
	}

	/**
	 * Sets the next.
	 *
	 * @param next the new next
	 */
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
}