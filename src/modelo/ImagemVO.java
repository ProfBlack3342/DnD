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
public class ImagemVO extends ObjetoVO
{
    private static final int LIMITE_CAMINHO_IMAGEM = 260;
    private static final int LIMITE_DESCRICAO_IMAGEM = 400;
    
    private String caminhoImagem;
    private String descricaoImagem;

    public ImagemVO() {
        this.caminhoImagem = null;
        this.descricaoImagem = null;
    }
    public ImagemVO(int id, Date dataCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, dataCriacao);
        formatarCaminhoImagem(caminhoImagem);
        formatarDescricaoImagem(descricaoImagem);
    }
    public ImagemVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, String caminhoImagem, String descricaoImagem) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        formatarCaminhoImagem(caminhoImagem);
        formatarDescricaoImagem(descricaoImagem);
    }
    
    public static int getLimiteCaminhoImagem() {return LIMITE_CAMINHO_IMAGEM;}
    public static int getLimiteDescricaoImagem() {return LIMITE_DESCRICAO_IMAGEM;}
    
    private void formatarCaminhoImagem(String caminhoImagem) {
        if(caminhoImagem.length() > LIMITE_CAMINHO_IMAGEM)
            this.caminhoImagem = caminhoImagem.substring(0, LIMITE_CAMINHO_IMAGEM);
        else
            this.caminhoImagem = caminhoImagem;
    }
    private void formatarDescricaoImagem(String descricaoImagem) {
        if(descricaoImagem.length() > LIMITE_DESCRICAO_IMAGEM)
            this.descricaoImagem = descricaoImagem.substring(0, LIMITE_DESCRICAO_IMAGEM);
        else
            this.descricaoImagem = descricaoImagem;
    }

    public String getCaminhoImagem() {return caminhoImagem;}
    public void setCaminhoImagem(String caminhoImagem) {formatarCaminhoImagem(caminhoImagem);}

    public String getDescricaoImagem() {return descricaoImagem;}
    public void setDescricaoImagem(String descricaoImagem) {formatarDescricaoImagem(descricaoImagem);}
}
