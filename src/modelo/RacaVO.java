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
public final class RacaVO extends ObjetoVO
{
    private int bonusStr, bonusDex, bonusCon, bonusInt, bonusWis, bonusCha;
    private String formatoCorpo;
    private int idadeMinima;
    private int idadeMaxima;
    private String[] tamanho;
    private int velocidade;
    private TracoRacaVO[] tracosRaca;
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

    public String getFormatoCorpo() {
        return formatoCorpo;
    }
    public void setFormatoCorpo(String formatoCorpo) {
        this.formatoCorpo = formatoCorpo;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }
    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public int getIdadeMaxima() {
        return idadeMaxima;
    }
    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    public String[] getTamanho() {
        return tamanho;
    }
    public void setTamanho(String[] tamanho) {
        this.tamanho = tamanho;
    }

    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public TracoRacaVO[] getTracosRaca() {
        return tracosRaca;
    }
    public void setTracosRaca(TracoRacaVO[] tracosRaca) {
        this.tracosRaca = tracosRaca;
    }

    public LinguagemVO[] getLinguagensRaca() {
        return linguagensRaca;
    }
    public void setLinguagensRaca(LinguagemVO[] linguagensRaca) {
        this.linguagensRaca = linguagensRaca;
    }
}
