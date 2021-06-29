/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.modelo;

import br.estacio.conexao.ConnectionFactory;
import br.estacio.util.Criptografia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conn;
    // Inicia uma conexão
    public UsuarioDAO() {
        conn = new ConnectionFactory().getConnection();
    }

    public boolean grava(Usuario usuario) {

        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, Criptografia.encrypt(usuario.getSenha()));

            stmt.execute();

            System.out.println("Funcionario gravado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public Usuario getUsuario(String email) {
        Usuario user = new Usuario();
        String sql = "SELECT id, nome, email, senha FROM usuario WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setNome(rs.getString("nome"));
                    user.setEmail(rs.getString("email"));
                    user.setSenha((rs.getString("senha")));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
