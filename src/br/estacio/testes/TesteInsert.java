/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.testes;

import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;

/**
 *
 * @author saluo
 */
public class TesteInsert {
    public static void main(String[] args) {
        Usuario user = new Usuario();
        
        user.setNome("Gabi");
        user.setEmail("Bibi@email.com");
        user.setSenha("Pizza");

        
        UsuarioDAO dao = new UsuarioDAO();
        
        dao.grava(user);
        
        
    }
}
