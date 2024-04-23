/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class RacaVO extends ObjetoVO
{
    private String nome;
    private int bonusStr, bonusDex, bonusCon, bonusInt, bonusWis, bonusCha;
    private ProficienciaVO[] proficiencias;

    public RacaVO(String nome, int bonusStr, int bonusDex, int bonusCon, int bonusInt, int bonusWis, int bonusCha, ProficienciaVO[] proficiencias) {
        this.nome = nome;
        this.bonusStr = bonusStr;
        this.bonusDex = bonusDex;
        this.bonusCon = bonusCon;
        this.bonusInt = bonusInt;
        this.bonusWis = bonusWis;
        this.bonusCha = bonusCha;
        this.proficiencias = proficiencias;
    }
    
    public String getNome() {return nome;}
    
    public int getBonusStr() {return bonusStr;}
    public int getBonusDex() {return bonusDex;}
    public int getBonusCon() {return bonusCon;}
    public int getBonusInt() {return bonusInt;}
    public int getBonusWis() {return bonusWis;}
    public int getBonusCha() {return bonusCha;}

    public ProficienciaVO[] getProficiencias() {return proficiencias;}
}
