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
public class BackgroundPersonagemVO extends ObjetoVO
{
    private ProficienciasVO[] proficienciasBackground;
    private LinguagemVO[] linguagensBackground;
    private EquipamentoVO[] equipamentoBackground;

    public ProficienciasVO[] getProficienciasBackground() {return proficienciasBackground; }
    public void setProficienciasBackground(ProficienciasVO[] proficienciasBackground) { this.proficienciasBackground = proficienciasBackground; }

    public LinguagemVO[] getLinguagensBackground() {return linguagensBackground;}
    public void setLinguagensBackground(LinguagemVO[] linguagensBackground) {this.linguagensBackground = linguagensBackground; }

    public EquipamentoVO[] getEquipamentoBackground() { return equipamentoBackground;}
    public void setEquipamentoBackground(EquipamentoVO[] equipamentoBackground) {this.equipamentoBackground = equipamentoBackground;}
}
