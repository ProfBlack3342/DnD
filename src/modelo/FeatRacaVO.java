/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class FeatRacaVO extends FeatVO
{
    private int idRaca;
    private int idSubraca;

    public FeatRacaVO(int idRaca) {
        this.idRaca = idRaca;
    }

    public FeatRacaVO(int idRaca, int idSubraca) {
        this.idRaca = idRaca;
        this.idSubraca = idSubraca;
    }

    public FeatRacaVO(int idRaca, String nome, String descricao, String fonte, SpellVO[] spells, AtributosVO bonusEProficienciasAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias) {
        super(nome, descricao, fonte, spells, bonusEProficienciasAtributos, proficienciasPericias, proficiencias);
        this.idRaca = idRaca;
    }

    public FeatRacaVO(int idRaca, int idSubraca, String nome, String descricao, String fonte, SpellVO[] spells, AtributosVO bonusEProficienciasAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias) {
        super(nome, descricao, fonte, spells, bonusEProficienciasAtributos, proficienciasPericias, proficiencias);
        this.idRaca = idRaca;
        this.idSubraca = idSubraca;
    }

    

    public int getIdRaca() {return idRaca;}
    public void setIdRaca(int idRaca) {this.idRaca = idRaca;}

    public int getIdSubraca() {return idSubraca;}
    public void setIdSubraca(int idSubraca) {this.idSubraca = idSubraca;}
}
