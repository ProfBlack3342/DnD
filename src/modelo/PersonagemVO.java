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

            idImagem INT NOT NULL,
            idSubclassePersonagem INT NOT NULL,
            idClassePersonagem INT NOT NULL,
            idSubracaPersonagem INT NOT NULL,
            idRacaPersonagem INT NOT NULL,
            idBackgroundPersonagem INT NOT NULL,

            valorSTRBasePersonagem INT NOT NULL,
            valorDEXBasePersonagem INT NOT NULL,
            valorCONBasePersonagem INT NOT NULL,
            valorINTBasePersonagem INT NOT NULL,
            valorWISBasePersonagem INT NOT NULL,
            valorCHABasePersonagem INT NOT NULL,
            nome VARCHAR(50) NULL,
            alinhamentoPersonagem VARCHAR(30) NULL,
            idadePersonagem INT NULL,
            alturaPersonagem DOUBLE(4, 2) NULL,
            pesoPersonagem DOUBLE(5, 2) NULL,
            olhosPersonagem VARCHAR(20) NULL,
            pelePersonagem VARCHAR(30) NULL,
            cabeloPersonagem VARCHAR(30) NULL,
            aparenciaPersonagem VARCHAR(1000) NULL,
            historiaPersonagem VARCHAR(2000) NULL,
            personalidadePersonagem VARCHAR(1200) NULL,
            ideaisPersonagem VARCHAR(50) NULL,
            ligacoesPersonagem VARCHAR(50) NULL,
            defeitosPersonagem VARCHAR(50) NULL,
            aliadosPersonagem VARCHAR(50) NULL,
            outrasInformacoesPersonagem VARCHAR(2000) NULL,
            quantCobrePersonagem INT NOT NULL,
            quantPrataPersonagem INT NOT NULL,
            quantElectrumPersonagem INT NOT NULL,
            quantOuroPersonagem INT NOT NULL,
            quantPlatinaPersonagem INT NOT NULL,

            dataCriacaoPersonagem DATE NOT NULL,
            personagemAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String[] NOMES_COLUNAS = new String[]{
        "idPersonagem",
        "idUsuario",
        "idImagemPersonagem",
        "idSubclassePersonagem",
        "idClassePersonagem",
        "idSubracaPersonagem",
        "idRacaPersonagem",
        "idBackgroundPersonagem",
        "valorSTRBasePersonagem",
        "valorDEXBasePersonagem",
        "valorCONBasePersonagem",
        "valorINTBasePersonagem",
        "valorWISBasePersonagem",
        "valorCHABasePersonagem",
        "nomePersonagem",
        "alinhamentoPersonagem",
        "idadePersonagem",
        "alturaPersonagem",
        "pesoPersonagem",
        "olhosPersonagem",
        "pelePersonagem",
        "cabeloPersonagem",
        "aparenciaPersonagem",
        "historiaPersonagem",
        "personalidadePersonagem",
        "ideaisPersonagem",
        "ligacoesPersonagem",
        "defeitosPersonagem",
        "aliadosPersonagem",
        "outrasInformacoesPersonagem",
        "quantCobrePersonagem",
        "quantPrataPersonagem",
        "quantElectrumPersonagem",
        "quantOuroPersonagem",
        "quantPlatinaPersonagem",        
        "dataCriacaoPersonagem",
        "personagemAtivo"
    };
    private static final int LIMITE_NOME_PERSONAGEM = 50;
    
    private int idUsuario;
    private int idImagem;
    private int idClasse;
    private int idSubclasse;
    private int idRaca;
    private int idSubraca;
    private int idBackground;
    private int valorSTRBase, valorDEXBase, valorCONBase, valorINTBase, valorWISBase, valorCHABase;
    private String nome;
    private String alinhamento;
    private int idade;
    private int altura;
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
    private int quantCobre, quantPrata, quantElectrum, quantOuro, quantPlatina;

    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}
    public static int getLimiteNomePersonagem() {return LIMITE_NOME_PERSONAGEM;}
    
    private void formatarNome(String nome) {
        if(nome.length() > LIMITE_NOME_PERSONAGEM)
            this.nome = nome.substring(0, LIMITE_NOME_PERSONAGEM);
        else
            this.nome = nome;
    }

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getIdImagem() {return idImagem;}
    public void setIdImagem(int idImagem) {this.idImagem = idImagem;}

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

    public int getValorSTRBase() {
        return valorSTRBase;
    }
    public void setValorSTRBase(int valorSTRBase) {
        this.valorSTRBase = valorSTRBase;
    }

    public int getValorDEXBase() {
        return valorDEXBase;
    }
    public void setValorDEXBase(int valorDEXBase) {
        this.valorDEXBase = valorDEXBase;
    }

    public int getValorCONBase() {
        return valorCONBase;
    }
    public void setValorCONBase(int valorCONBase) {
        this.valorCONBase = valorCONBase;
    }

    public int getValorINTBase() {
        return valorINTBase;
    }
    public void setValorINTBase(int valorINTBase) {
        this.valorINTBase = valorINTBase;
    }

    public int getValorWISBase() {
        return valorWISBase;
    }
    public void setValorWISBase(int valorWISBase) {
        this.valorWISBase = valorWISBase;
    }

    public int getValorCHABase() {
        return valorCHABase;
    }
    public void setValorCHABase(int valorCHABase) {
        this.valorCHABase = valorCHABase;
    }
    
    public String getNome() {return nome;}
    public void setNome(String nome) {formatarNome(nome);}

    public String getAlinhamento() {
        return alinhamento;
    }
    public void setAlinhamento(String alinhamento) {
        this.alinhamento = alinhamento;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getOlhos() {
        return olhos;
    }
    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }

    public String getPele() {
        return pele;
    }
    public void setPele(String pele) {
        this.pele = pele;
    }

    public String getCabelo() {
        return cabelo;
    }
    public void setCabelo(String cabelo) {
        this.cabelo = cabelo;
    }

    public String getAparencia() {
        return aparencia;
    }
    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    public String getHistoria() {
        return historia;
    }
    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getPersonalidade() {
        return personalidade;
    }
    public void setPersonalidade(String personalidade) {
        this.personalidade = personalidade;
    }

    public String getIdeais() {
        return ideais;
    }
    public void setIdeais(String ideais) {
        this.ideais = ideais;
    }

    public String getLigacoes() {
        return ligacoes;
    }
    public void setLigacoes(String ligacoes) {
        this.ligacoes = ligacoes;
    }

    public String getDefeitos() {
        return defeitos;
    }
    public void setDefeitos(String defeitos) {
        this.defeitos = defeitos;
    }

    public String getAliados() {
        return aliados;
    }
    public void setAliados(String aliados) {
        this.aliados = aliados;
    }

    public String getOutrasInformacoes() {
        return outrasInformacoes;
    }
    public void setOutrasInformacoes(String outrasInformacoes) {
        this.outrasInformacoes = outrasInformacoes;
    }

    public int getQuantCobre() {
        return quantCobre;
    }
    public void setQuantCobre(int quantCobre) {
        this.quantCobre = quantCobre;
    }

    public int getQuantPrata() {
        return quantPrata;
    }
    public void setQuantPrata(int quantPrata) {
        this.quantPrata = quantPrata;
    }

    public int getQuantElectrum() {
        return quantElectrum;
    }
    public void setQuantElectrum(int quantElectrum) {
        this.quantElectrum = quantElectrum;
    }

    public int getQuantOuro() {
        return quantOuro;
    }
    public void setQuantOuro(int quantOuro) {
        this.quantOuro = quantOuro;
    }

    public int getQuantPlatina() {
        return quantPlatina;
    }
    public void setQuantPlatina(int quantPlatina) {
        this.quantPlatina = quantPlatina;
    }
}