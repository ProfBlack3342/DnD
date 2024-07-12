/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author dudup
 */
public class RacaVO extends ObjetoVO
{
    /*
        Raca (
            idRaca INT NOT NULL,

            idImagemRaca INT NOT NULL,

            nomeRaca VARCHAR(50) NOT NULL UNIQUE,
            descricaoRaca VARCHAR(500) NOT NULL,
            valorBuffAtributoRaca INT NOT NULL,
            idAtributoBuffadoRaca INT NOT NULL,
            idadeMaxRaca INT NOT NULL,
            tamanhoRaca VARCHAR(20) NOT NULL,
            velocidadeRaca INT NOT NULL,
            quantLinguagensRaca INT NOT NULL,
            quantFeaturesRaca INT NOT NULL,

            dataCriacaoRaca DATE NOT NULL,
            racaAtiva TINYINT(1) NOT NULL DEFAULT 1
        );
    */
    private static final String NOME_TABELA = "Raca";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idRaca",
        "idImagemRaca",
        "nomeRaca",
        "descricaoRaca",
        "valorBuffAtributoRaca",
        "idAtributoBuffadoRaca",
        "idadeMaxRaca",
        "tamanhoRaca",
        "velocidadeRaca",
        "quantLinguagensRaca",
        "quantFeaturesRaca",
        "dataCriacaoRaca",
        "racaAtiva"
    };
    
    private int idImagem;
    private String nome;
    private String descricao;
    private int valorBuffAtributo;
    private int idAtributoBuffado;
    private int idadeMax;
    private String tamanho;
    private int velocidade;
    private int quantLinguagens;
    private int quantFeatures;

    public RacaVO() {
        this.idImagem = 0;
        this.nome = null;
        this.descricao = null;
        this.valorBuffAtributo = 0;
        this.idAtributoBuffado = 0;
        this.idadeMax = 0;
        this.tamanho = null;
        this.velocidade = 0;
        this.quantLinguagens = 0;
        this.quantFeatures = 0;
    }
    public RacaVO(int idImagem, String nome, String descricao, int valorBuffAtributo, int idAtributoBuffado, int idadeMax, String tamanho, int velocidade, int quantLinguagens, int quantFeatures, int id, Date dataCriacao) {
        super(id, dataCriacao);
        this.idImagem = idImagem;
        this.nome = nome;
        this.descricao = descricao;
        this.valorBuffAtributo = valorBuffAtributo;
        this.idAtributoBuffado = idAtributoBuffado;
        this.idadeMax = idadeMax;
        this.tamanho = tamanho;
        this.velocidade = velocidade;
        this.quantLinguagens = quantLinguagens;
        this.quantFeatures = quantFeatures;
    }
    public RacaVO(int idImagem, String nome, String descricao, int valorBuffAtributo, int idAtributoBuffado, int idadeMax, String tamanho, int velocidade, int quantLinguagens, int quantFeatures, int id, int diaCriacao, int mesCriacao, int anoCriacao) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.idImagem = idImagem;
        this.nome = nome;
        this.descricao = descricao;
        this.valorBuffAtributo = valorBuffAtributo;
        this.idAtributoBuffado = idAtributoBuffado;
        this.idadeMax = idadeMax;
        this.tamanho = tamanho;
        this.velocidade = velocidade;
        this.quantLinguagens = quantLinguagens;
        this.quantFeatures = quantFeatures;
    }

    public static String getNomeTabela() {
        return NOME_TABELA;
    }
    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }

    public int getIdImagem() {
        return idImagem;
    }
    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValorBuffAtributo() {
        return valorBuffAtributo;
    }
    public void setValorBuffAtributo(int valorBuffAtributo) {
        this.valorBuffAtributo = valorBuffAtributo;
    }

    public int getIdAtributoBuffado() {
        return idAtributoBuffado;
    }
    public void setIdAtributoBuffado(int idAtributoBuffado) {
        this.idAtributoBuffado = idAtributoBuffado;
    }

    public int getIdadeMax() {
        return idadeMax;
    }
    public void setIdadeMax(int idadeMax) {
        this.idadeMax = idadeMax;
    }

    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getQuantLinguagens() {
        return quantLinguagens;
    }
    public void setQuantLinguagens(int quantLinguagens) {
        this.quantLinguagens = quantLinguagens;
    }

    public int getQuantFeatures() {
        return quantFeatures;
    }
    public void setQuantFeatures(int quantFeatures) {
        this.quantFeatures = quantFeatures;
    }
}
