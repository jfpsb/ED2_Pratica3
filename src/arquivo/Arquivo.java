package arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	public boolean escreverArquivoGrafo(File destino, String texto) {

		try {
			FileWriter fileW = new FileWriter(destino);
			PrintWriter gravarArq = new PrintWriter(fileW);

			gravarArq.println("<--- Grafo em Arquivo de Texto --->");
			gravarArq.println(texto);
			fileW.close();
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
}
