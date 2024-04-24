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
public final class ProficienciaFerramentaVO extends ProficienciaVO
{
    private final int[] idFerramentas;

    public ProficienciaFerramentaVO(int[] idFerramentas) {this.idFerramentas = idFerramentas;}

    public int[] getIdFerramentas() {return idFerramentas;}
}
