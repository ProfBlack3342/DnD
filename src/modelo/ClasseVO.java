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
public class ClasseVO extends ObjetoVO
{
    private String nome;
    private String descricao;
    private int dadoHP;
    private SkillVO[] proficienciasIniciais;
    private EquipamentoVO[][] equipamentosIniciaisDisponiveis;
    private EquipamentoVO[] equipamentoInicialEscolhido;
    private FeatureClasseVO[] features;

    public ClasseVO() {
        for(SkillVO s : proficienciasIniciais) {
            s.setProficiente(true);
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDadoHP() {
        return dadoHP;
    }
    public void setDadoHP(int dadoHP) {
        this.dadoHP = dadoHP;
    }

    public SkillVO[] getProficienciasIniciais() {
        return proficienciasIniciais;
    }
    public void setProficienciasIniciais(SkillVO[] proficienciasIniciais) {
        this.proficienciasIniciais = proficienciasIniciais;
    }

    public EquipamentoVO[][] getEquipamentosIniciaisDisponiveis() {
        return equipamentosIniciaisDisponiveis;
    }

    public EquipamentoVO[] getEquipamentoInicialEscolhido() {
        return equipamentoInicialEscolhido;
    }
    public void setEquipamentoInicialEscolhido(int listaEscolhida) {
        this.equipamentoInicialEscolhido = this.equipamentosIniciaisDisponiveis[listaEscolhida];
    }

    public FeatureClasseVO[] getFeatures() {
        return features;
    }
    public void setFeatures(FeatureClasseVO[] features) {
        this.features = features;
    }
}
