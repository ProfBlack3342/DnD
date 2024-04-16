/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 181700271
 */
public abstract class ObjetoVO
{
    private int id;
    private String diaCriacao;
    private String mesCriacao;
    private String anoCriacao;
    private boolean ativo = true;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDiaCriacao() {
        return diaCriacao;
    }
    public void setDiaCriacao(String diaCriacao) {
        this.diaCriacao = diaCriacao;
    }

    public String getMesCriacao() {
        return mesCriacao;
    }
    public void setMesCriacao(String mesCriacao) {
        this.mesCriacao = mesCriacao;
    }

    public String getAnoCriacao() {
        return anoCriacao;
    }
    public void setAnoCriacao(String anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
