package com.senac.estruturas;

/**
 * The Class ListaEncadeada.
 *
 * @param <T> the generic type
 */
public class ListaEncadeada<T> {

	/** The head. */
	protected Nodo<T> head;
	
	/** The tail. */
	protected Nodo<T> tail;

	/**
	 * Instantiates a new lista encadeada.
	 */
	public ListaEncadeada() {
		head = null;
		tail = null;
	}
	
	/**
	 * Insert.
	 *
	 * @param novo the novo
	 */
	public void insert(Nodo<T> novo)
	{
		novo.setNext(head);
		head = novo;
		if (tail == null)
			tail = novo;
	}
	
	/**
	 * Insert.
	 *
	 * @param novo the novo
	 * @param anterior the anterior
	 */
	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		if (anterior == null) {
			novo.setNext(head);
			head = novo;
			if (tail == null)
				tail = head;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
			if (anterior == tail)
				tail = novo;
		}
	}
	
	/**
	 * Append.
	 *
	 * @param novo the novo
	 */
	public void append(Nodo<T> novo)
	{
		if (tail != null) {
			tail.setNext(novo);
		} else {
			head = novo;
		}
		tail = novo;
	}
	
	/**
	 * Gets the tail.
	 *
	 * @return the tail
	 */
	public Nodo<T> getTail()
	{
		return tail;
	}
	
	/**
	 * Gets the head.
	 *
	 * @return the head
	 */
	public Nodo<T> getHead()
	{
		return head;
	}

}
