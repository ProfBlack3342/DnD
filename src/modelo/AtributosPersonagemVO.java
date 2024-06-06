/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import enums.AtributosEnum;
import java.util.HashMap;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class AtributosPersonagemVO extends AtributosVO
{
    private int idUsuario;
    private int idPersonagem;

    public AtributosPersonagemVO(int idUsuario, int idPersonagem, int valorSTR, int valorDEX, int valorCON, int valorINT, int valorWIS, int valorCHA) {
        super(valorSTR, valorDEX, valorCON, valorINT, valorWIS, valorCHA);
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
    }
    public AtributosPersonagemVO(int idUsuario, int idPersonagem, HashMap<AtributosEnum, Integer> valoresAtributos, HashMap<AtributosEnum, Boolean> proficienciasAtributos)
    {
        super(valoresAtributos, proficienciasAtributos);
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
    }

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getIdPersonagem() {return idPersonagem;}
    public void setIdPersonagem(int idPersonagem) {this.idPersonagem = idPersonagem;}
}
