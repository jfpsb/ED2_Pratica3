package formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import arquivo.Arquivo;
import grafo.Auxiliar;
import grafo.GrafoComLista;
import grafo.GrafoComMatriz;
import grafo.IGrafo;

public class TelaPrincipal extends TelaPrincipalControles {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8456970881979484775L;

	private File arquivoSelecionado;
	private IGrafo interfaceGrafo;
	private int numeroVertices = 0;

	public TelaPrincipal() {
		super();

		panelOpenFile.getBtnAbrirOpenFile().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int resultado = escolherArquivo.showOpenDialog(getContentPane());
				if (resultado == JFileChooser.APPROVE_OPTION) {
					arquivoSelecionado = escolherArquivo.getSelectedFile();
					panelOpenFile.getTxtOpenFile().setText(escolherArquivo.getSelectedFile().getAbsolutePath());
					numeroVertices = new Auxiliar().retornaQuantVertice(arquivoSelecionado);
				}
			}
		});

		ItemListener itemEscolhaAdjs = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (panelOpenFile.getRbLista().isSelected()) {
					interfaceGrafo = new GrafoComLista(numeroVertices);
				} else {
					interfaceGrafo = new GrafoComMatriz(numeroVertices);
				}
			}
		};

		panelOpenFile.getRbLista().addItemListener(itemEscolhaAdjs);
		panelOpenFile.getRbMatriz().addItemListener(itemEscolhaAdjs);

		panelOpenFile.getBtnGerarRepresentacao().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (arquivoSelecionado == null)
						throw new NullPointerException("Não há um grafo carregado.");

					if (panelOpenFile.getRbLista().isSelected() == false
							&& panelOpenFile.getRbMatriz().isSelected() == false) {
						JOptionPane.showMessageDialog(null, "Escolha uma das formas de representação de adjacências.");
					} else {
						new Auxiliar().carregaGrafo(arquivoSelecionado, interfaceGrafo);
						panelOpenFile.getLblArquivoCarregado()
								.setText("Arquivo " + arquivoSelecionado.getName() + " carregado!");
					}
				} catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, npe.getMessage());
				}
			}
		});

		panelPesquisaLarguraProfundidade.getBtnPesquisar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int vertice = Integer.parseInt(panelPesquisaLarguraProfundidade.getTxtVerticeInicial().getText());

					if (arquivoSelecionado == null)
						throw new NullPointerException("Não há um grafo carregado.");

					if (vertice >= numeroVertices || vertice < 0)
						throw new IndexOutOfBoundsException(
								"Você digitou um número de vértice inválido. Digite no intervalo entre 0 e "
										+ (numeroVertices - 1) + ".");

					if (panelPesquisaLarguraProfundidade.getRbLargura().isSelected()) {
						String resultado = interfaceGrafo.buscaEmLargura(vertice);
						JOptionPane.showMessageDialog(null, resultado);
					} else {
						String resultado = interfaceGrafo.buscaEmProfundidade(vertice);
						JOptionPane.showMessageDialog(null, resultado);
					}

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Há algo errado com o número que você digitou.");
				} catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, npe.getMessage());
				} catch (IndexOutOfBoundsException ioobe) {
					JOptionPane.showMessageDialog(null, ioobe.getMessage());
				}
			}

		});

		panelGerarArquivoGrafo.getBtnGerarArquivo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (arquivoSelecionado == null)
						throw new NullPointerException("Não há um grafo carregado.");

					int resultado = salvarArquivo.showSaveDialog(getContentPane());

					if (resultado == JFileChooser.APPROVE_OPTION) {
						String texto = "Número de vértices: " + numeroVertices + "\n";
						texto += "Número de Arestas: " + new Auxiliar().retornaNumeroDeArestas(arquivoSelecionado);

						boolean res = new Arquivo().escreverArquivoGrafo(salvarArquivo.getSelectedFile(), texto);

						if (res) {
							JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso.");
						} else {
							JOptionPane.showMessageDialog(null, "Houve um erro ao salvar arquivo.");
						}
					}
				} catch (NullPointerException npe) {
					JOptionPane.showMessageDialog(null, npe.getMessage());
				}
			}

		});

		panelArvoreGeradoraMinima.getBtnMostrarArvore().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (arquivoSelecionado == null)
						throw new NullPointerException("Não há um grafo carregado.");

					int vertice = Integer.parseInt(panelArvoreGeradoraMinima.getTxtVertice().getText());

					String res = interfaceGrafo.arvoreGeradoraMinima(vertice);

					JOptionPane.showMessageDialog(null, res);
				} catch (NullPointerException ne) {
					JOptionPane.showMessageDialog(null, ne.getMessage());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Há algo errado com o número que você digitou.");
				}
			}
		});
	}
}
