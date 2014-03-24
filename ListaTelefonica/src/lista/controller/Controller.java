package lista.controller;

import lista.estrutura.ListaOrdenada;
import lista.estrutura.Nodo;
import lista.view.ConsoleView;
import java.util.Scanner;

public class Controller {
	
	private ListaOrdenada<String>
			lista = new ListaOrdenada<String>();
	private ConsoleView view = new ConsoleView();
	private Scanner input = new Scanner(System.in);
	
	public void iniciaLista() {
		for (int i = 0; i < 50; ++i) {
			Nodo<String> novo = new Nodo<String>();
			novo.setChave(input.next());
			lista.insert(novo);
		}
	}
	
	public void imprimeLista() {
		Nodo<String> nodo = lista.getHead();
		while (nodo != null) {
			view.imprimeAgenda(nodo.getChave());
			nodo = nodo.getNext();
		}
	}
	
}









