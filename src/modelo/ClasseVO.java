/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class ClasseVO extends ObjetoVO
{
    private String nome;
    private String descricao;
    
    private AtributosVO bonusAtributos;
    private PericiasVO proficienciasPericias;
    private ProficienciasVO proficiencias;

    public ClasseVO(String nome, String descricao, AtributosVO bonusAtributos, PericiasVO proficienciasPericias, ProficienciasVO proficiencias) {
        this.nome = nome;
        this.descricao = descricao;
        this.bonusAtributos = bonusAtributos;
        this.proficienciasPericias = proficienciasPericias;
        this.proficiencias = proficiencias;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    
    public AtributosVO getBonusAtributos() {return bonusAtributos;}
    public void setBonusAtributos(AtributosVO bonusAtributos) {this.bonusAtributos = bonusAtributos;}
    
    public PericiasVO getProficienciasPericias() {return proficienciasPericias;}
    public void setProficienciasPericias(PericiasVO proficienciasPericias) {this.proficienciasPericias = proficienciasPericias;}
    
    public ProficienciasVO getProficiencias() {return proficiencias;}
    public void setProficiencias(ProficienciasVO proficiencias) {this.proficiencias = proficiencias;}
    
}
