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
public class ImagemPersonagemVO extends ImagemVO
{
    /*
    ImagemPersonagem (
        idImagemPersonagem INT NOT NULL,

        caminhoImagemPersonagem VARCHAR(260) NOT NULL,
        descricaoImagemPersonagem VARCHAR(500) NULL,

        dataCriacaoImagemPersonagem DATE NOT NULL,
        imagemPersonagemAtiva TINYINT(1) NOT NULL DEFAULT 1
    );
    */
    private static final String NOME_TABELA = "ImagemPersonagem";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idImagemPersonagem",
        "caminhoImagemPersonagem",
        "descricaoImagemPersonagem",
        "dataCriacaoImagemPersonagem",
        "imagemPersonagemAtiva"
    };

    public ImagemPersonagemVO() {
    }
    public ImagemPersonagemVO(int id, Date dataCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, dataCriacao, caminhoImagem, descricaoImagem);
    }
    public ImagemPersonagemVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, diaCriacao, mesCriacao, anoCriacao, caminhoImagem, descricaoImagem);
    }

    public static String getNomeTabela() {
        return NOME_TABELA;
    }
    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }
    
    
}
