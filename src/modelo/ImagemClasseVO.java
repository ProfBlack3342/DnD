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
public class ImagemClasseVO extends ImagemVO
{
    /*
    ImagemClasse (
        idImagemClasse INT NOT NULL,

        caminhoImagemClasse VARCHAR(260) NOT NULL,
        descricaoImagemClasse VARCHAR(500) NULL,

        dataCriacaoImagemClasse DATE NOT NULL,
        imagemClasseAtiva TINYINT(1) NOT NULL DEFAULT 1
    );
    */
    private static final String NOME_TABELA = "ImagemClasse";
    private static final String[] NOMES_COLUNAS = new String[]{
        "idImagemClasse",
        "caminhoImagemClasse",
        "descricaoImagemClasse",
        "dataCriacaoImagemClasse",
        "imagemClasseAtiva"
    };

    public ImagemClasseVO() {
    }
    public ImagemClasseVO(int id, Date dataCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, dataCriacao, caminhoImagem, descricaoImagem);
    }
    public ImagemClasseVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, diaCriacao, mesCriacao, anoCriacao, caminhoImagem, descricaoImagem);
    }

    public static String getNomeTabela() {
        return NOME_TABELA;
    }
    public static String[] getNomesColunas() {
        return NOMES_COLUNAS;
    }
    
    
}
