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
public class AtributoVO extends ObjetoVO
{
//    Atributo (
//    idAtributo INT NOT NULL,
//    
//    nomeAtributo VARCHAR(50) NOT NULL UNIQUE,
//    descricaoAtributo VARCHAR(400) NOT NULL,
//    
//    dataCriacaoAtributo DATE NOT NULL,
//    atributoAtivo TINYINT(1) NOT NULL DEFAULT 1
//    )
    private static final String NOME_TABELA = "atributo";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idAtributo",
        "nomeAtributo",
        "descricaoAtributo",
        "dataCriacaoAtributo",
        "atributoAtivo"
    };
    private final int LIMITE_NOME_ATRIBUTO = 50;
    private final int LIMITE_DESCRICAO_ATRIBUTO = 400;
    
    private String nomeAtributo;
    private String descricaoAtributo;

    public AtributoVO() {
        this.nomeAtributo = null;
        this.descricaoAtributo = null;
    }
    public AtributoVO(String nomeAtributo, String descricaoAtributo, int id, Date dataCriacao) {
        super(id, dataCriacao);
        this.nomeAtributo = nomeAtributo;
        this.descricaoAtributo = descricaoAtributo;
    }
    public AtributoVO(String nomeAtributo, String descricaoAtributo, int id, int diaCriacao, int mesCriacao, int anoCriacao) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.nomeAtributo = nomeAtributo;
        this.descricaoAtributo = descricaoAtributo;
    }

    public static String getNomeTabela() {
        return NOME_TABELA;
    }

    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }
    
    private void verificarNomeAtributo(String nomeAtributo) {
        if(nomeAtributo.length() > LIMITE_NOME_ATRIBUTO)
            this.nomeAtributo = nomeAtributo.substring(0, LIMITE_NOME_ATRIBUTO);
        else
            this.nomeAtributo = nomeAtributo;
    }
    private void verificarDescricaoAtributo(String descricaoAtributo) {
        if(descricaoAtributo.length() > LIMITE_DESCRICAO_ATRIBUTO)
            this.descricaoAtributo = descricaoAtributo.substring(0, LIMITE_DESCRICAO_ATRIBUTO);
        else
            this.descricaoAtributo = descricaoAtributo;
    }

    public String getNomeAtributo() {
        return nomeAtributo;
    }
    public void setNomeAtributo(String nomeAtributo) {
        verificarNomeAtributo(nomeAtributo);
    }

    public String getDescricaoAtributo() {
        return descricaoAtributo;
    }
    public void setDescricaoAtributo(String descricaoAtributo) {
        verificarDescricaoAtributo(descricaoAtributo);
    }
}
