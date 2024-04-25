/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class ClasseVO  extends ObjetoVO
{
    private String nome;
    private String descricao;
    private boolean modificandoHabilidades;
    private int bonusSTR, bonusDEX, bonusCON, bonusINT, bonusWIS, bonusCHA;
    
    private boolean modificandoProficienciasArmadura;
    private int idBonusProficienciasArmadura;
    private boolean modificandoProficienciasLinguagem;
    private int idBonusProficienciasLinguagem;
    private boolean modificandoProficienciasSave;
    private int idBonusProficienciasSave;
    private boolean modificandoProficienciasSkill;
    private int idBonusProficienciasSkill;
    private boolean modificandoProficienciasFerramenta;
    private int idBonusProficienciasFerramenta;
    private boolean modificandoProficienciasArmas;
    private int idBonusProficienciasArmas;
}
