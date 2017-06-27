package grafo;

import java.util.LinkedList;
import java.util.Stack;

public class GrafoComMatriz implements IGrafo {
	private int V; // No. of vertices
	private int matrizAdj[][];
	private Stack<Integer> stack;

	public GrafoComMatriz(int v) {
		V = v;
		matrizAdj = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				matrizAdj[i][j] = 0;
			}
		}

		stack = new Stack<Integer>();
	}

	@Override
	public void adicionarAresta(int u, int v) {
		matrizAdj[u][v] = 1;
	}

	@Override
	public String buscaEmLargura(int s) {
		boolean visited[] = new boolean[V];
		int nivel = 0;

		String resultado = "";

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			resultado += "Vértice: " + s + " - " + "Nível: " + nivel + "\n";
			nivel++;

			for (int i = 0; i < V; i++) {
				if (matrizAdj[s][i] == 1 && visited[i] == false) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}

		return resultado;
	}

	@Override
	public String buscaEmProfundidade(int v) {
		int number_of_nodes = V - 1;

		String resultado = "";

		int nivel = 0;

		boolean visited[] = new boolean[V];
		int element = v;
		int i = v;

		visited[v] = true;
		stack.push(v);

		resultado += "Vértice: " + element + " - " + "Nível: " + nivel + "\n";
		nivel++;

		while (!stack.isEmpty()) {
			element = stack.peek();
			i = 0;
			while (i <= number_of_nodes) {
				if (matrizAdj[element][i] == 1 && visited[i] == false) {
					stack.push(i);
					visited[i] = true;
					element = i;
					i = 0;
					resultado += "Vértice: " + element + " - " + "Nível: " + nivel + "\n";
					nivel++;
					continue;
				}
				i++;
			}
			stack.pop();
		}

		return resultado;
	}
}
