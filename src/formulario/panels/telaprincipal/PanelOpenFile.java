package formulario.panels.telaprincipal;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelOpenFile extends JPanel {
	private static final long serialVersionUID = 2659500374077286897L;

	private JLabel lblOpenFile;
	private JTextField txtOpenFile;
	private JButton btnAbrirOpenFile;

	public PanelOpenFile() {
		lblOpenFile = new JLabel("Escolha o arquivo: ");
		txtOpenFile = new JTextField(25);
		btnAbrirOpenFile = new JButton("Escolher Arquivo");

		this.setBorder(BorderFactory.createTitledBorder("Selecione O Arquivo Do Grafo"));
		this.setMaximumSize(new Dimension(600, 0));
		this.add(lblOpenFile);
		this.add(txtOpenFile);
		this.add(btnAbrirOpenFile);
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
