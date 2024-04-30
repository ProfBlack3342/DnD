/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import enums.AtributosEnum;
import java.util.HashMap;

/**
 *
 * @author dudup
 */
public class AtributosVO extends ObjetoVO
{
    private final int idUsuario;
    private final int idPersonagem;
    
    private final HashMap<AtributosEnum, Integer> valoresAtributos;
    private final HashMap<AtributosEnum, Boolean> proficienciasAtributos;

    public AtributosVO(int idUsuario, int idPersonagem, int valorSTR, int valorDEX, int valorCON, int valorINT, int valorWIS, int valorCHA) {
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
        
        valoresAtributos = new HashMap<>();
        valoresAtributos.put(AtributosEnum.STR, valorSTR);
        valoresAtributos.put(AtributosEnum.DEX, valorDEX);
        valoresAtributos.put(AtributosEnum.CON, valorCON);
        valoresAtributos.put(AtributosEnum.INT, valorINT);
        valoresAtributos.put(AtributosEnum.WIS, valorWIS);
        valoresAtributos.put(AtributosEnum.CHA, valorCHA);
        
        proficienciasAtributos = new HashMap<>();
        proficienciasAtributos.put(AtributosEnum.STR, false);
        proficienciasAtributos.put(AtributosEnum.DEX, false);
        proficienciasAtributos.put(AtributosEnum.CON, false);
        proficienciasAtributos.put(AtributosEnum.INT, false);
        proficienciasAtributos.put(AtributosEnum.WIS, false);
        proficienciasAtributos.put(AtributosEnum.CHA, false);
    }

    public AtributosVO(int idUsuario, int idPersonagem, HashMap<AtributosEnum, Integer> valoresAtributos, HashMap<AtributosEnum, Boolean> proficienciasAtributos) {
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
        this.valoresAtributos = valoresAtributos;
        this.proficienciasAtributos = proficienciasAtributos;
    }
    
    public int getIdUsuario() {return idUsuario;}
    
    public int getIdPersonagem() {return idPersonagem;}
    
    /**
     * Retorna o valor de um atributo
     * @param atributo O atributo que se deseja saber o valor
     * @return O valor do atributo
     */
    public int getValorAtributoPersonagem(AtributosEnum atributo) {
        return valoresAtributos.get(atributo);
    }

    /**
     * Muda o valor de um atributo
     * @param atributo O atributo com valor a ser modificado
     * @param valor O valor novo para o atributo
     */
    public void setValorAtributo(AtributosEnum atributo, int valor) {
        valoresAtributos.remove(atributo);
        valoresAtributos.put(atributo, valor);
    }

    /**
     * Retorna se o personagem é proficiente em um save de atributo
     * @param atributo O atributo que se deseja saber a proficiencia
     * @return Verdadeiro se for proficiente, Falso se não for
     */
    public boolean getProficienciaAtributo(AtributosEnum atributo) {
        return proficienciasAtributos.get(atributo);
    }

    /**
     * Muda o valor da proficiencia de um atributo
     * @param atributo O atributo com a proficiencia a ser alterada
     * @param proficiencia O valor novo para a proficiencia do atributo
     */
    public void setProficienciaAtributo(AtributosEnum atributo, boolean proficiencia) {
        proficienciasAtributos.remove(atributo);
        proficienciasAtributos.put(atributo, proficiencia);
    }
}
