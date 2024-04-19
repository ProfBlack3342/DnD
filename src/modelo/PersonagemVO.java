/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.cj.exceptions.WrongArgumentException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 181700271
 */
public final class PersonagemVO extends ObjetoVO
{
    private int idUsuario;
    private int idImagem;
    private String nome;
    private RacaVO raca;
    private SubRacaVO subRaca;
    private ClasseVO classe;
    private SubClasseVO subClasse;
    private int nivel;
    private BackgroundPersonagemVO background;
    private int[] scoresHabilidadeIniciais; // Strength, Dexterity, Constitution, Intelligence, Wisdom, e Charisma.
    private int[] scoresHabilidadeFinais;
    private int[] modificadoresHabilidade;  //Sempre usar calcularModificadores(scoresHabilidade) para alterar esse Array
    private int[] hpMaximo;
    private int hpAtual;
    private int hpTemp;
    private ArrayList<SkillVO> skills;
    private ArrayList<EquipamentoVO> equipamentos;
    private int armorClass;
    private ArrayList<LinguagemVO> linguagens;
    private int iniciativa;
    private boolean[] deathSaves;
    private boolean inspiracao;
    private DescricaoPersonagemVO descricaoPersonagem;
    private String jornalDeCampo;
    private String notasExtras;

    public PersonagemVO()
    {
        this.idUsuario = -1;
        this.idImagem = 1;
        this.nome = "Sem Nome";
        this.raca = null;
        this.subRaca = null;
        this.classe = null;
        this.subClasse = null;
        this.nivel = 1;
        this.background = new BackgroundPersonagemVO();
        this.skills = new ArrayList<>();
        this.equipamentos = new ArrayList<>();
        this.linguagens = new ArrayList<>();
    }
    public PersonagemVO(RacaVO racaPersonagem, SubRacaVO subRacaPersonagem, ClasseVO classePersonagem, SubClasseVO subClassePersonagem, int nivel, int[] scoresHabilidade)
    {
        this.raca = racaPersonagem;
        this.subRaca = subRacaPersonagem;
        this.classe = classePersonagem;
        this.subClasse = subClassePersonagem;
        this.nivel = nivel;
        this.skills = new ArrayList<>();
        this.equipamentos = new ArrayList<>();
        this.linguagens = new ArrayList<>();
        if(scoresHabilidade.length == 6)
            this.scoresHabilidadeIniciais = scoresHabilidade;
        else
            this.scoresHabilidadeIniciais = new int[6];
        
        //Variáveis que dependem da Raça
        definirScoresFinais(this.raca.getAumentosScoresHabilidade());
        this.linguagens.addAll( Arrays.asList( this.raca.getLinguagensIniciais()));
        
        //Variáveis que dependem da Classe
        this.hpMaximo[0] = classe.getDadoHP() + modificadoresHabilidade[2];
        this.hpAtual = this.hpMaximo[0];
        this.skills.addAll( Arrays.asList( this.classe.getProficienciasIniciais() ) );
        this.equipamentos.addAll( Arrays.asList( this.classe.getEquipamentoInicialEscolhido() ) );
    }
    
    private void definirScoresFinais(int[] aumentoScoreRaca)
    {
        this.scoresHabilidadeFinais = new int[6];
        
        for(int i = 0; i < 6; i++) {
            this.scoresHabilidadeFinais[i] = this.scoresHabilidadeIniciais[i] + aumentoScoreRaca[i];
        }
        
        calcularModificadores(this.scoresHabilidadeFinais);
    }
    
    /**
     * Tabela de Conversão de Score Para Modificador <p>
     * 1 = −5 <p>
     * 2/3 = −4 <p>
     * 4/5 = −3 <p>
     * 6/7 = −2 <p>
     * 8/9 = −1 <p>
     * 10/11 = +0 <p>
     * 12/13 = +1 <p>
     * 14/15 = +2 <p>
     * 16/17 = +3 <p>
     * 18/19 = +4 <p>
     * 20/21 = +5 <p>
     * 22/23 = +6 <p>
     * 24/25 = +7 <p>
     * 26/27 = +8 <p>
     * 28/29 = +9 <p>
     * 30 = +10 <p>
     */
    private void calcularModificadores(int[] scoresHabilidade)
    {
        int [] modificadores = new int[6];
        
        for(int i = 0; i < 6; i++)
        {
            switch(scoresHabilidade[0])
            {
                case 1:
                {
                    modificadores[i] = -5;
                    break;
                }
                case 2:
                case 3:
                {
                    modificadores[i] = -4;
                    break;
                }
                case 4:
                case 5:
                {
                    modificadores[i] = -3;
                    break;
                }
                case 6:
                case 7:
                {
                    modificadores[i] = -2;
                    break;
                }
                case 8:
                case 9:
                {
                    modificadores[i] = -1;
                    break;
                }
                case 10:
                case 11:
                {
                    modificadores[i] = 0;
                    break;
                }
                case 12:
                case 13:
                {
                    modificadores[i] = 1;
                    break;
                }
                case 14:
                case 15:
                {
                    modificadores[i] = 2;
                    break;
                }
                case 16:
                case 17:
                {
                    modificadores[i] = 3;
                    break;
                }
                case 18:
                case 19:
                {
                    modificadores[i] = 4;
                    break;
                }
                case 20:
                case 21:
                {
                    modificadores[i] = 5;
                    break;
                }
                case 22:
                case 23:
                {
                    modificadores[i] = 6;
                    break;
                }
                case 24:
                case 25:
                {
                    modificadores[i] = 7;
                    break;
                }
                case 26:
                case 27:
                {
                    modificadores[i] = 8;
                    break;
                }
                case 28:
                case 29:
                {
                    modificadores[i] = 9;
                    break;
                }
                case 30:
                {
                    modificadores[i] = 10;
                    break;
                }
            }
        }

        this.modificadoresHabilidade = modificadores;
    }

    
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdImagem() {
        return idImagem;
    }
    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public RacaVO getRaca() {
        return raca;
    }
    public void setRaca(RacaVO raca) {
        this.raca = raca;
    }

    public SubRacaVO getSubRaca() {
        return subRaca;
    }
    public void setSubRaca(SubRacaVO subRaca) {
        this.subRaca = subRaca;
    }

    public ClasseVO getClasse() {
        return classe;
    }
    public void setClasse(ClasseVO classe) {
        this.classe = classe;
    }

    public SubClasseVO getSubClasse() {
        return subClasse;
    }
    public void setSubClasse(SubClasseVO subClasse) {
        this.subClasse = subClasse;
    }

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public BackgroundPersonagemVO getBackground() {
        return background;
    }
    public void setBackground(BackgroundPersonagemVO background) {
        this.background = background;
    }

    public int[] getScoresHabilidadeIniciais() {
        return scoresHabilidadeIniciais;
    }
    public void setScoresHabilidadeIniciais(int[] scoresHabilidade) throws WrongArgumentException {
        if(scoresHabilidade.length == 6)
        {
            this.scoresHabilidadeIniciais = scoresHabilidade;
            definirScoresFinais(this.raca.getAumentosScoresHabilidade());
        }
        else
            throw new WrongArgumentException("Erro em PersonagemVO.SetScoresHabilidades: O método só aceita  um Array de tamanho 6");
    }
    public void setScoresHabilidadeIniciais(int str, int dex, int con, int inte, int wis, int cha) {
        this.scoresHabilidadeIniciais = new int[]{str, dex, con, inte, wis, cha};
        definirScoresFinais(this.raca.getAumentosScoresHabilidade());
    }

    public int[] getScoresHabilidadeFinais() {
        return scoresHabilidadeFinais;
    }

    public int[] getModificadoresHabilidade() {
        return modificadoresHabilidade;
    }

    public int[] getHpMaximo() {
        return hpMaximo;
    }
    public void setHpMaximo(int[] hpMaximo) {
        this.hpMaximo = hpMaximo;
    }

    public int getHpAtual() {
        return hpAtual;
    }
    public void setHpAtual(int hpAtual) {
        this.hpAtual = hpAtual;
    }

    public int getHpTemp() {
        return hpTemp;
    }
    public void setHpTemp(int hpTemp) {
        this.hpTemp = hpTemp;
    }

    public ArrayList<SkillVO> getSkills() {
        return skills;
    }
    public void setSkills(ArrayList<SkillVO> skills) {
        this.skills = skills;
    }

    public ArrayList<EquipamentoVO> getEquipamentos() {
        return equipamentos;
    }
    public void setEquipamentos(ArrayList<EquipamentoVO> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public int getArmorClass() {
        return armorClass;
    }
    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public ArrayList<LinguagemVO> getLinguagens() {
        return linguagens;
    }
    public void setLinguagens(ArrayList<LinguagemVO> linguagens) {
        this.linguagens = linguagens;
    }

    public int getIniciativa() {
        return iniciativa;
    }
    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public boolean[] getDeathSaves() {
        return deathSaves;
    }
    public void setDeathSaves(boolean[] deathSaves) {
        this.deathSaves = deathSaves;
    }

    public boolean isInspiracao() {
        return inspiracao;
    }
    public void setInspiracao(boolean inspiracao) {
        this.inspiracao = inspiracao;
    }

    public DescricaoPersonagemVO getDescricaoPersonagem() {
        return descricaoPersonagem;
    }
    public void setDescricaoPersonagem(DescricaoPersonagemVO descricaoPersonagem) {
        this.descricaoPersonagem = descricaoPersonagem;
    }

    public String getJornalDeCampo() {
        return jornalDeCampo;
    }
    public void setJornalDeCampo(String jornalDeCampo) {
        this.jornalDeCampo = jornalDeCampo;
    }

    public String getNotasExtras() {
        return notasExtras;
    }
    public void setNotasExtras(String notasExtras) {
        this.notasExtras = notasExtras;
    }
}
