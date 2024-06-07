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
public enum QuantColunasBanco
{
    IMAGEM_USUARIO(5),
    PERSONAGEM(0),
    USUARIO(12),;
    
    private final int quantColunas;

    private QuantColunasBanco(int quantColunas) {
        this.quantColunas = quantColunas;
    }
    
    public int getQuantColunas() {return quantColunas;}
}
