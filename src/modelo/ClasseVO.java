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
public class ClasseVO extends ObjetoVO
{
    private int dadoClasse;
    private FeatureClasseVO[] featuresClasse;

    public int getDadoClasse() {
        return dadoClasse;
    }
    public void setDadoClasse(int dadoClasse) {
        this.dadoClasse = dadoClasse;
    }
}
