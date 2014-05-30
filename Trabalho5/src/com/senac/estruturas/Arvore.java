package com.senac.estruturas;

import com.senac.estruturas.Nodo;

public class Arvore<T extends Comparable<T>> {

	int comparacoes;

	private Nodo<T> raiz;

	public int getComparacoes() {
		return comparacoes;
	}

	public void setComparacoes(int comparacoes) {
		this.comparacoes = comparacoes;
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	public Arvore() {
		raiz = null;
	}

	public Nodo<T> pesquisa(T nome) {
		Nodo<T> atual = raiz;
		comparacoes = 0;

		while (atual != null) {
			T nomeAtual = atual.getData();
			int cmp = nome.compareTo(nomeAtual);
			comparacoes++;
			if (cmp == 0) {
				return atual;
			}
			if (cmp < 0) {
				atual = atual.getFilhoEsquerda();
			}
			if (cmp > 0) {
				atual = atual.getFilhoDireita();
			}
		}

		return atual;

	}

	
	public void calculaAltura(T nome) { 
		Nodo<T> atual = raiz;
		int altura = 0;

		while (atual != null) {
			T nomeAtual = atual.getData();
			int cmp = nome.compareTo(nomeAtual);
			if (cmp == 0) {
				altura++;
				break;
			}
			if (cmp < 0) {
				altura++;
				atual = atual.getFilhoEsquerda();
			}
			if (cmp > 0) {
				altura++;
				atual = atual.getFilhoDireita();
			}
		}

		System.out.println("\nAltura: " + altura);

	} 

	
	public void insere(T pessoa) {
		Nodo<T> novo = new Nodo<T>(); 
		novo.setData(pessoa);
		if (raiz == null) { 
			raiz = novo;
		} else 
		{
			Nodo<T> atual = raiz; 
			Nodo<T> parente;

			while (true) 
			{
				parente = atual;
				T parentePesquisa = parente.getData();
				int cmp = pessoa.compareTo(parentePesquisa);

				if (cmp < 0) { 
					atual = atual.getFilhoEsquerda();
					if (atual == null) 
					{ 
						parente.setFilhoEsquerda(novo);
						return;
					}

				} else 

				if (cmp > 0) {
					atual = atual.getFilhoDireita();
					if (atual == null)
					{ 
						parente.setFilhoDireita(novo);
						return;
					}

				} 
			} 
		} 
	}

	
	public boolean delete(Nodo<T> nodo) { 
		Nodo<T> atual = raiz;
		Nodo<T> parente = raiz;
		boolean eFilhoEsquerda = true;
		T nome = nodo.getData();

		while (atual.getData() != nodo.getData()) 
		{
			parente = atual;

			T nomeAtual = atual.getData();
			int cmp = nome.compareTo(nomeAtual);

			if (cmp < 0) 
			{
				eFilhoEsquerda = true;
				atual = atual.getFilhoEsquerda();
			} else 
			{
				eFilhoEsquerda = false;
				atual = atual.getFilhoDireita();
			}
			if (atual == null) 
				return false; 
		} 
			

		
		if (atual.getFilhoEsquerda() == null && atual.getFilhoDireita() == null) {
			if (atual == raiz) 
				raiz = null; 
			else if (eFilhoEsquerda)
				parente.setFilhoEsquerda(null); 
			else
				
				parente.setFilhoDireita(null);
		}

		
		else if (atual.getFilhoDireita() == null)
			if (atual == raiz)
				raiz = atual.getFilhoDireita();
			else if (eFilhoEsquerda) 
				parente.setFilhoDireita(atual.getFilhoEsquerda());
			else
				
				parente.setFilhoDireita(atual.getFilhoDireita());

		
		else if (atual.getFilhoEsquerda() == null)
			if (atual == raiz)
				raiz = atual.getFilhoDireita();
			else if (eFilhoEsquerda) 
				parente.setFilhoEsquerda(atual.getFilhoDireita());
			else
				
				parente.setFilhoDireita(atual.getFilhoDireita());

		else 
		{
			
			Nodo<T> successor = getSuccessor(atual);

			
			if (atual == raiz)
				raiz = successor;
			else if (eFilhoEsquerda)
				parente.setFilhoEsquerda(successor);
			else
				parente.setFilhoDireita(successor);

			
			successor.setFilhoEsquerda(atual.getFilhoEsquerda());
		} 
			
		return true; 
	}
	
	private Nodo<T> getSuccessor(Nodo<T> deleteNodo) {
		Nodo<T> sucessorParente = deleteNodo;
		Nodo<T> sucessor = deleteNodo;
		Nodo<T> atual = deleteNodo.getFilhoDireita(); 
														
		while (atual != null) { 
			sucessorParente = sucessor;
			sucessor = atual;
			atual = atual.getFilhoDireita();
		} 
		if (sucessor != deleteNodo.getFilhoDireita()) {
			sucessorParente.setFilhoDireita(sucessor.getFilhoDireita());
			sucessor.setFilhoDireita(deleteNodo.getFilhoDireita());
		}
		return sucessor;
	}
}