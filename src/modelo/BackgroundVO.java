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
public class BackgroundVO extends ObjetoVO
{
    /*
        Background (
            idBackground INT NOT NULL,

            nomeBackground VARCHAR(50) NOT NULL UNIQUE,
            descricaoBackground VARCHAR(500) NOT NULL,
            ouroInicialBackground INT NULL,
            quantOpcoesEquipamentosIniciaisBackground INT NOT NULL,
            quantLinguagensIniciaisBackground INT NOT NULL,
            quantProficienciasFerramentasBackground INT NOT NULL,
            quantProficienciasPericiasBackground INT NOT NULL,
            quantFeaturesBackground INT NOT NULL,

            dataCriacaoBackground DATE NOT NULL,
            BackgroundAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String NOME_TABELA = "Background";
    
    private static final String[] NOMES_COLUNAS = new String[]{
        "idBackground",
        "nomeBackground",
        "descricaoBackground",
        "ouroInicialBackground",
        "quantOpcoesEquipamentosIniciaisBackground",
        "quantLinguagensIniciaisBackground",
        "quantProficienciasFerramentasBackground",
        "quantProficienciasPericiasBackground",
        "quantFeaturesBackground",
        "dataCriacaoBackground",
        "BackgroundAtivo"
    };
    
    private String nome;
    private String descricao;
    private int ouroInicial;
    private int quantOpcoesEquipamentosIniciais;
    private int quantLinguagensIniciais;
    private int quantProficienciasFerramentas;
    private int quantProficienciasPericias;
    private int quantFeatures;

    public BackgroundVO() {
        this.nome = null;
        this.descricao = null;
        this.ouroInicial = 0;
        this.quantOpcoesEquipamentosIniciais = 0;
        this.quantLinguagensIniciais = 0;
        this.quantProficienciasFerramentas = 0;
        this.quantProficienciasPericias = 0;
        this.quantFeatures = 0;
    }
    public BackgroundVO(String nome, String descricao, int ouroInicial, int quantOpcoesEquipamentosIniciais, int quantLinguagensIniciais, int quantProficienciasFerramentas, int quantProficienciasPericias, int quantFeatures, int id, Date dataCriacao) {
        super(id, dataCriacao);
        this.nome = nome;
        this.descricao = descricao;
        this.ouroInicial = ouroInicial;
        this.quantOpcoesEquipamentosIniciais = quantOpcoesEquipamentosIniciais;
        this.quantLinguagensIniciais = quantLinguagensIniciais;
        this.quantProficienciasFerramentas = quantProficienciasFerramentas;
        this.quantProficienciasPericias = quantProficienciasPericias;
        this.quantFeatures = quantFeatures;
    }
    public BackgroundVO(String nome, String descricao, int ouroInicial, int quantOpcoesEquipamentosIniciais, int quantLinguagensIniciais, int quantProficienciasFerramentas, int quantProficienciasPericias, int quantFeatures, int id, int diaCriacao, int mesCriacao, int anoCriacao) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.nome = nome;
        this.descricao = descricao;
        this.ouroInicial = ouroInicial;
        this.quantOpcoesEquipamentosIniciais = quantOpcoesEquipamentosIniciais;
        this.quantLinguagensIniciais = quantLinguagensIniciais;
        this.quantProficienciasFerramentas = quantProficienciasFerramentas;
        this.quantProficienciasPericias = quantProficienciasPericias;
        this.quantFeatures = quantFeatures;
    }
    
    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}

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

    public int getOuroInicial() {
        return ouroInicial;
    }
    public void setOuroInicial(int ouroInicial) {
        this.ouroInicial = ouroInicial;
    }

    public int getQuantOpcoesEquipamentosIniciais() {
        return quantOpcoesEquipamentosIniciais;
    }
    public void setQuantOpcoesEquipamentosIniciais(int quantOpcoesEquipamentosIniciais) {
        this.quantOpcoesEquipamentosIniciais = quantOpcoesEquipamentosIniciais;
    }

    public int getQuantLinguagensIniciais() {
        return quantLinguagensIniciais;
    }
    public void setQuantLinguagensIniciais(int quantLinguagensIniciais) {
        this.quantLinguagensIniciais = quantLinguagensIniciais;
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

    public int getQuantFeatures() {
        return quantFeatures;
    }
    public void setQuantFeatures(int quantFeatures) {
        this.quantFeatures = quantFeatures;
    }
}
