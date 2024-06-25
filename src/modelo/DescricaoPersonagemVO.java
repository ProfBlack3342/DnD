/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author 181700271
 */
public class DescricaoPersonagemVO extends ObjetoVO
{
    private static final String NOME_TABELA = "DescricaoPersonagem";
    /*
        Tabela DescricaoPersonagem (
            idDescricaoPersonagem INT NOT NULL,
            idPersonagem INT NOT NULL,
            idUsuario INT NOT NULL,
            
            alinhamento VARCHAR(30) NULL,
            idade INT NULL,
            altura INT NULL,
            peso INT NULL,
            olhos VARCHAR(20) NULL,
            pele VARCHAR(30) NULL,
            cabelo VARCHAR(30) NULL,
            aparencia VARCHAR(400) NULL,
            historia VARCHAR(2000) NULL,
            personalidade VARCHAR(1200) NULL,
            ideais VARCHAR(50) NULL,
            ligacoes VARCHAR(50) NULL,
            defeitos VARCHAR(50) NULL,
            aliados VARCHAR(50) NULL,
            outrasInformacoes VARCHAR(2000) NULL,
            
            dataCriacaoDescricaoPersonagem DATE NOT NULL,
            descricaoPersonagemAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String[] NOMES_COLUNAS = new String[]{
        "idDescricaoPersonagem",
        "idPersonagem",
        "idUsuario",
        
        "alinhamento",
        "idade",
        "altura",
        "peso",
        "olhos",
        "pele",
        "cabelo",
        "aparencia",
        "historia",
        "personalidade",
        "ideais",
        "ligacoes",
        "defeitos",
        "aliados",
        "outrasInformacoes",
        
        "dataCriacaoDescricaoPersonagem",
        "descricaoPersonagemAtivo"
    };
    private static final int LIMITE_ALINHAMENTO = 20;
    private static final int LIMITE_OLHOS = 30;
    private static final int LIMITE_PELE = 30;
    private static final int LIMITE_CABELO = 30;
    private static final int LIMITE_APARENCIA = 400;
    private static final int LIMITE_HISTORIA = 2000;
    private static final int LIMITE_PERSONALIDADE = 1200;
    private static final int LIMITE_IDEAIS = 50;
    private static final int LIMITE_LIGACOES = 50;
    private static final int LIMITE_DEFEITOS = 50;
    private static final int LIMITE_ALIADOS = 50;
    private static final int LIMITE_OUTRAS_INFORMACOES = 2000;
    
    private void formatarAlinhamento(String alinhamento) {
        if(alinhamento.length() > LIMITE_ALINHAMENTO)
            this.alinhamento = alinhamento.substring(0, LIMITE_ALINHAMENTO);
        else
            this.alinhamento = alinhamento;
    }
    private void formatarOlhos(String olhos) {
        if(olhos.length() > LIMITE_OLHOS)
            this.olhos = olhos.substring(0, LIMITE_OLHOS);
        else
            this.olhos = olhos;
    }
    private void formatarPele(String pele) {
        if(pele.length() > LIMITE_OLHOS)
            this.pele = pele.substring(0, LIMITE_PELE);
        else
            this.pele = pele;
    }
    private void formatarCabelo(String cabelo) {
        if(cabelo.length() > LIMITE_OLHOS)
            this.cabelo = cabelo.substring(0, LIMITE_CABELO);
        else
            this.cabelo = cabelo;
    }
    private void formatarAparencia(String aparencia) {
        if(aparencia.length() > LIMITE_APARENCIA)
            this.aparencia = aparencia.substring(0, LIMITE_APARENCIA);
        else
            this.aparencia = aparencia;
    }
    private void formatarHistoria(String historia) {
        if(historia.length() > LIMITE_HISTORIA)
            this.historia = historia.substring(0, LIMITE_HISTORIA);
        else
            this.historia = historia;
    }
    private void formatarPersonalidade(String personalidade) {
        if(personalidade.length() > LIMITE_PERSONALIDADE)
            this.personalidade = personalidade.substring(0, LIMITE_PERSONALIDADE);
        else
            this.personalidade = personalidade;
    }
    private void formatarIdeais(String ideais) {
        if(ideais.length() > LIMITE_IDEAIS)
            this.ideais = ideais.substring(0, LIMITE_IDEAIS);
        else
            this.ideais = ideais;
    }
    private void formatarLigacoes(String ligacoes) {
        if(ligacoes.length() > LIMITE_LIGACOES)
            this.ligacoes = ligacoes.substring(0, LIMITE_LIGACOES);
        else
            this.ligacoes = ligacoes;
    }
    private void formatarDefeitos(String defeitos) {
        if(defeitos.length() > LIMITE_DEFEITOS)
            this.defeitos = defeitos.substring(0, LIMITE_DEFEITOS);
        else
            this.defeitos = defeitos;
    }
    private void formatarAliados(String aliados) {
        if(aliados.length() > LIMITE_ALIADOS)
            this.aliados = aliados.substring(0, LIMITE_ALIADOS);
        else
            this.aliados = aliados;
    }
    private void formatarOutrasInformacoes(String outrasInformacoes) {
        if(outrasInformacoes.length() > LIMITE_OUTRAS_INFORMACOES)
            this.outrasInformacoes = outrasInformacoes.substring(0, LIMITE_OUTRAS_INFORMACOES);
        else
            this.outrasInformacoes = outrasInformacoes;
    }

    private int idPersonagem;
    private int idUsuario;
    
    private String alinhamento;
    private int idade;
    private double altura;
    private double peso;
    private String olhos;
    private String pele;
    private String cabelo;
    private String aparencia;
    private String historia;
    private String personalidade;
    private String ideais;
    private String ligacoes;
    private String defeitos;
    private String aliados;
    private String outrasInformacoes;

    public DescricaoPersonagemVO() {
        this.idPersonagem = 0;
        this.idUsuario = 0;
        this.alinhamento = "";
        this.idade = 0;
        this.altura = 0.0;
        this.peso = 0.0;
        this.olhos = "";
        this.pele = "";
        this.cabelo = "";
        this.aparencia = "";
        this.historia = "";
        this.personalidade = "";
        this.ideais = "";
        this.ligacoes = "";
        this.defeitos = "";
        this.aliados = "";
        this.outrasInformacoes = "";
    }
    public DescricaoPersonagemVO(int id, Date dataCriacao, int idPersonagem, int idUsuario, String alinhamento, int idade, double altura, double peso, String olhos, String pele, String cabelo, String aparencia, String historia, String personalidade, String ideais, String ligacoes, String defeitos, String aliados, String outrasInformacoes) {
        super(id, dataCriacao);
        this.idPersonagem = idPersonagem;
        this.idUsuario = idUsuario;
        this.alinhamento = alinhamento;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.olhos = olhos;
        this.pele = pele;
        this.cabelo = cabelo;
        this.aparencia = aparencia;
        this.historia = historia;
        this.personalidade = personalidade;
        this.ideais = ideais;
        this.ligacoes = ligacoes;
        this.defeitos = defeitos;
        this.aliados = aliados;
        this.outrasInformacoes = outrasInformacoes;
    }
    public DescricaoPersonagemVO(int id, int diaCriacao, int mesCriacao, int anoCriacao, int idPersonagem, int idUsuario, String alinhamento, int idade, double altura, double peso, String olhos, String pele, String cabelo, String aparencia, String historia, String personalidade, String ideais, String ligacoes, String defeitos, String aliados, String outrasInformacoes) {
        super(id, diaCriacao, mesCriacao, anoCriacao);
        this.idPersonagem = idPersonagem;
        this.idUsuario = idUsuario;
        this.alinhamento = alinhamento;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.olhos = olhos;
        this.pele = pele;
        this.cabelo = cabelo;
        this.aparencia = aparencia;
        this.historia = historia;
        this.personalidade = personalidade;
        this.ideais = ideais;
        this.ligacoes = ligacoes;
        this.defeitos = defeitos;
        this.aliados = aliados;
        this.outrasInformacoes = outrasInformacoes;
    }
    
    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}

    public static int getLimiteDescricaoBackstory() {return LIMITE_OLHOS;}
    
    public int getIdPersonagem() {return idPersonagem;}
    public void setIdPersonagem(int idPersonagem) {this.idPersonagem = idPersonagem;}

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public String getAlinhamento() {return alinhamento;}
    public void setAlinhamento(String alinhamento) {formatarAlinhamento(alinhamento);}

    public int getIdade() {return idade;}
    public void setIdade(int idade) {this.idade = idade;}

    public double getAltura() {return altura;}
    public void setAltura(double altura) {this.altura = altura;}

    public double getPeso() {return peso;}
    public void setPeso(double peso) {this.peso = peso;}
    
    public String getOlhos() {return olhos;}
    public void setOlhos(String olhos) {formatarOlhos(olhos);}

    public String getPele() {return pele;}
    public void setPele(String pele) {formatarPele(pele);}

    public String getCabelo() {return cabelo;}
    public void setCabelo(String cabelo) {formatarCabelo(cabelo);}

    public String getAparencia() {return aparencia;}
    public void setAparencia(String aparencia) {formatarAparencia(aparencia);}

    public String getHistoria() {return historia;}
    public void setHistoria(String historia) {formatarHistoria(historia);}

    public String getPersonalidade() {return personalidade;}
    public void setPersonalidade(String personalidade) {formatarPersonalidade(personalidade);}

    public String getIdeais() {return ideais;}
    public void setIdeais(String ideais) {formatarIdeais(ideais);}

    public String getLigacoes() {return ligacoes;}
    public void setLigacoes(String ligacoes) {formatarLigacoes(ligacoes);}

    public String getDefeitos() {return defeitos;}
    public void setDefeitos(String defeitos) {formatarDefeitos(defeitos);}

    public String getAliados() {return aliados;}
    public void setAliados(String aliados) {formatarAliados(aliados);}

    public String getOutrasInformacoes() {return outrasInformacoes;}
    public void setOutrasInformacoes(String outrasInformacoes) {formatarOutrasInformacoes(outrasInformacoes);}
}
