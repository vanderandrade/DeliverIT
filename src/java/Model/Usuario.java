/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Vander
 */
public class Usuario {
    private String nome = "UNKNOW";
    private String senha = "UNKNOW";
     
    public Usuario(String name, String password){
        this.nome = name;
        this.senha = password;
    }
    public String getName() {
        return nome;
    }
    public void setName(String name) {
        this.nome = name;
    }
    public String getPassword() {
        return senha;
    }
    public void setPassword(String password) {
        this.senha = password;
    }
}
