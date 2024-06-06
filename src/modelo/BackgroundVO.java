/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class BackgroundVO extends ObjetoVO
{
    private String nome;
    private String feature;
    private ProficienciasVO proficiencias;
    private EquipamentoVO[] equipamento;
    private String[] SugestoesDetalhes;
    
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getFeature() {return feature;}
    public void setFeature(String feature) {this.feature = feature;}
    
    public ProficienciasVO getProficiencias() {return proficiencias;}
    public void setProficiencias(ProficienciasVO proficiencias) {this.proficiencias = proficiencias;}

    public EquipamentoVO[] getEquipamento() {return equipamento;}
    public void setEquipamento(EquipamentoVO[] equipamento) {this.equipamento = equipamento;}
    
    public String[] getSugestoesDetalhes() {return SugestoesDetalhes;}
    public void setSugestoesDetalhes(String[] SugestoesDetalhes) {this.SugestoesDetalhes = SugestoesDetalhes;}
}
