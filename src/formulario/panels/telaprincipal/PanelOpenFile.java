package formulario.panels.telaprincipal;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelOpenFile extends JPanel {
	private static final long serialVersionUID = 2659500374077286897L;

	private JLabel lblOpenFile;
	private JTextField txtOpenFile;
	private JButton btnAbrirOpenFile;
	private JButton btnCarregarGrafo;
	private ButtonGroup buttonGroup;
	private JRadioButton rbMatriz;
	private JRadioButton rbLista;
	private JLabel lblArquivoCarregado;

	public PanelOpenFile() {
		lblOpenFile = new JLabel("Escolha o arquivo: ");
		lblArquivoCarregado = new JLabel();
		txtOpenFile = new JTextField(25);
		btnAbrirOpenFile = new JButton("Escolher Arquivo");

		btnCarregarGrafo = new JButton("Carregar Grafo");
		rbMatriz = new JRadioButton("Matriz de Adjacência");
		rbLista = new JRadioButton("Lista de Adjacência");

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rbLista);
		buttonGroup.add(rbMatriz);

		this.setBorder(BorderFactory.createTitledBorder("Selecione O Arquivo Do Grafo"));
		this.setSize(new Dimension(600, 100));
		this.add(lblOpenFile);
		this.add(txtOpenFile);
		this.add(btnAbrirOpenFile);
		this.add(rbLista);
		this.add(rbMatriz);
		this.add(btnCarregarGrafo);
		this.add(lblArquivoCarregado);
	}

	public JLabel getLblArquivoCarregado() {
		return lblArquivoCarregado;
	}

	public void setLblArquivoCarregado(JLabel lblArquivoCarregado) {
		this.lblArquivoCarregado = lblArquivoCarregado;
	}

	public JButton getBtnGerarRepresentacao() {
		return btnCarregarGrafo;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JRadioButton getRbMatriz() {
		return rbMatriz;
	}

	public JRadioButton getRbLista() {
		return rbLista;
	}

	public JLabel getLblOpenFile() {
		return lblOpenFile;
	}

	public JTextField getTxtOpenFile() {
		return txtOpenFile;
	}

	public JButton getBtnAbrirOpenFile() {
		return btnAbrirOpenFile;
	}
}
