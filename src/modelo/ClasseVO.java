/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class ClasseVO extends ObjetoVO
{
    private String nome;
    private String descricao;
    
    private int dadoClasse;
    private FeatClasseVO[] featsClasse;
    private AtributosVO bonusEProficienciasAtributos;
    private PericiasVO proficienciasPericias;
    private ProficienciasVO proficiencias;

    public ClasseVO() {
    }

    
    
    public ClasseVO(String nome, String descricao, int dadoClasse, FeatClasseVO[] featsClasse, AtributosVO bonusEProficienciasAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias) {
        this.nome = nome;
        this.descricao = descricao;
        this.dadoClasse = dadoClasse;
        this.featsClasse = featsClasse;
        this.bonusEProficienciasAtributos = bonusEProficienciasAtributos;
        this.proficienciasPericias = proficienciasPericias;
        this.proficiencias = proficiencias;
    }

    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public int getDadoClasse() {return dadoClasse;}
    public void setDadoClasse(int dadoClasse) {this.dadoClasse = dadoClasse;}
    
    public FeatClasseVO[]getFeatsClasse() {return featsClasse;}
    public void setFeatsClasse(FeatClasseVO[] featsClasse) {this.featsClasse = featsClasse;}
    
    public AtributosVO getBonusEProficienciasAtributos() {return bonusEProficienciasAtributos;}
    public void setBonusEProficienciasAtributos(AtributosVO bonusEProficienciasAtributos) {this.bonusEProficienciasAtributos = bonusEProficienciasAtributos;}
    
    public PericiasVO getProficienciasPericias() {return proficienciasPericias;}
    public void setProficienciasPericias(PericiasVO proficienciasPericias) {this.proficienciasPericias = proficienciasPericias;}
    
    public ProficienciasVO getProficiencias() {return proficiencias;}
    public void setProficiencias(ProficienciasVO proficiencias) {this.proficiencias = proficiencias;}
    
}
