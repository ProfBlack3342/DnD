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
public class PropriedadeArmaVO extends ObjetoVO
{
//    PropriedadeArma (
//    idPropriedadeArma INT NOT NULL,
//    
//    nomePropriedadeArma VARCHAR(50) NOT NULL,
//    descricaoPropriedadeArma VARCHAR(400) NOT NULL,
//    
//    dataCriacaoPropriedadeArma DATE NOT NULL,
//    propriedadeArmaAtiva TINYINT(1) NOT NULL DEFAULT 1
//    )
    private static final String NOME_TABELA = "propriedadearma";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idPropriedadeArma",
        "nomePropriedadeArma",
        "descricaoPropriedadeArma",
        "dataCriacaoPropriedadeArma",
        "propriedadeArmaAtiva"
    };
    private final int LIMITE_NOME_PROPRIEDADES_ARMA = 50;
    private final int LIMITE_DESCRICAO_PROPRIEDADES_ARMA = 400;

    private String nomePropriedadeArma;
    private String descricaoPropriedadeArma;

    public PropriedadeArmaVO() {
        this.nomePropriedadeArma = null;
        this.descricaoPropriedadeArma = null;
    }
    public PropriedadeArmaVO(String nomePropriedadeArma, String descricaoPropriedadeArma, int id, Date dataCriacao) {
        super(id, dataCriacao);
        this.nomePropriedadeArma = nomePropriedadeArma;
        this.descricaoPropriedadeArma = descricaoPropriedadeArma;
    }
    public PropriedadeArmaVO(String nomePropriedadeArma, String descricaoPropriedadeArma, int id, int diaCriacao, int mesCriacao, int anoCriacao) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.nomePropriedadeArma = nomePropriedadeArma;
        this.descricaoPropriedadeArma = descricaoPropriedadeArma;
    }

    public static String getNomeTabela() {
        return NOME_TABELA;
    }
    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }
    
    private void verificarTamanhoNomePropriedadeArma(String nomePropriedadeArma){
        if(nomePropriedadeArma.length() > LIMITE_NOME_PROPRIEDADES_ARMA)
            this.nomePropriedadeArma = nomePropriedadeArma.substring(0, LIMITE_NOME_PROPRIEDADES_ARMA);
        else
            this.nomePropriedadeArma = nomePropriedadeArma;
    }
    private void verificarTamanhoDescricaoPropriedadeArma(String descricaoPropriedadeArma){
        if(descricaoPropriedadeArma.length() > LIMITE_DESCRICAO_PROPRIEDADES_ARMA)
            this.descricaoPropriedadeArma = descricaoPropriedadeArma.substring(0, LIMITE_DESCRICAO_PROPRIEDADES_ARMA);
        else
            this.descricaoPropriedadeArma = descricaoPropriedadeArma;
    }

    public String getNomePropriedadeArma() {
        return nomePropriedadeArma;
    }
    public void setNomePropriedadeArma(String nomePropriedadeArma) {
        verificarTamanhoNomePropriedadeArma(nomePropriedadeArma);
    }

    public String getDescricaoPropriedadeArma() {
        return descricaoPropriedadeArma;
    }
    public void setDescricaoPropriedadeArma(String descricaoPropriedadeArma) {
        verificarTamanhoDescricaoPropriedadeArma(descricaoPropriedadeArma);
    }
}
