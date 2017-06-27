package formulario.panels.telaprincipal;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelPesquisaLarguraProfundidade extends JPanel {
	private static final long serialVersionUID = 991959182735732890L;

	private JPanel innerPanel;
	private ButtonGroup buttonGroup;
	private JRadioButton rbLargura;
	private JRadioButton rbProfundidade;
	private JLabel lblVerticiInicial;
	private JLabel lblMsgArquivo;
	private JTextField txtVerticeInicial;
	private JButton btnPesquisar;

	public PanelPesquisaLarguraProfundidade() {
		lblVerticiInicial = new JLabel("V�rtice Inicial: ");
		lblMsgArquivo = new JLabel("O resultado aparecer� na tela. De cima para baixo.");
		txtVerticeInicial = new JTextField(15);

		btnPesquisar = new JButton("Pesquisar");

		rbLargura = new JRadioButton("Pesquisa em Largura");
		rbLargura.setSelected(true);

		rbProfundidade = new JRadioButton("Pesquisa em Profundidade");

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rbLargura);
		buttonGroup.add(rbProfundidade);

		innerPanel = new JPanel(new GridLayout(0, 2, 10, 10));

		innerPanel.add(rbLargura);
		innerPanel.add(rbProfundidade);
		innerPanel.add(lblVerticiInicial);
		innerPanel.add(txtVerticeInicial);
		innerPanel.add(lblMsgArquivo);
		innerPanel.add(btnPesquisar);

		this.setBorder(BorderFactory.createTitledBorder("Pesquisa em Profundidade e em Largura"));
		this.add(innerPanel);
	}

	public JPanel getInnerPanel() {
		return innerPanel;
	}

	public void setInnerPanel(JPanel innerPanel) {
		this.innerPanel = innerPanel;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}

	public JRadioButton getRbLargura() {
		return rbLargura;
	}

	public void setRbLargura(JRadioButton rbLargura) {
		this.rbLargura = rbLargura;
	}

	public JRadioButton getRbProfundidade() {
		return rbProfundidade;
	}

	public void setRbProfundidade(JRadioButton rbProfundidade) {
		this.rbProfundidade = rbProfundidade;
	}

	public JLabel getLblVerticiInicial() {
		return lblVerticiInicial;
	}

	public void setLblVerticiInicial(JLabel lblVerticiInicial) {
		this.lblVerticiInicial = lblVerticiInicial;
	}

	public JLabel getLblMsgArquivo() {
		return lblMsgArquivo;
	}

	public void setLblMsgArquivo(JLabel lblMsgArquivo) {
		this.lblMsgArquivo = lblMsgArquivo;
	}

	public JTextField getTxtVerticeInicial() {
		return txtVerticeInicial;
	}

	public void setTxtVerticeInicial(JTextField txtVerticeInicial) {
		this.txtVerticeInicial = txtVerticeInicial;
	}

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}
}
