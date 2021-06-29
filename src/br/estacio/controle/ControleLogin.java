package br.estacio.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.estacio.helper.UsuarioHelper;
import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;
import br.estacio.visao.TelaLogin;

public class ControleLogin {
	private TelaLogin visao; // br.estacio.visao
	private Usuario modelo; // br.estacio.modelo
	
	public ControleLogin () {
		// Cria uma janela do tipo especificado
		visao = new TelaLogin();
		// Deixa a janela vis�vel
		visao.setVisible(true);
				
		iniciar();
	}
	
	public void iniciar () {
		// Marca um bot�o espec�ficado para reagir ao ser pressionado com ENTER
		visao.getRootPane().setDefaultButton(visao.getBtnLogin());
		
		visao.getBtnLogin().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO dao =  new UsuarioDAO();
				UsuarioHelper helper = new UsuarioHelper(visao);
				// armazena em usuarioForm os dados capturados da janela TeLaLogin
				Usuario usuarioForm = helper.getUsuarioLogin();
				// Pega o email informado no formulario
				modelo = dao.getUsuario(usuarioForm.getEmail());
				// M�todo validarLogin retorna um Boolean
				if(modelo.getEmail() != null && modelo.validarLogin(usuarioForm.getEmail(), usuarioForm.getSenha())) {
					JOptionPane.showMessageDialog(visao, "Usu�rio Logado \n" + modelo.toString());
					helper.limparTelaLogin(); 
				} else {
					JOptionPane.showMessageDialog(visao, "Usu�rio ou senha inv�lidos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		// Caso clique em "Criar usu�rio" uma nova janela ser� mostrada
		visao.getBtnNovoUsuario().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControleNovoUsuario novoUsuario = new ControleNovoUsuario();
			}
		});
	}
	
}
