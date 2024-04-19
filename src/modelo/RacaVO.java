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
public final class RacaVO extends ObjetoVO
{
    private String nome;
    private String descricao;
    private int[] aumentosScoresHabilidade = new int[6];
    private FeatureRacaVO[] features;
    private int idadeMaxima;
    private double alturaMinima;
    private double alturaMaxima;
    private double pesoMinimo;
    private double pesoMaximo;
    private int velocidade;
    private LinguagemVO[] linguagensIniciais;
    private SubRacaVO subRaca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int[] getAumentosScoresHabilidade() {
        return aumentosScoresHabilidade;
    }

    public void setAumentosScoresHabilidade(int[] aumentosScoresHabilidade) {
        this.aumentosScoresHabilidade = aumentosScoresHabilidade;
    }

    public FeatureRacaVO[] getFeatures() {
        return features;
    }

    public void setFeatures(FeatureRacaVO[] features) {
        this.features = features;
    }

    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    public double getAlturaMinima() {
        return alturaMinima;
    }

    public void setAlturaMinima(double alturaMinima) {
        this.alturaMinima = alturaMinima;
    }

    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(double alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public double getPesoMinimo() {
        return pesoMinimo;
    }

    public void setPesoMinimo(double pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public LinguagemVO[] getLinguagensIniciais() {
        return linguagensIniciais;
    }

    public void setLinguagensIniciais(LinguagemVO[] linguagensIniciais) {
        this.linguagensIniciais = linguagensIniciais;
    }

    public SubRacaVO getSubRaca() {
        return subRaca;
    }

    public void setSubRaca(SubRacaVO subRaca) {
        this.subRaca = subRaca;
    }
    
    
}
