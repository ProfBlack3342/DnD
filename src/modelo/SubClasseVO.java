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
public class SubClasseVO extends ObjetoVO 
{
    private String nome;
    private String descricao;
    private FeatureSubClasseVO[] featuresSubClasse;

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

    public FeatureSubClasseVO[] getFeaturesSubClasse() {
        return featuresSubClasse;
    }
    public void setFeaturesSubClasse(FeatureSubClasseVO[] featuresSubClasse) {
        this.featuresSubClasse = featuresSubClasse;
    }
}
