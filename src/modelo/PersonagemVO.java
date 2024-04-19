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
    private int idUsuario;                                  //Definido externamente, obrigatório
    private int idImagem;                                   //Definido externamente
    private String nome;                                    //Definido externamente
    private RacaVO raca;                                    //Definido externamente, obrigatório
    private SubRacaVO subRaca;                              //Definido externamente
    private ClasseVO classe;                                //Definido externamente, obrigatório
    private SubClasseVO subClasse;                          //Definido externamente
    private int nivelAnterior;                              //Variavel interna para guardar nivel anterior
    private int nivel;                                      //Definido externamente, inicia como um
    private BackgroundPersonagemVO background;              //Definido externamente, inicializa vazio
    private int[] scoresHabilidadeIniciais;                 //Strength, Dexterity, Constitution, Intelligence, Wisdom, e Charisma.
    private int[] scoresHabilidadeFinais;                   //Calculado a partir de scoresHabilidadeIniciais[] + Aumentos da Raça
    private int[] modificadoresHabilidade;                  //Calculado a partir de scoresHabilidadeFinais[]: Usar calcularModificadores(scoresHabilidade)
    private int[] rolagensHpMax;                            //Informado pelo usuário e baseado no dado da Classe. Nivel 1 tem valor fixo
    private int hpMaximo;                                   //Soma de todos os membros de rolagensHpMax[]
    private int hpAtual;                                    //Inicia igual ao hpMax, depois deve ser definido externamente
    private int hpTemp;                                     //Definido externamente, inicia como zero
    private ArrayList<SkillVO> skills;                      //Inicializa como valores informados pela classe, alterada externamente
    private ArrayList<EquipamentoVO> equipamentos;          //Inicializa como valores informados pela classe, alterada externamente
    private int armorClass;                                 //Calculado a partir do seu modificadoresHabilidade[1] (DEX), equipamento do tipo armadura e classe
    private ArrayList<LinguagemVO> linguagens;              //Inicializa como uma lista vazia, alterada externamente
    private int iniciativa;                                 //d20 + modificadoresHabilidade[1] (DEX) + qualquer outro bônus
    private boolean[] deathSaves;                           //d20; Se >= 10 = sucesso(true), se < 10 = fracasso(false); Se for 1, conta como 2; Se for 20 conta como 5
    private boolean inspiracao;                             //Definido externamente, inicia como false
    private DescricaoPersonagemVO descricaoPersonagem;      //Inicializa como um "DescricaoPersonagemVO" vazio, preenchido externamente
    private String jornalDeCampo;                           //Definido externamente
    private String notasExtras;                             //Definido externamente

    public PersonagemVO() {
        this.idUsuario = -1;
        this.nome = "Sem Nome";
        this.raca = null;
        this.subRaca = null;
        this.classe = null;
        this.subClasse = null;
        this.nivelAnterior = 0;
        setNivel(1);
        this.background = new BackgroundPersonagemVO();
        this.hpAtual = this.hpMaximo;
        this.skills = new ArrayList<>();
        this.equipamentos = new ArrayList<>();
        this.linguagens = new ArrayList<>();
    }
    
    
    public int[] getModificadoresHabilidade() {
        return modificadoresHabilidade;
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
    private void setModificadoresHabilidade(int[] scoresHabilidade) {
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
    
    public int[] getScoresHabilidadeFinais() {
        return scoresHabilidadeFinais;
    }
    private void setScoresHabilidadeFinais(int[] aumentoScoreRaca) {
        this.scoresHabilidadeFinais = new int[6];
        
        for(int i = 0; i < 6; i++) {
            this.scoresHabilidadeFinais[i] = this.scoresHabilidadeIniciais[i] + aumentoScoreRaca[i];
        }
        
        setModificadoresHabilidade(this.scoresHabilidadeFinais);
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
        setScoresHabilidadeFinais(this.raca.getAumentosScoresHabilidade());
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

    public int getNivelAnterior() {
        return nivelAnterior;
    }
    
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivelAnterior = this.nivel;
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
    public void setScoresHabilidadeIniciais(int[] scoresHabilidadeIniciais) {
        this.scoresHabilidadeIniciais = scoresHabilidadeIniciais;
        setScoresHabilidadeFinais(this.raca.getAumentosScoresHabilidade());
        
    }

    public int[] getRolagensHpMax() {
        return rolagensHpMax;
    }
    public void setRolagensHpMax(int[] rolagensHpMax) {
        this.rolagensHpMax = rolagensHpMax;
    }
    public void setRolagemHpMax(int rolagemHpMax, int nivel) {
        if(nivel > 1 && nivel <= 30)
        {
            int indiceLimite = nivel - 1;
            this.rolagensHpMax[indiceLimite] = rolagemHpMax;
            for(int i = indiceLimite; i < 30; i++) {
                this.rolagensHpMax[i] = 0;
                resetHpMaximo();
            }
        }
        else
            resetRolagensHpMax();
    }
    public void resetRolagensHpMax() {
        this.rolagensHpMax = new int[30];
        this.rolagensHpMax[0] = this.classe.getDadoHP() + this.modificadoresHabilidade[2];
        resetHpMaximo();
    }
    
    public int getHpMaximo() {
        return hpMaximo;
    }
    public void resetHpMaximo() {
        int novoHpMaximo = 0;
        for(int i : this.rolagensHpMax) {
            novoHpMaximo+= i;
        }
        this.hpMaximo = novoHpMaximo;
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
    public void addSkill(SkillVO skill) {
        this.skills.add(skill);
    }
    public void removeSkill(SkillVO skill) {
        this.skills.remove(skill);
    }
    public void removeSkill(int indice) {
        this.skills.remove(indice);
    }
    
    public ArrayList<EquipamentoVO> getEquipamentos() {
        return equipamentos;
    }
    public void setEquipamentos(ArrayList<EquipamentoVO> equipamentos) {
        this.equipamentos = equipamentos;
    }
    public void addEquipamento(EquipamentoVO equipamento) {
        this.equipamentos.add(equipamento);
    }
    public void removeEquipamento(EquipamentoVO equipamento) {
        this.equipamentos.remove(equipamento);
    }
    public void removeEquipamento(int indice) {
        this.equipamentos.remove(indice);
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
    public void addLinguagem(LinguagemVO linguagem) {
        this.linguagens.add(linguagem);
    }
    public void removeLinguagem(LinguagemVO linguagem) {
        this.linguagens.remove(linguagem);
    }
    public void removeLinguagem(int indice) {
        this.linguagens.remove(indice);
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
    public void setDeathSave(int indice) {
        this.deathSaves[indice] = !this.deathSaves[indice];
    }

    public boolean isInspirado() {
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
