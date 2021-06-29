package br.estacio.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import br.estacio.helper.UsuarioHelper;
import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;
import br.estacio.visao.NovoUsuario;

public class ControleNovoUsuario {
	
	private NovoUsuario visao; // br.estacio.visao
	private Usuario modelo;
	
	public ControleNovoUsuario() {
		this.visao = new NovoUsuario();
		this.visao.setVisible(true);
		
		iniciar();
	}
	
	private void iniciar() {
		// Marca um botão específicado para reagir ao ser pressionado com ENTER
		visao.getRootPane().setDefaultButton(visao.getBtnGravar());
		
		visao.getBtnGravar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioHelper helper = new UsuarioHelper(visao);
				// esse método retorna true caso um dos campos esteja em branco
				if(helper.formularioEmBranco()) {
					JOptionPane.showMessageDialog(visao, "Todos os campos devem ser preenchidos", "Error", JOptionPane.ERROR_MESSAGE);
				} else { //  gravar dados
					//
					UsuarioDAO dao = new UsuarioDAO();
					//método da classe usuarioHelper capta todos os dados digitados e o passa para modelo
					modelo = helper.getNovoUsuario();
					// depois de ja preenchido, agora ele será armazenado no Banco de  Dados
					dao.grava(modelo);
					// mensagem de confirmação
					JOptionPane.showMessageDialog(visao, "Cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					// limpa os campos digitados
					helper.limparTelaNovoUsuario();
					// Comando para fechar a janela automaticamente
					visao.dispatchEvent(new WindowEvent(visao, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
		
		visao.getBtnLimpar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioHelper helper = new UsuarioHelper(visao);
				helper.limparTelaNovoUsuario();
			}
		});
	}
}
