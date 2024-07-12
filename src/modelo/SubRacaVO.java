/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class SubRacaVO extends ObjetoVO
{
    /*
        SubRaca (
            idSubRaca INT NOT NULL,
            idRaca INT NULL,

            nomeSubRaca VARCHAR(50) NOT NULL UNIQUE,
            descricaoSubRaca VARCHAR(500) NOT NULL,
            valorBuffAtributoSubRaca INT NOT NULL,
            idAtributoBuffadoSubRaca INT NOT NULL,
            quantFeaturesSubRaca INT NOT NULL,

            dataCriacaoSubRaca DATE NOT NULL,
            subRacaAtiva TINYINT(1) NOT NULL DEFAULT 1
        );
    */
    private static final String NOME_TABELA = "SubRaca";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idSubRaca",
        "idRaca",
        "nomeSubRaca",
        "descricaoSubRaca",
        "valorBuffAtributoSubRaca",
        "idAtributoBuffadoSubRaca",
        "quantFeaturesSubRaca",
        "dataCriacaoSubRaca",
        "subRacaAtiva"
    };
    
    private int idRaca;
    private String nome;
    private String descricao;
    private int valorBuffAtributos;
    private int idAtributoBuffado;
    private int quantFeatures;

    public static String getNomeTabela() {
        return NOME_TABELA;
    }
    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }

    public int getIdRaca() {
        return idRaca;
    }
    public void setIdRaca(int idRaca) {
        this.idRaca = idRaca;
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

    public int getValorBuffAtributos() {
        return valorBuffAtributos;
    }
    public void setValorBuffAtributos(int valorBuffAtributos) {
        this.valorBuffAtributos = valorBuffAtributos;
    }

    public int getIdAtributoBuffado() {
        return idAtributoBuffado;
    }
    public void setIdAtributoBuffado(int idAtributoBuffado) {
        this.idAtributoBuffado = idAtributoBuffado;
    }

    public int getQuantFeatures() {
        return quantFeatures;
    }
    public void setQuantFeatures(int quantFeatures) {
        this.quantFeatures = quantFeatures;
    }
}
