/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class PersonagemVO extends ObjetoVO
{
    private static final String NOME_TABELA = "Personagem";
    /*
        Tabela Personagem (
            idPersonagem INT NOT NULL,
            idUsuario INT NOT NULL,
            idImagemPersonagem INT NOT NULL,
            idClasse INT NOT NULL,
            idSubclasse INT NOT NULL,
            idRaca INT NOT NULL,
            idSubraca INT NOT NULL,
            idBackground INT NOT NULL,
            nomePersonagem VARCHAR(50) NULL,
            dataCriacaoPersonagem DATE NOT NULL,
            personagemAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String[] NOMES_COLUNAS = new String[]{
        "idPersonagem",
        "idUsuario",
        "idImagemPersonagem",
        "idClasse",
        "idSubclasse",
        "idRaca",
        "idSubraca",
        "idBackground",
        "nomePersonagem",
        "dataCriacaoPersonagem",
        "personagemAtivo"
    };
    private static final int LIMITE_NOME_PERSONAGEM = 50;
    
    private int idUsuario;
    private int idImagemPersonagem;
    private int idClasse;
    private int idSubclasse;
    private int idRaca;
    private int idSubraca;
    private int idBackground;
    private String nomePersonagem;

    public PersonagemVO() {
        this.idUsuario = 0;
        this.idImagemPersonagem = 0;
        this.idClasse = 0;
        this.idSubclasse = 0;
        this.idRaca = 0;
        this.idSubraca = 0;
        this.idBackground = 0;
        this.nomePersonagem = null;
    }
    public PersonagemVO(int id, Date dataCriacao, int idUsuario, int idImagemPersonagem, int idClasse, int idSubclasse, int idRaca, int idSubraca, int idBackground, String nomePersonagem) {
        super(id, dataCriacao);
        this.idUsuario = idUsuario;
        this.idImagemPersonagem = idImagemPersonagem;
        this.idClasse = idClasse;
        this.idSubclasse = idSubclasse;
        this.idRaca = idRaca;
        this.idSubraca = idSubraca;
        this.idBackground = idBackground;
        formatarNomePersonagem(nomePersonagem);
    }
    public PersonagemVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, int idUsuario, int idImagemPersonagem, int idClasse, int idSubclasse, int idRaca, int idSubraca, int idBackground, String nomePersonagem) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.idUsuario = idUsuario;
        this.idImagemPersonagem = idImagemPersonagem;
        this.idClasse = idClasse;
        this.idSubclasse = idSubclasse;
        this.idRaca = idRaca;
        this.idSubraca = idSubraca;
        this.idBackground = idBackground;
        formatarNomePersonagem(nomePersonagem);
    }

    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}
    public static int getLimiteNomePersonagem() {return LIMITE_NOME_PERSONAGEM;}
    
    private void formatarNomePersonagem(String nomePersonagem) {
        if(nomePersonagem.length() > LIMITE_NOME_PERSONAGEM)
            this.nomePersonagem = nomePersonagem.substring(0, LIMITE_NOME_PERSONAGEM);
        else
            this.nomePersonagem = nomePersonagem;
    }

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getIdImagemPersonagem() {return idImagemPersonagem;}
    public void setIdImagemPersonagem(int idImagemPersonagem) {this.idImagemPersonagem = idImagemPersonagem;}

    public int getIdClasse() {return idClasse;}
    public void setIdClasse(int idClasse) {this.idClasse = idClasse;}

    public int getIdSubclasse() {return idSubclasse;}
    public void setIdSubclasse(int idSubclasse) {this.idSubclasse = idSubclasse;}

    public int getIdRaca() {return idRaca;}
    public void setIdRaca(int idRaca) {this.idRaca = idRaca;}

    public int getIdSubraca() {return idSubraca;}
    public void setIdSubraca(int idSubraca) {this.idSubraca = idSubraca;}

    public int getIdBackground() {return idBackground;}
    public void setIdBackground(int idBackground) {this.idBackground = idBackground;}

    public String getNomePersonagem() {return nomePersonagem;}
    public void setNomePersonagem(String nomePersonagem) {formatarNomePersonagem(nomePersonagem);}
}