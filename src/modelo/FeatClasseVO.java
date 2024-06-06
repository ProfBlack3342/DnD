/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class FeatClasseVO extends FeatVO
{
    private int idClasse;
    private int idSubclasse;

    public FeatClasseVO(int idClasse) {
        this.idClasse = idClasse;
    }

    public FeatClasseVO(int idClasse, int idSubclasse) {
        this.idClasse = idClasse;
        this.idSubclasse = idSubclasse;
    }

    public FeatClasseVO(int idClasse, String nome, String descricao, String fonte, SpellVO[] spells, AtributosVO bonusEProficienciasAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias) {
        super(nome, descricao, fonte, spells, bonusEProficienciasAtributos, proficienciasPericias, proficiencias);
        this.idClasse = idClasse;
    }

    public FeatClasseVO(int idClasse, int idSubclasse, String nome, String descricao, String fonte, SpellVO[] spells, AtributosVO bonusEProficienciasAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias) {
        super(nome, descricao, fonte, spells, bonusEProficienciasAtributos, proficienciasPericias, proficiencias);
        this.idClasse = idClasse;
        this.idSubclasse = idSubclasse;
    }

    
    
    

    public int getIdClasse() {return idClasse;}
    public void setIdClasse(int idClasse) {this.idClasse = idClasse;}

    public int getIdSubclasse() {return idSubclasse;}
    public void setIdSubclasse(int idSubclasse) {this.idSubclasse = idSubclasse;}
}
