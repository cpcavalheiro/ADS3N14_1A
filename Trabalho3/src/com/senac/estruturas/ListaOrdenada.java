package com.senac.estruturas;


/**
 * The Class ListaOrdenada.
 *
 * @param <T> the generic type
 */
public class ListaOrdenada<T extends Comparable<T>>
				extends ListaEncadeada<T>
{	
	
	/**
	 * Procura nodo.
	 *
	 * @param needle the needle
	 * @return the nodo
	 */
	public Nodo<T> procuraNodo(Nodo<T> needle)
	{
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
		T chaveNeedle = needle.getChave();
		
		while (atual != null) {
			T chaveAtual = atual.getChave();
			int cmp = chaveNeedle.compareTo(chaveAtual);
			if (cmp == 0)
				return atual; 
			if (cmp < 0)
				return anterior;
			anterior = atual;
			atual = atual.getNext();
		}
		return anterior;
	}
	
	/* (non-Javadoc)
	 * @see com.senac.estruturas.ListaEncadeada#append(com.senac.estruturas.Nodo)
	 */
	@Override
	public void append(Nodo<T> novo)
	{
		insert(novo);
	}
	
	/* (non-Javadoc)
	 * @see com.senac.estruturas.ListaEncadeada#insert(com.senac.estruturas.Nodo, com.senac.estruturas.Nodo)
	 */
	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		insert(novo);
	}
	
	/* (non-Javadoc)
	 * @see com.senac.estruturas.ListaEncadeada#insert(com.senac.estruturas.Nodo)
	 */
	@Override
	public void insert(Nodo<T> novo)
	{
		Nodo<T> anterior = procuraNodo(novo);
		
		if (anterior == null) {
			novo.setNext(head);
			head = novo;
			if (tail == null)
				tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
			if (tail == anterior)
				tail = novo;
		}
		
	}
}
