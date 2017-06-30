package grafo;

public class Aresta implements Comparable<Aresta> {
	private int chave;
	private int peso;

	public Aresta(int d, int p) {
		chave = d;
		peso = p;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	@Override
	public int compareTo(Aresta arg0) {
		return this.peso - arg0.peso;
	}
}
