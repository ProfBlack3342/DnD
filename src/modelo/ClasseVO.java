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
    private final EquipamentoVO[][] equipamentosClasse;
    
    public ClasseVO(EquipamentoVO[][] equipamentosBackground)
    {
        this.equipamentosClasse = equipamentosBackground;
    }

    public EquipamentoVO[][] getEquipamentosClasse() {
        return equipamentosClasse;
    }
}
