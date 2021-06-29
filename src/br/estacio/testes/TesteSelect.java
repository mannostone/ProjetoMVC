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
    	// Capta o email do banco de dados e salva no  Usuário
        UsuarioDAO dao = new UsuarioDAO();
        // o campo é salvo em user
        Usuario user = dao.getUsuario("Bibi@email.com");
        // é exibido
        System.out.println(user.toString());
        // e depois validado com um método da Classe usuário
        System.out.println(user.validarLogin("Bibi@email.com", "Pizza"));
    }
}
