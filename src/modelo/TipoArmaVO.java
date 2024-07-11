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
public class TipoArmaVO extends ObjetoVO
{
//    TipoArma (
//    idTipoArma INT NOT NULL,
//    
//    nomeTipoArma VARCHAR(50) NOT NULL UNIQUE,
//    descricaoTipoArma VARCHAR(400) NULL,
//    
//    dataCriacaoTipoArma DATE NOT NULL,
//    tipoArmaAtivo TINYINT(1) NOT NULL DEFAULT 1
//    )
    private static final String NOME_TABELA = "tipoarma";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idTipoArma",
        "nomeTipoArma",
        "descricaoTipoArma",
        "dataCriacaoTipoArma",
        "tipoArmaAtivo"
    };
    private final int LIMITE_NOME_TIPO_ARMA = 50;
    private final int LIMITE_DESCRICAO_TIPO_ARMA = 400;
    
    private String nomeTipoArma;
    private String descricaoTipoArma;

    public TipoArmaVO() {
        this.nomeTipoArma = null;
        this.descricaoTipoArma = null;
    }
    public TipoArmaVO(String nomeTipoArma, String descricaoTipoArma, int id, Date dataCriacao) {
        super(id, dataCriacao);
        this.nomeTipoArma = nomeTipoArma;
        this.descricaoTipoArma = descricaoTipoArma;
    }
    public TipoArmaVO(String nomeTipoArma, String descricaoTipoArma, int id, int diaCriacao, int mesCriacao, int anoCriacao) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.nomeTipoArma = nomeTipoArma;
        this.descricaoTipoArma = descricaoTipoArma;
    }
    
    
}
