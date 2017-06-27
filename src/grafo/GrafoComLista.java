package grafo;

import java.util.Iterator;
import java.util.LinkedList;

public class GrafoComLista implements IGrafo {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists
	private static String resultado;

	// Constructor
	public GrafoComLista(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	@Override
	public void adicionarAresta(int u, int v) {
		adj[u].add(v);
	}

	@Override
	public String buscaEmLargura(int s) {
		String resultado = "";
		boolean visited[] = new boolean[V];
		int nivel = 0;

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			resultado += "Vértice: " + s + " - " + "Nível: " + nivel + "\n";
			nivel++;

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

		return resultado;
	}

	// A function used by DFS
	void DFSUtil(int v, boolean visited[], int nivel) {
		// Mark the current node as visited and print it
		visited[v] = true;
		nivel++;
		adicionaEmResultado("Vértice: " + v + " - " + "Nível: " + nivel + "\n");
		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited, nivel);
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	public String buscaEmProfundidade(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		resultado = "";

		int nivel = 0;

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited, nivel);

		return resultado;
	}

	private static void adicionaEmResultado(String s) {
		resultado += s;
	}
}
