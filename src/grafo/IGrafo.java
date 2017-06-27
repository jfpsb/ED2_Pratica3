package grafo;

public interface IGrafo {
	public void adicionarAresta(int u, int v);
	public String buscaEmLargura(int s);
	public String buscaEmProfundidade(int v);
}
