package br.estacio.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Criptografia {
	// Gerador de chaves criptografadas com base no algoritmo fornecido
	private static final byte[] CHAVE_DE_CRIPTOGRAFIA = "0123456789abcdef".getBytes();
	
	public static String encrypt(String senha) {
		byte[] senhaCripto = null;
		
		try {
			// Blowfish = um dos algoritmos de criptografia
			SecretKeySpec key = new SecretKeySpec (CHAVE_DE_CRIPTOGRAFIA, "Blowfish");
			
			Cipher encripta = Cipher.getInstance("Blowfish");
			// executa a criptografia
			encripta.init(Cipher.ENCRYPT_MODE, key);
			// Atribui o  valor criptografado a variavel
			senhaCripto = encripta.doFinal(senha.getBytes());	
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// ?
		return new String (Base64.getEncoder().encode(senhaCripto));
	}
	
	public static String decrypt(String senha) {
		byte[] senhaDescripto = null;

		try {
			// Blowfish = Algoritmo de criptografia
			SecretKeySpec key = new SecretKeySpec (CHAVE_DE_CRIPTOGRAFIA, "Blowfish");
			
			Cipher decripta = Cipher.getInstance("Blowfish");
			// executa a criptografia
			decripta.init(Cipher.DECRYPT_MODE, key);
			// Atribui o  valor criptografado a variavel
			senhaDescripto = decripta.doFinal(Base64.getDecoder().decode(senha));	
			
		} catch (Exception e) {
			System.out.println(e);
		}
		// ??
		return new String (senhaDescripto);
	}
	
}
