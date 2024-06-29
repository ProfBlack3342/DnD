/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public enum AtributosEnum
{
    STR("STR", "Força", "Strength"),
    DEX("DEX", "Destreza", "Dexterity"),
    CON("CON", "Constituição", "Constitution"),
    INT("INT", "Inteligência", "Intelligence"),
    WIS("WIS", "Sabedoria", "Wisdom"),
    CHA("CHA", "Carisma", "Charisma");
    
    private final String abreviacao, nomePT, nomeEN;

    private AtributosEnum(String abreviacao, String nomePT, String nomeEN) {
        this.abreviacao = abreviacao;
        this.nomePT = nomePT;
        this.nomeEN = nomeEN;
    }
    
    public String getAbreviacao() {return abreviacao;}
    public String getNomePT() {return nomePT;}
    public String getNomeEN() {return nomeEN;}
}
