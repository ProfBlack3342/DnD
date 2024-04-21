/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author dudup
 */
public class AtaquesESpellsVO extends ObjetoVO
{
    private ArrayList<EquipamentoVO> listaArmas;
    private ArrayList<SpellVO> listaSpells;
    private ArrayList<TracoRacaVO> listaTracos;

    public ArrayList<EquipamentoVO> getListaArmas() { return listaArmas;}
    public EquipamentoVO[] getListaArmasAsArray() {
        EquipamentoVO[] arrayRetorno = new EquipamentoVO[listaArmas.size()];
        
        for (int i = 0; i < arrayRetorno.length; i++) {
            arrayRetorno[i] = listaArmas.get(i);
        }
        
        return arrayRetorno;
    }
    public void setListaArmas(ArrayList<EquipamentoVO> listaArmas) {this.listaArmas = listaArmas;}
    public void addArma(EquipamentoVO arma) {listaArmas.add(arma);}
    public void removeArma(int indice){listaArmas.remove(indice);}

    public ArrayList<SpellVO> getListaSpells() {return listaSpells;}
    public SpellVO[] getListaSpellsAsArray() {
        SpellVO[] arrayRetorno = new SpellVO[listaSpells.size()];
        
        for (int i = 0; i < arrayRetorno.length; i++) {
            arrayRetorno[i] = listaSpells.get(i);
        }
        
        return arrayRetorno;
    }
    public void setListaSpells(ArrayList<SpellVO> listaSpells) {this.listaSpells = listaSpells;}
    public void addSpell(SpellVO spell) {listaSpells.add(spell);}
    public void removeSpell(int indice) {listaSpells.remove(indice);}

    public ArrayList<TracoRacaVO> getListaTracos() {return listaTracos;}
    public TracoRacaVO[] getListaTracosAsArray(){
        TracoRacaVO[] arrayRetorno = new TracoRacaVO[listaTracos.size()];
        
        for (int i = 0; i < arrayRetorno.length; i++) {
            arrayRetorno[i] = listaTracos.get(i);
        }
        
        return arrayRetorno;
    }
    public void setListaTracos(ArrayList<TracoRacaVO> listaTracos) {this.listaTracos = listaTracos;}
    public void addTraco(TracoRacaVO tracoRaca) {listaTracos.add(tracoRaca);}
    public void addTraco(TracoSubRacaVO tracoSubRaca) {listaTracos.add(tracoSubRaca);}
    public void removeTraco(int indice) {listaTracos.remove(indice);}
}
