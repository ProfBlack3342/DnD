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
public class FerramentaVO extends EquipamentoVO
{
    private boolean consumivel;
    private int quantidade;

    public boolean isConsumivel() {
        return consumivel;
    }
    public void setConsumivel(boolean consumivel) {
        this.consumivel = consumivel;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
