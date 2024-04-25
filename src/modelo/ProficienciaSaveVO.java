/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import enums.NomesSkillEnum;

/**
 *
 * @author 181700271
 */
public final class ProficienciaSaveVO extends ProficienciaVO
{
    private final NomesSkillEnum nomeSave;

    public ProficienciaSaveVO(NomesSkillEnum nomeSave) {
        this.nomeSave = nomeSave;
    }

    public NomesSkillEnum getNomeSave() {return nomeSave;}
}
