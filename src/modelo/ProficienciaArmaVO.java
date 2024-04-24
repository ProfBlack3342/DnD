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
public final class ProficienciaArmaVO extends ProficienciaVO
{
    private final int idArma;

    public ProficienciaArmaVO(int idArma) {
        this.idArma = idArma;
    }

    public int getIdArmas() {return idArma;}
}
