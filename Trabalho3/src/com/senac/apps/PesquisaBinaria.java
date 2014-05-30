package com.senac.apps;


import com.senac.estruturas.Nodo;
import com.senac.model.Contact;

public class PesquisaBinaria {
	String valueToFind;

	
	Nodo<Contact> startNodo;
	Nodo<Contact> endNodo;

	public PesquisaBinaria(String valueToFind, Controller controller) {
		this.valueToFind = valueToFind;
		
		startNodo = controller.getLista().getHead();
		endNodo = null;
	}

	public Nodo<Contact> search() {
		do {
			Nodo<Contact> middle = middleNode(startNodo, endNodo);
			if (middle == null) {
				return null;
			}
			if (middle.getChave().getNome().compareTo(valueToFind) == 0) {
				return middle;
			} else if (middle.getChave().getNome().compareTo(valueToFind) > 0) {
				startNodo = middle.getNext();
			} else {
				endNodo = middle;
			}

		} while (endNodo == null || endNodo.getNext() != startNodo);
		return null;
	}

	private Nodo<Contact> middleNode(Nodo<Contact> startNodo2,
			Nodo<Contact> endNodo2) {
		if (startNodo2 == null) {
			return null;
		}
		Nodo<Contact> slowPointer = startNodo2;
		Nodo<Contact> fastPointer = startNodo.getNext();
		while (fastPointer != endNodo2) {
			fastPointer = fastPointer.getNext();
			if (fastPointer != endNodo2) {
				slowPointer = slowPointer.getNext();
				fastPointer = fastPointer.getNext();
			}

		}
		return slowPointer;
	}

}
