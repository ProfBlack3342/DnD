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
public final class ProficienciaSaveVO extends ProficienciaVO
{
    private final String nomeSave;

    public ProficienciaSaveVO(String nomeSave) {
        this.nomeSave = nomeSave;
    }

    public String getNomeSave() {return nomeSave;}
}
