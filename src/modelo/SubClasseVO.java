/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class SubClasseVO extends ObjetoVO
{
    /*
        SubClasse (
            idSubClasse INT NOT NULL,
            idClasse INT NOT NULL,

            idImagemSubClasse INT NOT NULL,

            nomeSubClasse VARCHAR(50) NOT NULL UNIQUE,
            descricaoSubClasse VARCHAR(500) NOT NULL,
            quantFeaturesSubClasse INT NOT NULL,

            dataCriacaoSubClasse DATE NOT NULL,
            subClasseAtiva TINYINT(1) NOT NULL DEFAULT 1
        );
    */
    private static final String NOME_TABELA = "SubClasse";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idSubClasse",
        "idClasse",
        "idImagemSubClasse",
        "nomeSubClasse",
        "descricaoSubClasse",
        "quantFeaturesSubClasse",
        "dataCriacaoSubClasse",
        "subClasseAtiva",
    };
    
    private int idClasse;
    private int idImagem;
    private String nome;
    private String descricao;
    private int quantFeatures;

    public static String getNomeTabela() {
        return NOME_TABELA;
    }
    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }

    public int getIdClasse() {
        return idClasse;
    }
    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
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

    public int getQuantFeatures() {
        return quantFeatures;
    }
    public void setQuantFeatures(int quantFeatures) {
        this.quantFeatures = quantFeatures;
    }
}
