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
}
