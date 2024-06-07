/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import enums.ColunasImagemUsuarioEnum;
import java.util.HashMap;

/**
 *
 * @author dudup
 */
public class ImagemPersonagemVO
{
    private final HashMap<ColunasImagemUsuarioEnum, String> valoresColuna;

    public ImagemPersonagemVO() {
        valoresColuna = new HashMap<>();
    }
    
    /**
     *
     * @param coluna
     * @return
     */
    public String getValorColuna(ColunasImagemUsuarioEnum coluna) {
        return valoresColuna.get(coluna);
    }
    
    /**
     *
     * @param coluna
     * @param valor
     */
    public void setValorColuna(ColunasImagemUsuarioEnum coluna, String valor) {
        valoresColuna.remove(coluna);
        valoresColuna.put(coluna, valor);
    }
    
    /**
     *
     * @param valorColuna
     */
    public void replaceValorColuna (HashMap<ColunasImagemUsuarioEnum, String> valorColuna) {
        valoresColuna.putAll(valorColuna);
    }
}
