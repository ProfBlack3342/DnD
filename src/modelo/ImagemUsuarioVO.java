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
public class ImagemUsuarioVO extends ImagemVO
{
    private static final String NOME_TABELA = "ImagemUsuario";
    /*
        ImagemUsuario (
            idImagemUsuario INT NOT NULL,
            caminhoImagemUsuario VARCHAR(260) NOT NULL,
            descricaoImagemUsuario VARCHAR(400) NULL,
            dataCriacaoImagemUsuario DATE NOT NULL,
            imagemUsuarioAtiva TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String[] NOMES_COLUNAS = new String[]{
        "idImagemUsuario",
        "caminhoImagemUsuario",
        "descricaoImagemUsuario",
        "dataCriacaoImagemUsuario",
        "imagemUsuarioAtiva"
    };

    public ImagemUsuarioVO() {
        
    }
    public ImagemUsuarioVO(int id, Date dataCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, dataCriacao, caminhoImagem, descricaoImagem);
    }
    public ImagemUsuarioVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, diaCriacao, mesCriacao, anoCriacao, caminhoImagem, descricaoImagem);
    }
    
    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}
}
