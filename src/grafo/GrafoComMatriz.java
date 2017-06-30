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
	public void adicionarAresta(int u, int v, int peso) {
		matrizAdj[u][v] = peso;
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
				if (matrizAdj[s][i] > 0 && visited[i] == false) {
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
				if (matrizAdj[element][i] > 0 && visited[i] == false) {
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

	@Override
	public String arvoreGeradoraMinima(int vertice) {
		String resultado = null;
		// Array to store constructed MST
		int parent[] = new int[V];

		// Key values used to pick minimum weight edge in cut
		int key[] = new int[V];

		// To represent set of vertices not yet included in MST
		Boolean mstSet[] = new Boolean[V];

		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// Always include first 1st vertex in MST.
		key[0] = vertice; // Make key 0 so that this vertex is
		// picked as first vertex
		parent[0] = -1; // First node is always root of MST

		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick thd minimum key vertex from the set of vertices
			// not yet included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int v = 0; v < V; v++)

				// graph[u][v] is non zero only for adjacent vertices of m
				// mstSet[v] is false for vertices not yet included in MST
				// Update the key only if graph[u][v] is smaller than key[v]
				if (matrizAdj[u][v] != 0 && mstSet[v] == false && matrizAdj[u][v] < key[v]) {
					parent[v] = u;
					key[v] = matrizAdj[u][v];
				}
		}

		resultado = "Aresta   ---   Peso\n";
		for (int i = 1; i < V; i++)
			resultado += "(" + parent[i] + ", " + i + ")   ---   " + matrizAdj[i][parent[i]] + "\n";
		
		return resultado;
	}

	int minKey(int key[], Boolean mstSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}
}
