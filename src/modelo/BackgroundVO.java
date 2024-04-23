/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class BackgroundVO  extends ObjetoVO
{
    private String nome;
    private ProficienciaVO[] proficiencias;
    private final EquipamentoVO[][] equipamentosBackground;

    public BackgroundVO(String nome, ProficienciaVO[] proficiencias, EquipamentoVO[][] equipamentosBackground) {
        this.nome = nome;
        this.proficiencias = proficiencias;
        this.equipamentosBackground = equipamentosBackground;
    }
    
    public String getNome() {return nome;}
    
    public ProficienciaVO[] getProficiencias() {return proficiencias;}
    
    public EquipamentoVO[][] getEquipamentosBackground() {return equipamentosBackground;}
}
