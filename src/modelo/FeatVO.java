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
public class FeatVO extends ObjetoVO
{
    private String nome;
    private String descricao;
    private String fonte;
    
    private SpellVO[] spells;
    private AtributosVO bonusEProficienciasAtributos;
    private PericiasVO proficienciasPericias;
    private ProficienciasVO proficiencias;

    public FeatVO() {
    }

    public FeatVO(String nome, String descricao, String fonte, SpellVO[] spells, AtributosVO bonusEProficienciasAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias) {
        this.nome = nome;
        this.descricao = descricao;
        this.fonte = fonte;
        this.spells = spells;
        this.bonusEProficienciasAtributos = bonusEProficienciasAtributos;
        this.proficienciasPericias = proficienciasPericias;
        this.proficiencias = proficiencias;
    }
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getFonte() {return fonte;}
    public void setFonte(String fonte) {this.fonte = fonte;}

    public SpellVO[] getSpells() {return spells;}
    public void setSpells(SpellVO[] spells) {this.spells = spells;}

    public AtributosVO getBonusEProficienciasAtributos() {return bonusEProficienciasAtributos;}
    public void setBonusEProficienciasAtributos(AtributosVO bonusEProficienciasAtributos) {this.bonusEProficienciasAtributos = bonusEProficienciasAtributos;}

    public PericiasVO getProficienciasPericias() {return proficienciasPericias;}
    public void setProficienciasPericias(PericiasVO proficienciasPericias) {this.proficienciasPericias = proficienciasPericias;}

    public ProficienciasVO getProficiencias() {return proficiencias;}
    public void setProficiencias(ProficienciasVO proficiencias) {this.proficiencias = proficiencias;}
}
