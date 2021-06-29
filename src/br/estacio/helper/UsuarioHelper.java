package br.estacio.helper;

import br.estacio.modelo.Usuario;
import br.estacio.visao.NovoUsuario;
import br.estacio.visao.TelaLogin;

public class UsuarioHelper {
	// instâncias de visão
	private TelaLogin loginUsuario;
	private NovoUsuario novoUsuario;
	// construtor sobrecarregado para cada tipo de janela
	public UsuarioHelper(NovoUsuario novoUsuario) {this.novoUsuario = novoUsuario;}
	public UsuarioHelper(TelaLogin telalogin) {this.loginUsuario = telalogin;}
	// Captura os dados da telaLogin
	public Usuario getUsuarioLogin() {
		Usuario usuario = new Usuario();
		// Acessa a tela de login e capta os dados digitados
		usuario.setEmail(loginUsuario.getTxtEmail().getText());
		usuario.setSenha(String.valueOf(loginUsuario.getTxtSenha().getPassword()));
	
		return usuario;
	}
	// Limpa os dados da Tela de Login
	public void limparTelaLogin() { 
		loginUsuario.getTxtEmail().setText("");
		loginUsuario.getTxtSenha().setText("");
	}
	// Interações de Criar novo Usuario
	public boolean formularioEmBranco() { 
		return (novoUsuario.getTxtNome().getText().isEmpty() ||	novoUsuario.getTxtEmail().getText().isEmpty() || String.valueOf(novoUsuario.getTxtSenha().getPassword()).isEmpty());
	}
	
	public Usuario getNovoUsuario () {
		Usuario user = new Usuario();
		// Seta os campos digitados no formulário em um objeto do tipo Usuario
		user.setNome(novoUsuario.getTxtNome().getText());
		user.setEmail(novoUsuario.getTxtEmail().getText());
		user.setSenha(String.valueOf(novoUsuario.getTxtSenha().getPassword()));
		
		return user;
	}
	
	public void limparTelaNovoUsuario() {
		novoUsuario.getTxtNome().setText("");
		novoUsuario.getTxtEmail().setText("");
		novoUsuario.getTxtSenha().setText("");
	}
}
