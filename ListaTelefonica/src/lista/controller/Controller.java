package lista.controller;

import lista.estrutura.ListaOrdenada;
import lista.estrutura.Nodo;
import lista.model.Pessoa;
import lista.view.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Controller extends ArquivoController {

	private ListaOrdenada<String> lista = new ListaOrdenada<String>();
	private ConsoleView view = new ConsoleView();
	private Scanner input = new Scanner(System.in);
	private Pessoa pessoa = new Pessoa();
	private ArquivoController arquivo = new ArquivoController();

	public void iniciaLista() {
		BufferedReader arq = arquivo.acessaArquivo();
		String linha;
		try {
			linha = arq.readLine();
			while (linha != null) {
				Nodo<String> novo = new Nodo<String>();
				novo.setChave(linha);
				lista.insert(novo);
				linha = arq.readLine();
			}
			arq.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void imprimeLista() {
		Nodo<String> nodo = lista.getHead();
		while (nodo != null) {
			view.imprimeAgenda(nodo.getChave());
			nodo = nodo.getNext();
		}
	}

	public void insereDados() {
		System.out.println("Digite o nome: ");
		pessoa.setNome(input.next());
		System.out.println("Digite o telefone;");
		pessoa.setTelefone(input.next());
		ArquivoController arq = new ArquivoController();
		arq.gravaArquivo(pessoa.getNome() + "," + pessoa.getTelefone());
	}

}
