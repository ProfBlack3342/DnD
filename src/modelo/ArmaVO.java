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
public class ArmaVO extends ObjetoVO
{
//    Arma (
//    idArma INT NOT NULL,
//    
//    idTipoArma INT NOT NULL,
//    nomeArma VARCHAR(50) NOT NULL,
//    descricaoArma VARCHAR(400) NOT NULL,
//    precoCobreArma INT NOT NULL,
//    precoPrataArma INT NOT NULL,
//    precoElectrumArma INT NOT NULL,
//    precoOuroArma INT NOT NULL,
//    precoPlatinaArma INT NOT NULL,
//    multiplicadorDadoArma INT NOT NULL DEFAULT 1,
//    dadoArma INT NOT NULL,
//    idTipoDano INT NULL,
//    pesoArma DOUBLE(5, 3) NOT NULL,
//    quantPropriedadesArma INT NOT NULL,
//    
//    dataCriacaoArma DATE NOT NULL,
//    armaAtiva TINYINT(1) NOT NULL DEFAULT 1
//    )
    private static final String NOME_TABELA = "arma";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idArma",
        "idTipoArma",
        "nomeArma",
        "descricaoArma",
        "precoCobreArma",
        "precoPrataArma",
        "precoElectrumArma",
        "precoOuroArma",
        "precoPlatinaArma",
        "multiplicadorDadoArma",
        "dadoArma",
        "idTipoDano",
        "pesoArma",
        "quantPropriedadesArma",
        "dataCriacaoArma",
        "armaAtiva"
    };
    private final int LIMITE_NOME_ARMA = 50;
    private final int LIMITE_DESCRICAO_ARMA = 400;
    private final double MAX_PESO_ARMA = 99.999;
    
    private int idTipoArma;
    private String nomeArma;
    private String descricaoArma;
    private int precoCobreArma, precoPrataArma, precoElectrumArma, precoOuroArma, precoPlatinaArma;
    private int multiplicadorDadoArma, dadoArma;
    private int idTipoDano;
    private double pesoArma;
    private int quantPropriedadesArma;

    public ArmaVO() {
        this.idTipoArma = 0;
        this.nomeArma = null;
        this.descricaoArma = null;
        this.precoCobreArma = 0;
        this.precoPrataArma = 0;
        this.precoElectrumArma = 0;
        this.precoOuroArma = 0;
        this.precoPlatinaArma = 0;
        this.multiplicadorDadoArma = 0;
        this.dadoArma = 0;
        this.idTipoDano = 0;
        this.pesoArma = 0;
        this.quantPropriedadesArma = 0;
    }
    public ArmaVO(int idTipoArma, String nomeArma, String descricaoArma, int precoCobreArma, int precoPrataArma, int precoElectrumArma, int precoOuroArma, int precoPlatinaArma, int multiplicadorDadoArma, int dadoArma, int idTipoDano, double pesoArma, int quantPropriedadesArma, int id, Date dataCriacao) {
        super(id, dataCriacao);
        this.idTipoArma = idTipoArma;
        this.nomeArma = nomeArma;
        this.descricaoArma = descricaoArma;
        this.precoCobreArma = precoCobreArma;
        this.precoPrataArma = precoPrataArma;
        this.precoElectrumArma = precoElectrumArma;
        this.precoOuroArma = precoOuroArma;
        this.precoPlatinaArma = precoPlatinaArma;
        this.multiplicadorDadoArma = multiplicadorDadoArma;
        this.dadoArma = dadoArma;
        this.idTipoDano = idTipoDano;
        this.pesoArma = pesoArma;
        this.quantPropriedadesArma = quantPropriedadesArma;
    }
    public ArmaVO(int idTipoArma, String nomeArma, String descricaoArma, int precoCobreArma, int precoPrataArma, int precoElectrumArma, int precoOuroArma, int precoPlatinaArma, int multiplicadorDadoArma, int dadoArma, int idTipoDano, double pesoArma, int quantPropriedadesArma, int id, int diaCriacao, int mesCriacao, int anoCriacao) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.idTipoArma = idTipoArma;
        this.nomeArma = nomeArma;
        this.descricaoArma = descricaoArma;
        this.precoCobreArma = precoCobreArma;
        this.precoPrataArma = precoPrataArma;
        this.precoElectrumArma = precoElectrumArma;
        this.precoOuroArma = precoOuroArma;
        this.precoPlatinaArma = precoPlatinaArma;
        this.multiplicadorDadoArma = multiplicadorDadoArma;
        this.dadoArma = dadoArma;
        this.idTipoDano = idTipoDano;
        this.pesoArma = pesoArma;
        this.quantPropriedadesArma = quantPropriedadesArma;
    }

    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}
    
    private void verificarTamanhoNomeArma(String nomeArma)
    {
        if(nomeArma.length() > LIMITE_NOME_ARMA)
            this.nomeArma = nomeArma.substring(0, LIMITE_NOME_ARMA);
        else
            this.nomeArma = nomeArma;
    }
    private void verificarTamanhoDescricaoArma(String descricaoArma)
    {
        if(descricaoArma.length() > LIMITE_DESCRICAO_ARMA)
            this.descricaoArma = descricaoArma.substring(0, LIMITE_DESCRICAO_ARMA);
        else
            this.descricaoArma = descricaoArma;
    }
    private void verificarValorPesoArma(double pesoArma)
    {
        if(pesoArma > MAX_PESO_ARMA)
            this.pesoArma = MAX_PESO_ARMA;
        else
            this.pesoArma = pesoArma;
    }

    public int getIdTipoArma() {return idTipoArma;}
    public void setIdTipoArma(int idTipoArma) {this.idTipoArma = idTipoArma;}

    public String getNomeArma() {return nomeArma;}
    public void setNomeArma(String nomeArma) {verificarTamanhoNomeArma(nomeArma);}

    public String getDescricaoArma() {return descricaoArma;}
    public void setDescricaoArma(String descricaoArma) {verificarTamanhoDescricaoArma(descricaoArma);}

    public int getPrecoCobreArma() {return precoCobreArma;}
    public void setPrecoCobreArma(int precoCobreArma) {this.precoCobreArma = precoCobreArma;}

    public int getPrecoPrataArma() {return precoPrataArma;}
    public void setPrecoPrataArma(int precoPrataArma) {this.precoPrataArma = precoPrataArma;}

    public int getPrecoElectrumArma() {return precoElectrumArma;}
    public void setPrecoElectrumArma(int precoElectrumArma) {this.precoElectrumArma = precoElectrumArma;}

    public int getPrecoOuroArma() {return precoOuroArma;}
    public void setPrecoOuroArma(int precoOuroArma) {this.precoOuroArma = precoOuroArma;}

    public int getPrecoPlatinaArma() {return precoPlatinaArma;}
    public void setPrecoPlatinaArma(int precoPlatinaArma) {this.precoPlatinaArma = precoPlatinaArma;}

    public int getMultiplicadorDadoArma() {return multiplicadorDadoArma;}
    public void setMultiplicadorDadoArma(int multiplicadorDadoArma) {this.multiplicadorDadoArma = multiplicadorDadoArma;}

    public int getDadoArma() {return dadoArma;}
    public void setDadoArma(int dadoArma) {this.dadoArma = dadoArma;}

    public int getIdTipoDano() {return idTipoDano;}
    public void setIdTipoDano(int idTipoDano) {this.idTipoDano = idTipoDano;}

    public double getPesoArma() {return pesoArma;}
    public void setPesoArma(double pesoArma) {verificarValorPesoArma(pesoArma);}

    public int getQuantPropriedadesArma() {return quantPropriedadesArma;}
    public void setQuantPropriedadesArma(int quantPropriedadesArma) {this.quantPropriedadesArma = quantPropriedadesArma;}
}
