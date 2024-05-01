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
public final class SubRacaVO extends RacaVO
{
    private int idRaca;

    public SubRacaVO(int idRaca) {
        this.idRaca = idRaca;
    }

    
    
    public SubRacaVO(String nome, String descricao, FeatRacaVO[] traits, AtributosVO bonusAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias, int idRaca) {
        super(nome, descricao, traits, bonusAtributos, proficienciasPericias, proficiencias);
        this.idRaca = idRaca;
    }

    public int getIdRaca() {return idRaca;}
    public void setIdRaca(int idRaca) {this.idRaca = idRaca;}
}
