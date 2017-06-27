package formulario;

import java.awt.Dimension;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import formulario.panels.telaprincipal.PanelGerarArquivoGrafo;
import formulario.panels.telaprincipal.PanelOpenFile;
import formulario.panels.telaprincipal.PanelPesquisaLarguraProfundidade;

abstract public class TelaPrincipalControles extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3626163638603872181L;
	private JPanel panelPrincipal;

	protected JFileChooser escolherArquivo;
	protected JFileChooser salvarArquivo;

	protected PanelOpenFile panelOpenFile;
	protected PanelGerarArquivoGrafo panelGerarArquivoGrafo;
	protected PanelPesquisaLarguraProfundidade panelPesquisaLarguraProfundidade;

	public TelaPrincipalControles() {
		super("Atividade Prática 3 - Grafos");
		inicializarControles();
	}

	private void inicializarControles() {
		panelOpenFile = new PanelOpenFile();
		panelGerarArquivoGrafo = new PanelGerarArquivoGrafo();
		panelPesquisaLarguraProfundidade = new PanelPesquisaLarguraProfundidade();

		// EscolherArquivo
		escolherArquivo = new JFileChooser();
		escolherArquivo.setCurrentDirectory(new File(System.getProperty("user.dir")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Grafo", "grafo", "text");
		escolherArquivo.setFileFilter(filter);
		
		// SalvarArquivo
		salvarArquivo = new JFileChooser();
		salvarArquivo.setCurrentDirectory(new File(System.getProperty("user.dir")));
		salvarArquivo.setSelectedFile(new File("Informações sobre Grafo Em Arquivo.txt"));
		FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Arquivos de Texto", "txt", "text");
		salvarArquivo.setFileFilter(filter2);

		// panelPrincipal
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		panelPrincipal.add(panelOpenFile);
		panelPrincipal.add(panelGerarArquivoGrafo);
		panelPrincipal.add(panelPesquisaLarguraProfundidade);

		// telaPrincipal
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(630, 400));
		this.setLocationRelativeTo(null);
//		this.setResizable(false);
		this.pack();
		this.add(panelPrincipal);
	}

	/**
	 * Abre tela.
	 */
	public void mostrarTela() {
		this.setVisible(true);
	}
}
