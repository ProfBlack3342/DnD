/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class ProficienciasPersonagemVO extends ProficienciasVO
{
    private int idUsuario;
    private int idPersonagem;

    public ProficienciasPersonagemVO(int idUsuario, int idPersonagem) {
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
    }

    public ProficienciasPersonagemVO(int idUsuario, int idPersonagem, ArmaduraVO[] proficienciasArmaduras, LinguagemVO[] proficienciasLinguagens, FerramentaVO[] proficienciasFerramentas, ArmaVO[] proficienciasArmas) {
        super(proficienciasArmaduras, proficienciasLinguagens, proficienciasFerramentas, proficienciasArmas);
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
    }

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getIdPersonagem() {return idPersonagem;}
    public void setIdPersonagem(int idPersonagem) {this.idPersonagem = idPersonagem;}
}
