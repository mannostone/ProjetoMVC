package br.estacio.testes;

import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saluo
 */
public class TesteSelect {
    public static void main(String[] args) {
    	// Capta o email do banco de dados e salva no  Usu�rio
        UsuarioDAO dao = new UsuarioDAO();
        // o campo � salvo em user
        Usuario user = dao.getUsuario("Bibi@email.com");
        // � exibido
        System.out.println(user.toString());
        // e depois validado com um m�todo da Classe usu�rio
        System.out.println(user.validarLogin("Bibi@email.com", "Pizza"));
    }
}
