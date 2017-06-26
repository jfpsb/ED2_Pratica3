package formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class TelaPrincipal extends TelaPrincipalControles {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8456970881979484775L;

	private File arquivoSelecionado;

	public TelaPrincipal() {
		super();

		panelOpenFile.getBtnAbrirOpenFile().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int resultado = escolherArquivo.showOpenDialog(getContentPane());
				if (resultado == JFileChooser.APPROVE_OPTION) {
					arquivoSelecionado = escolherArquivo.getSelectedFile();
					panelOpenFile.getTxtOpenFile().setText(escolherArquivo.getSelectedFile().getAbsolutePath());
				}
			}
		});

	}
}
