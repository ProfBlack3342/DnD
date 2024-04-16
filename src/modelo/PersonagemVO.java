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
public final class PersonagemVO extends ObjetoVO
{
    private int idImagem;
    private int idUsuario;
    private RacaVO raca;
    private ClasseVO classe;
    private int nivel;
    private int idBackground;
    
    // Strength, Dexterity, Constitution, Intelligence, Wisdom, e Charisma.
    private int[] scoresHabilidade = new int[]{ 10, 10, 10, 10, 10, 10 };
    /**
     *      Ability Scores and Modifiers:
     *  -----------------------------------------
     *  |	Score	   |	  Modifier	|
     *  -----------------------------------------
     *  | 	1	   |	    −5		|
     *  |	2–3	   |	    −4		|
     *  |	4–5	   |	    −3		|
     *  |	6–7	   |	    −2		|
     *  |	8–9	   |	    −1		|
     *  |	10–11	   |	    +0		|
     *  |	12–13	   |	    +1		|
     *  |	14–15	   |	    +2		|
     *  |	16–17	   |	    +3		|
     *  |	18–19	   |	    +4		|
     *  |	20–21	   |	    +5		|
     *  |	22–23	   |	    +6		|
     *  |	24–25	   |	    +7		|
     *  |	26–27	   |	    +8		|
     *  |	28–29	   |	    +9		|
     *  |	30	   |	    +10		|
     *  -----------------------------------------
     */
    private int[] modificadoresHabilidade = new int[]{ 0, 0, 0, 0, 0, 0 };  
    
    private int hpAtual;
    private int hpMaximo;
    private int hpTemp;
    private SkillVO[] skills;
    private ProficienciaVO[] proficiencias;
    private EquipamentoVO[] equipamento;
    private int armorClass;
    private LinguagemVO[] linguagens;
    private int iniciativa;
    private boolean[] deathSaves;
    private boolean inspiracao;
    private DescricaoPersonagemVO descricaoPersonagem;
    private String jornalDeCampo;
    private String notasExtras;
}
