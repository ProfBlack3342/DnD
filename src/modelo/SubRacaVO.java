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
    private int bonusStr, bonusDex, bonusCon, bonusInt, bonusWis, bonusCha;
    private TracoSubRacaVO[] tracosSubRaca;
    private LinguagemVO[] linguagensRaca;

    public int getBonusStr() {
        return bonusStr;
    }
    public void setBonusStr(int bonusStr) {
        this.bonusStr = bonusStr;
    }

    public int getBonusDex() {
        return bonusDex;
    }
    public void setBonusDex(int bonusDex) {
        this.bonusDex = bonusDex;
    }

    public int getBonusCon() {
        return bonusCon;
    }
    public void setBonusCon(int bonusCon) {
        this.bonusCon = bonusCon;
    }

    public int getBonusInt() {
        return bonusInt;
    }
    public void setBonusInt(int bonusInt) {
        this.bonusInt = bonusInt;
    }

    public int getBonusWis() {
        return bonusWis;
    }
    public void setBonusWis(int bonusWis) {
        this.bonusWis = bonusWis;
    }

    public int getBonusCha() {
        return bonusCha;
    }
    public void setBonusCha(int bonusCha) {
        this.bonusCha = bonusCha;
    }

    public TracoSubRacaVO[] getTracosSubRaca() {
        return tracosSubRaca;
    }
    public void setTracosSubRaca(TracoSubRacaVO[] tracosSubRaca) {
        this.tracosSubRaca = tracosSubRaca;
    }

    public LinguagemVO[] getLinguagensRaca() {
        return linguagensRaca;
    }
    public void setLinguagensRaca(LinguagemVO[] linguagensRaca) {
        this.linguagensRaca = linguagensRaca;
    }
}
