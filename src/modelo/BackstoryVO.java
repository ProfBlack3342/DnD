/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 181700271
 */
public class BackstoryVO extends ObjetoVO
{
    private static final String NOME_TABELA = "Backstory";
    /*
        Tabela Backstory (
            idPersonagem INT NOT NULL,
            idUsuario INT NOT NULL,
            
            dataCriacaoPersonagem DATE NOT NULL,
            personagemAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String[] NOMES_COLUNAS = new String[]{
        "idPersonagem",
        "idUsuario",
        "descricao",
        
        "dataCriacaoPersonagem",
        "personagemAtivo"
    };
    private static final int LIMITE_DESCRICAO_BACKSTORY = 400;
    
    private void formatarDescricao(String descricao) {
        if(descricao.length() > LIMITE_DESCRICAO_BACKSTORY)
            this.descricao = descricao.substring(0, LIMITE_DESCRICAO_BACKSTORY);
        else
            this.descricao = descricao;
    }
    
    private int idPersonagem;
    private int idUsuario;
    private String descricao;

    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}

    public static int getLimiteDescricaoBackstory() {return LIMITE_DESCRICAO_BACKSTORY;}

    public int getIdPersonagem() {return idPersonagem;}
    public void setIdPersonagem(int idPersonagem) {this.idPersonagem = idPersonagem;}

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        formatarDescricao(descricao);
    }
    
    
}
