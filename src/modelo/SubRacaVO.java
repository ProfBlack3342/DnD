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
public class SubRacaVO extends ObjetoVO
{
    private String nome;
    private String descricao;
    private int[] aumentosScoresHabilidade = new int[6];
    private FeatureSubRacaVO[] featuresSubRaca;

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

    public int[] getAumentosScoresHabilidade() {
        return aumentosScoresHabilidade;
    }
    public void setAumentosScoresHabilidade(int[] aumentosScoresHabilidade) {
        this.aumentosScoresHabilidade = aumentosScoresHabilidade;
    }

    public FeatureSubRacaVO[] getFeaturesSubRaca() {
        return featuresSubRaca;
    }
    public void setFeaturesSubRaca(FeatureSubRacaVO[] featuresSubRaca) {
        this.featuresSubRaca = featuresSubRaca;
    }
}
