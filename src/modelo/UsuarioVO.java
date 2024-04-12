/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class UsuarioVO extends ObjetoVO
{
    int idUsuario;
    int idImagem;
    int idTipo;
    String nome;
    String senha;
    String descricao;
    int quantPersonagensTotal = 6;
    int quantPersonagensCriados = 0;
    String diaCriacao;
    String mesCriacao;
    String anoCriacao;
    boolean ativo = true;

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdImagem() {
        return idImagem;
    }
    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public int getIdTipo() {
        return idTipo;
    }
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantPersonagensTotal() {
        return quantPersonagensTotal;
    }
    public void setQuantPersonagensTotal(int quantPersonagensTotal) {
        this.quantPersonagensTotal = quantPersonagensTotal;
    }

    public int getQuantPersonagensCriados() {
        return quantPersonagensCriados;
    }
    public void setQuantPersonagensCriados(int quantPersonagensCriados) {
        this.quantPersonagensCriados = quantPersonagensCriados;
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
