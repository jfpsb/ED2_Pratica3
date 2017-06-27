package grafo;

public class Node {
	private int numero;
	private int peso;
	
	public Node(int n, int p) {
		numero = n;
		peso = p;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
}
