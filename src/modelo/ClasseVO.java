/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class ClasseVO  extends ObjetoVO
{
    private String nome;
    private ProficienciaVO[] proficiencias;
    private final EquipamentoVO[][] equipamentosClasse;

    public ClasseVO(ProficienciaVO[] proficiencias, EquipamentoVO[][] equipamentosClasse) {
        this.proficiencias = proficiencias;
        this.equipamentosClasse = equipamentosClasse;
    }

    public String getNome() {return nome;}
    
    public ProficienciaVO[] getProficiencias() {return proficiencias;}
    
    public EquipamentoVO[][] getEquipamentosClasse() {return equipamentosClasse;}
}
