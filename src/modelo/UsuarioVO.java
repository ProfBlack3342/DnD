/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public final class UsuarioVO extends ObjetoVO
{
    private int idImagem;
    private int idTipo;
    private String nome;
    private String senha;
    private String descricao;
    private int quantPersonagensMaxima = 6;
    private int quantPersonagensExistentes = 0;
    private PersonagemVO[] listaPersonagens = new PersonagemVO[quantPersonagensMaxima];

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

    public int getQuantPersonagensMaxima() {
        return quantPersonagensMaxima;
    }
    public void setQuantPersonagensMaxima(int quantPersonagensMaxima) {
        this.quantPersonagensMaxima = quantPersonagensMaxima;
    }

    public int getQuantPersonagensExistentes() {
        return quantPersonagensExistentes;
    }
    public void setQuantPersonagensExistentes(int quantPersonagensExistentes) {
        this.quantPersonagensExistentes = quantPersonagensExistentes;
    }

    public PersonagemVO[] getListaPersonagens() {
        return listaPersonagens;
    }
    public void setListaPersonagens(PersonagemVO[] listaPersonagens) {
        this.listaPersonagens = listaPersonagens;
    }
}
