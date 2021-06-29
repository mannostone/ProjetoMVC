/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author saluo
 */
public class ConnectionFactory {
	// Pega o endereço a ser conectado
    private final String URL = "jdbc:postgresql://localhost:5432/sistema";
    // O nome do usuário
    private final String USER = "postgres";
    // sua senha
    private final String PASS = "19981008"; 

    public Connection getConnection() {
        try { // Tenta fazer a conexão
            return DriverManager.getConnection(URL, USER, PASS); // faz a conexão com os dados informados
        } catch (SQLException e) { // Caso não consiga o erro será exibido
            throw new RuntimeException(e);
        }
    }
}
