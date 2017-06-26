package formulario.panels.telaprincipal;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelGerarArquivoGrafo extends JPanel {
	private static final long serialVersionUID = 5060591508284501438L;

	private JButton btnGerarArquivo;

	public PanelGerarArquivoGrafo() {
		btnGerarArquivo = new JButton("Gerar Arquivo");

		this.setBorder(BorderFactory.createTitledBorder("Gerar Arquivo de Texto para Grafo"));
		this.setMaximumSize(new Dimension(600, 0));
		this.add(btnGerarArquivo);
	}

	public JButton getBtnGerarArquivo() {
		return btnGerarArquivo;
	}
}
