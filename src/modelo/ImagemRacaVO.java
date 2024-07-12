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
public class ImagemRacaVO extends ImagemVO
{
    /*
    ImagemRaca (
        idImagemRaca INT NOT NULL,

        caminhoImagemRaca VARCHAR(260) NOT NULL,
        descricaoImagemRaca VARCHAR(500) NULL,

        dataCriacaoImagemRaca DATE NOT NULL,
        imagemRacaAtiva TINYINT(1) NOT NULL DEFAULT 1
    );
    */
    private static final String NOME_TABELA = "ImagemRaca";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idImagemRaca",
        "caminhoImagemRaca",
        "descricaoImagemRaca",
        "dataCriacaoImagemRaca",
        "imagemRacaAtiva"
    };

    public ImagemRacaVO() {
    }
    public ImagemRacaVO(int id, Date dataCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, dataCriacao, caminhoImagem, descricaoImagem);
    }
    public ImagemRacaVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, diaCriacao, mesCriacao, anoCriacao, caminhoImagem, descricaoImagem);
    }

    public static String getNomeTabela() {
        return NOME_TABELA;
    }
    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }
}
