package tela;

import model.Matriz;
import model.TempoExecucao;

public class Imprime {
	public void imprime(Matriz m) {
		TempoExecucao tempo = m.getTempo();
		for (int cont = 0; cont < m.getMatriz().length; cont++) {
			System.out.println(m.getMatriz()[cont]);
		}

		System.out.println(String.format(
				"Compara‹o %d, Troca %d, Tempo de execu‹o %f",
				m.getComparacao(), m.getSwap(), tempo.getTempo()));
		System.out.println();

	}

}
