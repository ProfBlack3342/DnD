/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author dudup
 */
public class ClasseVO extends ObjetoVO
{
    /*
        Classe (
            idClasse INT NOT NULL,

            idImagemClasse INT NOT NULL,

            nomeClasse VARCHAR(50) NOT NULL UNIQUE,
            descricaoClasse VARCHAR(500) NOT NULL,
            bonusProficienciaInicialClasse INT NOT NULL,
            dadoClasse INT NOT NULL,
            quantProficienciasArmasClasse INT NOT NULL,
            quantProficienciasArmaduraClasse INT NOT NULL,
            quantProficienciasFerramentasClasse INT NOT NULL,
            quantProficienciasPericiasClasse INT NOT NULL,
            quantProficienciasSavesAtributosClasse INT NOT NULL,
            quantEquipamentosIniciaisClasse INT NOT NULL,
            quantFeaturesClasse INT NOT NULL,
            classeTemSpells TINYINT(1) NOT NULL,
            idAtributoSpells INT NULL,

            dataCriacaoClasse DATE NOT NULL,
            classeAtiva TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String NOME_TABELA = "Classe";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idClasse",
        "idImagemClasse",
        "nomeClasse",
        "descricaoClasse",
        "bonusProficienciaInicialClasse",
        "dadoClasse",
        "quantProficienciasArmasClasse",
        "quantProficienciasArmaduraClasse",
        "quantProficienciasFerramentasClasse",
        "quantProficienciasPericiasClasse",
        "quantProficienciasSavesAtributosClasse",
        "quantEquipamentosIniciaisClasse",
        "quantFeaturesClasse",
        "classeTemSpells",
        "idAtributoSpells",
        "dataCriacaoClasse",
        "classeAtiva"
    };
    
    private int idImagem;
    private String nome;
    private String descricao;
    private int bonusProficienciaInicial;
    private int dado;
    private int quantProficienciasArmas;
    private int quantProficienciasArmaduras;
    private int quantProficienciasFerramentas;
    private int quantProficienciasPericias;
    private int quantProficienciasSavesAtributos;
    private int quantEquipamentosIniciais;
    private int quantFeatures;
    private boolean temSpells;
    private int idAtributoSpell;

    public ClasseVO() {
        this.idImagem = 0;
        this.nome = null;
        this.descricao = null;
        this.bonusProficienciaInicial = 0;
        this.dado = 0;
        this.quantProficienciasArmas = 0;
        this.quantProficienciasArmaduras = 0;
        this.quantProficienciasFerramentas = 0;
        this.quantProficienciasPericias = 0;
        this.quantProficienciasSavesAtributos = 0;
        this.quantEquipamentosIniciais = 0;
        this.quantFeatures = 0;
        this.temSpells = false;
        this.idAtributoSpell = 0;
    }
    public ClasseVO(int idImagem, String nome, String descricao, int bonusProficienciaInicial, int dado, int quantProficienciasArmas, int quantProficienciasArmaduras, int quantProficienciasFerramentas, int quantProficienciasPericias, int quantProficienciasSavesAtributos, int quantEquipamentosIniciais, int quantFeatures, boolean temSpells, int idAtributoSpell, int id, Date dataCriacao) {
        super(id, dataCriacao);
        this.idImagem = idImagem;
        this.nome = nome;
        this.descricao = descricao;
        this.bonusProficienciaInicial = bonusProficienciaInicial;
        this.dado = dado;
        this.quantProficienciasArmas = quantProficienciasArmas;
        this.quantProficienciasArmaduras = quantProficienciasArmaduras;
        this.quantProficienciasFerramentas = quantProficienciasFerramentas;
        this.quantProficienciasPericias = quantProficienciasPericias;
        this.quantProficienciasSavesAtributos = quantProficienciasSavesAtributos;
        this.quantEquipamentosIniciais = quantEquipamentosIniciais;
        this.quantFeatures = quantFeatures;
        this.temSpells = temSpells;
        this.idAtributoSpell = idAtributoSpell;
    }
    public ClasseVO(int idImagem, String nome, String descricao, int bonusProficienciaInicial, int dado, int quantProficienciasArmas, int quantProficienciasArmaduras, int quantProficienciasFerramentas, int quantProficienciasPericias, int quantProficienciasSavesAtributos, int quantEquipamentosIniciais, int quantFeatures, boolean temSpells, int idAtributoSpell, int id, int diaCriacao, int mesCriacao, int anoCriacao) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.idImagem = idImagem;
        this.nome = nome;
        this.descricao = descricao;
        this.bonusProficienciaInicial = bonusProficienciaInicial;
        this.dado = dado;
        this.quantProficienciasArmas = quantProficienciasArmas;
        this.quantProficienciasArmaduras = quantProficienciasArmaduras;
        this.quantProficienciasFerramentas = quantProficienciasFerramentas;
        this.quantProficienciasPericias = quantProficienciasPericias;
        this.quantProficienciasSavesAtributos = quantProficienciasSavesAtributos;
        this.quantEquipamentosIniciais = quantEquipamentosIniciais;
        this.quantFeatures = quantFeatures;
        this.temSpells = temSpells;
        this.idAtributoSpell = idAtributoSpell;
    }

    public static String getNomeTabela() {
        return NOME_TABELA;
    }
    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }
    
    public int getIdImagem() {
        return idImagem;
    }
    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
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

    public int getBonusProficienciaInicial() {
        return bonusProficienciaInicial;
    }
    public void setBonusProficienciaInicial(int bonusProficienciaInicial) {
        this.bonusProficienciaInicial = bonusProficienciaInicial;
    }

    public int getDado() {
        return dado;
    }
    public void setDado(int dado) {
        this.dado = dado;
    }

    public int getQuantProficienciasArmas() {
        return quantProficienciasArmas;
    }
    public void setQuantProficienciasArmas(int quantProficienciasArmas) {
        this.quantProficienciasArmas = quantProficienciasArmas;
    }

    public int getQuantProficienciasArmaduras() {
        return quantProficienciasArmaduras;
    }
    public void setQuantProficienciasArmaduras(int quantProficienciasArmaduras) {
        this.quantProficienciasArmaduras = quantProficienciasArmaduras;
    }

    public int getQuantProficienciasFerramentas() {
        return quantProficienciasFerramentas;
    }
    public void setQuantProficienciasFerramentas(int quantProficienciasFerramentas) {
        this.quantProficienciasFerramentas = quantProficienciasFerramentas;
    }

    public int getQuantProficienciasPericias() {
        return quantProficienciasPericias;
    }
    public void setQuantProficienciasPericias(int quantProficienciasPericias) {
        this.quantProficienciasPericias = quantProficienciasPericias;
    }

    public int getQuantProficienciasSavesAtributos() {
        return quantProficienciasSavesAtributos;
    }
    public void setQuantProficienciasSavesAtributos(int quantProficienciasSavesAtributos) {
        this.quantProficienciasSavesAtributos = quantProficienciasSavesAtributos;
    }

    public int getQuantEquipamentosIniciais() {
        return quantEquipamentosIniciais;
    }
    public void setQuantEquipamentosIniciais(int quantEquipamentosIniciais) {
        this.quantEquipamentosIniciais = quantEquipamentosIniciais;
    }

    public int getQuantFeatures() {
        return quantFeatures;
    }
    public void setQuantFeatures(int quantFeatures) {
        this.quantFeatures = quantFeatures;
    }

    public boolean isTemSpells() {
        return temSpells;
    }
    public void setTemSpells(boolean temSpells) {
        this.temSpells = temSpells;
    }

    public int getIdAtributoSpell() {
        return idAtributoSpell;
    }
    public void setIdAtributoSpell(int idAtributoSpell) {
        this.idAtributoSpell = idAtributoSpell;
    }
}
