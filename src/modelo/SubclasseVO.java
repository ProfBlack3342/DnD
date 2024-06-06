/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class SubclasseVO extends ClasseVO
{
    private int idClasse;

    public SubclasseVO(int idClasse) {
        this.idClasse = idClasse;
    }

    public SubclasseVO(String nome, String descricao, FeatClasseVO[] featsSubclasse, AtributosVO bonusAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias, int idClasse) {
        super(nome, descricao, 0, featsSubclasse, bonusAtributos, proficienciasPericias, proficiencias);
        this.idClasse = idClasse;
    }

    public int getIdClasse() {return idClasse;}
    public void setIdClasse(int idClasse) {this.idClasse = idClasse;}
    
    @Override
    public int getDadoClasse() {
        throw new UnsupportedOperationException("Erro em SubclasseVO.getDadoClasse: Uma subclasse não possui nem define o valor de um dado");
    }
    @Override
    public void setDadoClasse(int dadoClasse) {
        throw new UnsupportedOperationException("Erro em SubclasseVO.setDadoClasse: Uma subclasse não possui nem define o valor de um dado");
    }
}
