package grafo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GrafoComLista implements IGrafo {
	private int V; // No. of vertices
	private LinkedList<Aresta> adj[]; // Adjacency Lists
	private static String resultado;

	// Constructor
	public GrafoComLista(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	@Override
	public void adicionarAresta(int u, int v, int peso) {
		adj[u].add(new Aresta(v, peso));
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
			Iterator<Aresta> i = adj[s].listIterator();
			while (i.hasNext()) {
				Aresta n = i.next();
				if (!visited[n.getChave()]) {
					visited[n.getChave()] = true;
					queue.add(n.getChave());
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
		Iterator<Aresta> i = adj[v].listIterator();
		while (i.hasNext()) {
			Aresta n = i.next();
			if (!visited[n.getChave()])
				DFSUtil(n.getChave(), visited, nivel);
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

	@Override
	public String arvoreGeradoraMinima(int vertice) {
		Aresta keys[] = new Aresta[V];
		int parent[] = new int[V];
		boolean mstSet[] = new boolean[V];
		String res = null;

		for (int i = 0; i < V; i++) {
			keys[i] = new Aresta(i, Integer.MAX_VALUE);
			parent[i] = -1;
			mstSet[i] = false;
		}
		keys[0].setChave(0);
		Queue<Aresta> pQueue = new PriorityQueue<>();
		pQueue.addAll(Arrays.asList(keys));

		while (pQueue.size() > 1) {
			Aresta u = pQueue.remove();
			mstSet[u.getChave()] = true;

			for (Aresta node : adj[u.getChave()]) {
				int v = node.getChave();
				if (mstSet[v] == false && node.getPeso() < keys[v].getPeso()) {
					pQueue.remove(keys[v]); // remove that node from q

					keys[v].setPeso(node.getPeso()); // change key
					parent[v] = u.getChave();

					pQueue.add(keys[v]); // add back
					// remove add can me made single function by using a visited
					// flag
					// instead of actually removing node just mark it as dirty
					// and use polling later
					// remove_add() in O(lg(n))
				}

			}
		}

		res = "Aresta   ---   Peso\n";
		for (int i = 1; i < V; i++) {
			int v = keys[i].getChave();
			res += "(" + parent[v] + ", " + v + ")   ---   " + keys[v].getPeso() + "\n";
		}

		return res;
	}
}
