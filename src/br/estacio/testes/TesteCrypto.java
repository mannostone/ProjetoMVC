package br.estacio.testes;

import br.estacio.modelo.UsuarioDAO;
import br.estacio.util.Criptografia;

public class TesteCrypto {
	public static void main (String  [] args) {
		// TESTE PARALELO AO PROGRAMA EM SI
		String senha =  "manno";
		String senhaCripto = Criptografia.encrypt(senha);
		String senhaDecripto = Criptografia.decrypt(senhaCripto);
		
		System.out.println("Senha: " +  senha);
		System.out.println("Senha criptografada: " +  senhaCripto);
		System.out.println("Senha descriptografada: " +  senhaDecripto);

	}	
}
