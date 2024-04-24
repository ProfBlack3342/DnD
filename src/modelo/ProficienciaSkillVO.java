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
public final class ProficienciaSkillVO extends ProficienciaVO
{
    private final String[] nomeSkill;

    public ProficienciaSkillVO(String[] nomeSkill) {
        this.nomeSkill = nomeSkill;
    }

    public String[] getNomeSkill() {return nomeSkill;}
}
