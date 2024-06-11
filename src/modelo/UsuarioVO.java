/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;
import utilidades.Converter;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class UsuarioVO extends ObjetoVO
{
    private static final String NOME_TABELA = "Usuario";
    /*
        Usuario (
            idUsuario INT NOT NULL,
            idImagemUsuario INT NULL,
            idTipoUsuario INT NOT NULL,
            nomeUsuario VARCHAR(50) NOT NULL UNIQUE,
            senhaUsuario CHAR(60) NOT NULL,
            emailUsuario VARCHAR(70) NOT NULL,
            dataAniversarioUsuario DATE NOT NULL,
            descricaoUsuario VARCHAR(400) NULL,
            quantPersonagensTotal INT NOT NULL DEFAULT 6,
            quantPersonagensCriados INT NOT NULL DEFAULT 0,
            dataCriacaoUsuario DATE NOT NULL,
            usuarioAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String[] NOMES_COLUNAS = new String[]{
        "idUsuario",
        "idImagemUsuario",
        "idTipoUsuario",
        "nomeUsuario",
        "senhaUsuario",
        "emailUsuario",
        "dataAniversarioUsuario",
        "descricaoUsuario",
        "quantPersonagensTotal",
        "quantPersonagensCriados",
        "dataCriacaoUsuario",
        "usuarioAtivo"
    };
    private static final int LIMITE_NOME_USUARIO = 50;
    private static final int TAMANHO_HASH_SENHA_USUARIO = 60; //Hash sempre vai ter tamanho 60, NÃO ALTERAR SEM ALTERAR O SISTEMA DE HASH DA SENHA ANTES
    private static final int LIMITE_EMAIL_USUARIO = 70;
    private static final int LIMITE_DESCRICAO_USUARIO = 400;
    
    private int idImagem;
    private int idTipo;
    private String nomeUsuario;
    private String senhaUsuario;
    private String emailUsuario;
    private int diaAniversarioUsuario;
    private int mesAniversarioUsuario;
    private int anoAniversarioUsuario;
    private Date dataAniversarioUsuario;
    private String descricaoUsuario;
    private int quantPersonagensTotal = 6;
    private int quantPersonagensCriados = 0;
    private PersonagemVO[] listaPersonagens = new PersonagemVO[quantPersonagensTotal];

    public UsuarioVO()
    {
        this.idImagem = 0;
        this.idTipo = 0;
        this.nomeUsuario = null;
        this.senhaUsuario = null;
        this.emailUsuario = null;
        this.diaAniversarioUsuario = 0;
        this.mesAniversarioUsuario = 0;
        this.anoAniversarioUsuario = 0;
        this.dataAniversarioUsuario = null;
        this.descricaoUsuario = null;
    }
    public UsuarioVO(int id, Date dataCriacao, int idImagem, int idTipo, String nomeUsuario, String senhaUsuario, String emailUsuario, Date dataAniversarioUsuario, String descricaoUsuario)
    {
        super(id, dataCriacao);
        this.idImagem = idImagem;
        this.idTipo = idTipo;
        formatarNomeUsuario(nomeUsuario);
        this.senhaUsuario = senhaUsuario;
        formatarEmailUsuario(emailUsuario);
        formatarDescricaoUsuario(descricaoUsuario);
        setDiaMesAnoAniversario(this.dataAniversarioUsuario);
        this.descricaoUsuario = descricaoUsuario;
    }
    public UsuarioVO(int id, Date dataCriacao, int idImagem, int idTipo, String nomeUsuario, String senhaUsuario, String emailUsuario, int diaAniversarioUsuario, int mesAniversarioUsuario, int anoAniversarioUsuario, String descricaoUsuario)
    {
        super(id, dataCriacao);
        this.idImagem = idImagem;
        this.idTipo = idTipo;
        formatarNomeUsuario(nomeUsuario);
        this.senhaUsuario = senhaUsuario;
        formatarEmailUsuario(emailUsuario);
        this.diaAniversarioUsuario = diaAniversarioUsuario;
        this.mesAniversarioUsuario = mesAniversarioUsuario;
        this.anoAniversarioUsuario = anoAniversarioUsuario;
        setDataAniversario(this.diaAniversarioUsuario, this.mesAniversarioUsuario, this.anoAniversarioUsuario);
        formatarDescricaoUsuario(descricaoUsuario);
    }
    public UsuarioVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, int idImagem, int idTipo, String nomeUsuario, String senhaUsuario, String emailUsuario, Date dataAniversarioUsuario, String descricaoUsuario)
    {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.idImagem = idImagem;
        this.idTipo = idTipo;
        formatarNomeUsuario(nomeUsuario);
        this.senhaUsuario = senhaUsuario;
        formatarEmailUsuario(emailUsuario);
        this.dataAniversarioUsuario = dataAniversarioUsuario;
        setDiaMesAnoAniversario(this.dataAniversarioUsuario);
        formatarDescricaoUsuario(descricaoUsuario);
    }
    public UsuarioVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, int idImagem, int idTipo, String nomeUsuario, String senhaUsuario, String emailUsuario, int diaAniversarioUsuario, int mesAniversarioUsuario, int anoAniversarioUsuario, String descricaoUsuario)
    {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.idImagem = idImagem;
        this.idTipo = idTipo;
        formatarNomeUsuario(nomeUsuario);
        this.senhaUsuario = senhaUsuario;
        formatarEmailUsuario(emailUsuario);
        this.diaAniversarioUsuario = diaAniversarioUsuario;
        this.mesAniversarioUsuario = mesAniversarioUsuario;
        this.anoAniversarioUsuario = anoAniversarioUsuario;
        setDataAniversario(this.diaAniversarioUsuario, this.mesAniversarioUsuario, this.anoAniversarioUsuario);
        formatarDescricaoUsuario(descricaoUsuario);
    }
    
    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}
    public static int getLimiteNomeUsuario() {return LIMITE_NOME_USUARIO;}
    public static int getTamanhoSenhaUsuario() {return TAMANHO_HASH_SENHA_USUARIO;}
    public static int getLimiteEmailUsuario() {return LIMITE_EMAIL_USUARIO;}
    public static int getLimiteDescricaoUsuario() {return LIMITE_DESCRICAO_USUARIO;}

    private void formatarNomeUsuario(String nomeUsuario) {
        if(nomeUsuario.length() > LIMITE_NOME_USUARIO)
            this.nomeUsuario = nomeUsuario.substring(0, LIMITE_NOME_USUARIO);
        else
            this.nomeUsuario = nomeUsuario;
    }
    private void formatarEmailUsuario(String emailUsuario) {
        if(emailUsuario.length() > LIMITE_EMAIL_USUARIO)
            this.emailUsuario = emailUsuario.substring(0, LIMITE_EMAIL_USUARIO);
        else
            this.emailUsuario = emailUsuario;
    }
    private void formatarDescricaoUsuario(String descricaoUsuario) {
        if(descricaoUsuario.length() > LIMITE_DESCRICAO_USUARIO)
            this.descricaoUsuario = descricaoUsuario.substring(0, LIMITE_DESCRICAO_USUARIO);
        else
            this.descricaoUsuario = descricaoUsuario;
    }
    
    private void setDataAniversario(int dia, int mes, int ano) {
        dataAniversarioUsuario = Converter.converterDiaMesAnoParaSQLDate(
                Integer.toString(dia),
                Integer.toString(mes),
                Integer.toString(ano)
        );
    }
    private void setDiaMesAnoAniversario(Date dataAniversario) {
        String[] diaMesAno = Converter.converterSQLDateParaDiaMesAno(dataAniversario);
        diaAniversarioUsuario = Integer.parseInt(diaMesAno[0]);
        mesAniversarioUsuario = Integer.parseInt(diaMesAno[1]);
        anoAniversarioUsuario = Integer.parseInt(diaMesAno[2]);
    }

    public int getIdImagem() {return idImagem;}
    public void setIdImagem(int imagem) {this.idImagem = imagem;}

    public int getIdTipo() {return idTipo;}
    public void setIdTipo(int idTipo) {this.idTipo = idTipo;}

    public String getNomeUsuario() {return nomeUsuario;}
    public void setNomeUsuario(String nomeUsuario) {formatarNomeUsuario(nomeUsuario);}

    public String getSenhaUsuario() {return senhaUsuario;}
    public void setSenhaUsuario(String senhaUsuario) {this.senhaUsuario = senhaUsuario;}

    public String getEmailUsuario() {return emailUsuario;}
    public void setEmailUsuario(String emailUsuario) {formatarEmailUsuario(emailUsuario);}

    public int getDiaAniversarioUsuario() {return diaAniversarioUsuario;}
    public void setDiaAniversarioUsuario(int diaAniversarioUsuario)
    {
        this.diaAniversarioUsuario = diaAniversarioUsuario;
        if(mesAniversarioUsuario > 0 && anoAniversarioUsuario > 0)
            setDataAniversario(this.diaAniversarioUsuario, mesAniversarioUsuario, anoAniversarioUsuario);
    }

    public int getMesAniversarioUsuario() {return mesAniversarioUsuario;}
    public void setMesAniversarioUsuario(int mesAniversarioUsuario)
    {
        this.mesAniversarioUsuario = mesAniversarioUsuario;
        if(diaAniversarioUsuario > 0 && anoAniversarioUsuario > 0)
            setDataAniversario(diaAniversarioUsuario, this.mesAniversarioUsuario, anoAniversarioUsuario);
    }

    public int getAnoAniversarioUsuario() {return anoAniversarioUsuario;}
    public void setAnoAniversarioUsuario(int anoAniversarioUsuario)
    {
        this.anoAniversarioUsuario = anoAniversarioUsuario;
        if(diaAniversarioUsuario > 0 && mesAniversarioUsuario > 0)
            setDataAniversario(diaAniversarioUsuario, mesAniversarioUsuario, this.anoAniversarioUsuario);
    }

    public Date getDataAniversarioUsuario() {return dataAniversarioUsuario;}
    public void setDataAniversarioUsuario(Date dataAniversarioUsuario)
    {
        this.dataAniversarioUsuario = dataAniversarioUsuario;
        if(this.dataAniversarioUsuario != null)
            setDiaMesAnoAniversario(this.dataAniversarioUsuario);
        else
        {
            diaAniversarioUsuario = 0;
            mesAniversarioUsuario = 0;
            anoAniversarioUsuario = 0;
        }
    }

    public String getDescricaoUsuario() {return descricaoUsuario;}
    public void setDescricaoUsuario(String descricaoUsuario) {formatarDescricaoUsuario(descricaoUsuario);}

    public int getQuantPersonagensTotal() {return quantPersonagensTotal;}
    public void setQuantPersonagensTotal(int quantPersonagensTotal) {this.quantPersonagensTotal = quantPersonagensTotal;}

    public int getQuantPersonagensCriados() {return quantPersonagensCriados;}
    public void setQuantPersonagensCriados(int quantPersonagensCriados) {this.quantPersonagensCriados = quantPersonagensCriados;}

    public PersonagemVO[] getListaPersonagens() {return listaPersonagens;}
    public void setListaPersonagens(PersonagemVO[] listaPersonagens) {this.listaPersonagens = listaPersonagens;}
}
