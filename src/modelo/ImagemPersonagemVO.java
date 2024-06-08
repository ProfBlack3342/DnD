/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import enums.ColunasImagemUsuarioEnum;
import java.util.HashMap;
import utilidades.Converter;

/**
 *
 * @author dudup
 */
public class ImagemPersonagemVO extends ObjetoVO
{
    private final HashMap<ColunasImagemUsuarioEnum, Object> valoresColunas;

    public ImagemPersonagemVO() {
        valoresColunas = new HashMap<>();
    }
    
    /**
     *
     * @param coluna
     * @return
     */
    public Object getValorColuna(ColunasImagemUsuarioEnum coluna) {
        return valoresColunas.get(coluna);
    }
    
    public HashMap<ColunasImagemUsuarioEnum, Object> getValoresColunas() {
        return valoresColunas;
    }
    
    /**
     *
     * @param coluna
     * @param valor
     */
    public void setValorColuna(ColunasImagemUsuarioEnum coluna, Object valor) {
        valoresColunas.remove(coluna);
        valoresColunas.put(coluna, valor);
    }
    
    /**
     *
     * @param valorColuna
     */
    public void replaceValorColuna (HashMap<ColunasImagemUsuarioEnum, String> valorColuna) {
        valoresColunas.putAll(valorColuna);
    }
    
    
}
