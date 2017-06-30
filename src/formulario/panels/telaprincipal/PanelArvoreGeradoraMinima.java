package formulario.panels.telaprincipal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelArvoreGeradoraMinima extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7235901760869323600L;

	private JLabel lblVertice;
	private JTextField txtVertice;
	private JButton btnMostrarArvore;

	public PanelArvoreGeradoraMinima() {
		btnMostrarArvore = new JButton("Mostrar �rvore Geradora M�nima");
		txtVertice = new JTextField(20);
		lblVertice = new JLabel("Digite o v�rtice inicial: ");

		this.setBorder(BorderFactory.createTitledBorder("�rvore Geradora M�nima"));
		this.add(lblVertice);
		this.add(txtVertice);
		this.add(btnMostrarArvore);
	}

	public JButton getBtnMostrarArvore() {
		return btnMostrarArvore;
	}

	public JTextField getTxtVertice() {
		return txtVertice;
	}
}
