/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class RacaVO extends ObjetoVO
{
    private String nome;
    private String descricao;
    
    private FeatRacaVO[] featsRaca;
    private AtributosVO bonusEProficienciasAtributos;
    private PericiasVO proficienciasPericias;
    private ProficienciasVO proficiencias;

    public RacaVO() {
    }
    
    

    public RacaVO(String nome, String descricao, FeatRacaVO[] featsRaca, AtributosVO bonusEProficienciasAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias) {
        this.nome = nome;
        this.descricao = descricao;
        this.featsRaca = featsRaca;
        this.bonusEProficienciasAtributos = bonusEProficienciasAtributos;
        this.proficienciasPericias = proficienciasPericias;
        this.proficiencias = proficiencias;
    }
    
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public FeatRacaVO[] getFeatsRaca() {return featsRaca;}
    public void setFeatsRaca(FeatRacaVO[] featsRaca) {this.featsRaca = featsRaca;}

    public AtributosVO getBonusEProficienciasAtributos() {return bonusEProficienciasAtributos;}
    public void setBonusEProficienciasAtributos(AtributosVO bonusEProficienciasAtributos) {this.bonusEProficienciasAtributos = bonusEProficienciasAtributos;}

    public PericiasVO getProficienciasPericias() {return proficienciasPericias;}
    public void setProficienciasPericias(PericiasVO proficienciasPericias) {this.proficienciasPericias = proficienciasPericias;}

    public ProficienciasVO getProficiencias() {return proficiencias;}
    public void setProficiencias(ProficienciasVO proficiencias) {this.proficiencias = proficiencias;}
}
