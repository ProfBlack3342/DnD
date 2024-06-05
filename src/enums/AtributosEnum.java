/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author 181700271
 */
public enum AtributosEnum
{
    STR("Força", "Strength"),
    DEX("Destreza", "Dexterity"),
    CON("Constituição", "Constitution"),
    INT("Inteligência", "Intelligence"),
    WIS("Sabedoria", "Wisdom"),
    CHA("Carisma", "Charisma");
    
    private final String nomePT, nomeEN;

    private AtributosEnum(String nomePT, String nomeEN) {
        this.nomePT = nomePT;
        this.nomeEN = nomeEN;
    }
    
    public String getNomePT() {return nomePT;}
    public String getNomeEN() {return nomeEN;}
}
