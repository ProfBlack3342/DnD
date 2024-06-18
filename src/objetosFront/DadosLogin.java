/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosFront;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class DadosLogin
{
    private final String usuario;
    private final String hashSenha;

    public DadosLogin(String usuario, String senha) {
        this.usuario = usuario;
        this.hashSenha = senha;
    }

    public String getUsuario() {return usuario;}
    public String getHashSenha() {return hashSenha;}
}