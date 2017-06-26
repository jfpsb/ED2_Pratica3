package formulario.panels.telaprincipal;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelRepresentarGrafo extends JPanel {

	private JButton btnGerarRepresentacao;
	private ButtonGroup buttonGroup;
	private JRadioButton rbMatriz;
	private JRadioButton rbLista;

	public PanelRepresentarGrafo() {
		btnGerarRepresentacao = new JButton("Gerar Representação");
		rbMatriz = new JRadioButton("Matriz de Adjacência");
		rbLista = new JRadioButton("Lista de Adjacência");
		rbLista.setSelected(true);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rbLista);
		buttonGroup.add(rbMatriz);

		this.setBorder(BorderFactory.createTitledBorder("Representação de Grafo"));
		this.add(rbLista);
		this.add(rbMatriz);
		this.add(btnGerarRepresentacao);
	}

	public JButton getBtnGerarRepresentacao() {
		return btnGerarRepresentacao;
	}

	public JRadioButton getRbMatriz() {
		return rbMatriz;
	}

	public JRadioButton getRbLista() {
		return rbLista;
	}
}
