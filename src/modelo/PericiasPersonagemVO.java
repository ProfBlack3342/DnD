/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import enums.PericiasEnum;
import java.util.HashMap;

/**
 *
 * @author dudup
 */
public final class PericiasPersonagemVO extends PericiasVO
{
    private int idUsuario;
    private int idPersonagem;

    public PericiasPersonagemVO(int idUsuario, int idPersonagem) {
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
    }

    public PericiasPersonagemVO(int idUsuario, int idPersonagem, HashMap<PericiasEnum, Boolean> proficienciasPericias) {
        super(proficienciasPericias);
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
    }

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getIdPersonagem() {return idPersonagem;}
    public void setIdPersonagem(int idPersonagem) {this.idPersonagem = idPersonagem;}
}
