/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.modelo;

import br.estacio.util.Criptografia;

public class Usuario {
	// Campos
    private int id;
    private String nome;
    private String email;
    private String senha;
    // Métodos
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + '}';
    }
    
    public boolean validarLogin(String email, String senha){
    	// Usando a descriptografia ele compara a senha do banco com a senha digitada
        return (this.email.equals(email) && Criptografia.decrypt(getSenha()).equals(senha));
    }
}
