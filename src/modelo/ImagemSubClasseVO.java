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
public class ImagemSubClasseVO extends ImagemVO
{
    /*
    ImagemSubClasse (
        idImagemSubClasse INT NOT NULL,

        caminhoImagemSubClasse VARCHAR(260) NOT NULL,
        descricaoImagemSubClasse VARCHAR(500) NULL,

        dataCriacaoImagemSubClasse DATE NOT NULL,
        imagemSubClasseAtiva TINYINT(1) NOT NULL DEFAULT 1
    );
    */
    private static final String NOME_TABELA = "ImagemSubClasse";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idImagemSubClasse",
        "caminhoImagemSubClasse",
        "descricaoImagemSubClasse",
        "dataCriacaoImagemSubClasse",
        "imagemSubClasseAtiva"
    };

    public ImagemSubClasseVO() {
    }
    public ImagemSubClasseVO(int id, Date dataCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, dataCriacao, caminhoImagem, descricaoImagem);
    }
    public ImagemSubClasseVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, diaCriacao, mesCriacao, anoCriacao, caminhoImagem, descricaoImagem);
    }

    public static String getNomeTabela() {
        return NOME_TABELA;
    }
    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }
}
