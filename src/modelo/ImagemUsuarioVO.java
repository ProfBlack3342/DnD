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
public class ImagemUsuarioVO extends ObjetoVO
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
    private static final int LIMITE_CAMINHO_IMAGEM_USUARIO = 260;
    private static final int LIMITE_DESCRICAO_IMAGEM_USUARIO = 400;
    
    private String caminhoImagemUsuario;
    private String descricaoImagemUsuario;

    public ImagemUsuarioVO()
    {
        this.caminhoImagemUsuario = null;
        this.descricaoImagemUsuario = null;
    }
    public ImagemUsuarioVO(String caminhoImagemUsuario, String descricaoImagemUsuario, int id, Date dataCriacao)
    {
        super(id, dataCriacao);
        formatarCaminhoImagemUsuario(caminhoImagemUsuario);
        formatarDescricaoImagemUsuario(descricaoImagemUsuario);
    }
    public ImagemUsuarioVO(String caminhoImagemUsuario, String descricaoImagemUsuario, int id, int diaCriacao, int mesCriacao, int anoCriacao)
    {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        formatarCaminhoImagemUsuario(caminhoImagemUsuario);
        formatarDescricaoImagemUsuario(descricaoImagemUsuario);
    }
    
    private void formatarCaminhoImagemUsuario(String caminhoImagemUsuario) {
        if(caminhoImagemUsuario.length() > LIMITE_CAMINHO_IMAGEM_USUARIO)
            this.caminhoImagemUsuario = caminhoImagemUsuario.substring(0, LIMITE_CAMINHO_IMAGEM_USUARIO);
        else
            this.caminhoImagemUsuario = caminhoImagemUsuario;
    }
    private void formatarDescricaoImagemUsuario(String descricaoImagemUsuario) {
        if(descricaoImagemUsuario.length() > LIMITE_DESCRICAO_IMAGEM_USUARIO)
            this.descricaoImagemUsuario = descricaoImagemUsuario.substring(0, LIMITE_DESCRICAO_IMAGEM_USUARIO);
        else
            this.descricaoImagemUsuario = descricaoImagemUsuario;
    }

    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}
    public static int getLimiteCaminhoImagemUsuario() {return LIMITE_CAMINHO_IMAGEM_USUARIO;}
    public static int getLimiteDescricaoImagemUsuario() {return LIMITE_DESCRICAO_IMAGEM_USUARIO;}

    public String getCaminhoImagemUsuario() {return caminhoImagemUsuario;}
    public void setCaminhoImagemUsuario(String caminhoImagemUsuario) {formatarCaminhoImagemUsuario(caminhoImagemUsuario);}

    public String getDescricaoImagemUsuario() {return descricaoImagemUsuario;}
    public void setDescricaoImagemUsuario(String descricaoImagemUsuario){formatarDescricaoImagemUsuario(descricaoImagemUsuario);}
}
