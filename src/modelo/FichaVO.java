/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import enums.NomesSkillEnum;

/**
 *
 * @author 181700271
 */
public class FichaVO extends ObjetoVO
{
    private PersonagemVO personagem;
    
    // Cabeçalho 1 (Pontos)
    private String nomePersonagem;                      // Personagem
    private String caminhoImagemPersonagem;             // Personagem
    private String nomeClassePersonagem;                // Classe
    private int nivelPersonagem;                        // Personagem
    private String nomeJogador;                         // Usuário
    private String nomeRaca;                            // Raça
    private String nomeBackground;                      // Background
    private int xpPersonagem;                           // Personagem
    
    // Pontos de Atributo e seus modificadores
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;  // Personagem
    private int modSTR, modDEX, modCON, modINT, modWIS, modCHA;                     // Personagem
    
    // Inspiração
    private boolean inspirado;                          // Personagem
    
    // Valor do Bônus de Proficiencia
    // Começa em 2, +1 a cada 4 níveis (lv4 = +2, lv5 = +3, lv9 = +4, etc.)
    private int bonusProficiencia;                      // Calcular com nível (Personagem)
    
    // Saving Throws e suas proficiencias
    private int saveSTR, saveDEX, saveCON, saveINT, saveWIS, saveCHA;               // Calcular com modificador do score (Personagem) + proficiencia (proficienciasSave)
    private boolean profSaveSTR, profSaveDEX, profSaveCON, profSaveINT, profSaveWIS, profSaveCHA;   // ProficienciasSave
    
    // Skills e suas proficiencias                 
    private String[] nomesSkill;
    private boolean[] profSkills;   // Lista fixa, proficiencias em proficienciasSkill
    
    // Sentidos
    private int intuicaoPassiva;                          // Calcular com seu respectivo score(Personagem)
    private int percepcaoPassiva; 
    private String[] buffsSentido;                      // Verificar na Raça, Classe e Feats
    
    // Armor Class
    private int armorClass;                             // Se estiver com armor equipada, usar AC da armadura + shield, senão calcular com modificadores apropriados
    
    // Iniciativa
    private int iniciativa;                             // Personagem
    
    // Defesas
    private boolean[] resistencias;                     // Personagem(Raça, Classe, Background e Feats)
    private boolean[] vulnerabilidades;                 // Personagem(Raça, Classe, Background e Feats)
    
    // Valor do Save de Habilidade de classe
    private int saveHabilidade;                         // Classe
    
    // Velocidade
    private int velocidade;                             // Raça, feats e buffs apropriados
    
    // Hit Point Máximo e Atual
    private int hpMaximo, hpAtual;                      // Classe
    
    // Hit Points Temporários
    private int hpTemporario;                           // Personagem
    
    // Hit Dice
    private int hitDice;                                // Classe
    
    // Death saves
    private boolean[] falhas;                           // Campo da ficha
    private boolean[] sucessos;                         // Campo da ficha
    
    // Proficiencias e Linguagens
    private String[] proficiencias;                     // Personagem(Raça, Classe, Background e Feats)
    private String[] linguagens;                        // Personagem(Raça, Classe, Background e Feats)
    
    // Ações
    private String[][] acoes;                           // listaEquipamentos, Raça, Classe, Background e Feats
    
    // Ataques com Armas, Traço de Raça ou Feature da Classe
    private String[][] ataques;                         // listaEquipamentos, Raça, Classe
    
    // Features & Traits
    private String[] features;                          // Classe
    private String[] traits;                            // Raça
    
    // Equipamento
    private String[] equipamento;                       // listaEquipamentos
    
    // Cabeçalho 2 (Detalhes do Personagem)
    private String genero;                              // detalhesPersonagem
    private int idade;                                  // detalhesPersonagem
    private String tamanho;                             // detalhesPersonagem
    private int altura;                                 // detalhesPersonagem
    private int peso;                                   // detalhesPersonagem
    private String alinhamento;                         // detalhesPersonagem
    private String fe;                                  // detalhesPersonagem
    private String pele;                                // detalhesPersonagem
    private String olhos;                               // detalhesPersonagem
    private String cabelo;                              // detalhesPersonagem
    
    // Aparência do Personagem
    private String aparencia;                           // detalhesPersonagem
    
    // Aliados e Organizações
    private String aliadosEorganizacoes;                // detalhesPersonagem
    
    // Traços de Personalidade
    private String tracosPersonalidade;                 // detalhesPersonagem
    
    // Ideais
    private String ideais;                              // detalhesPersonagem
    
    // Laços
    private String lacos;                               // detalhesPersonagem
    
    // Pontos Fracos
    private String pontosFracos;                        // detalhesPersonagem
    
    // Backstory do Personagem
    private String backstory;                           // backstoryPersonagem
    
    // Anotações Extras
    private String anotacoes;                           // Personagem
    
    // Cabeçalho 3 (Spells)
    private String classeSpellcaster;                   // Classe
    private String atributoPrincipal;                   // Classe
    private String saveSpell;                           // Classe
    
    // Lista de Spells
    private String[][] listaSpells;                     // Classe, Raça

    public FichaVO(PersonagemVO personagem, String nomeJogador){
        this.personagem = personagem;
        this.nomeJogador = nomeJogador;
        construirFicha();
    }
    
    private void construirFicha()
    {
        nomePersonagem = personagem.getNome();
        caminhoImagemPersonagem = personagem.getImagem().getCaminhoImagem();
        nomeClassePersonagem = personagem.getClasse().getNome();
        nivelPersonagem = personagem.getNivel();
        nomeRaca = personagem.getRaca().getNome();
        nomeBackground = personagem.getBackground().getNome();
        xpPersonagem = personagem.getXp();
        
        strength = personagem.getStrTotal();
        dexterity = personagem.getDexTotal();
        constitution = personagem.getConTotal();
        intelligence = personagem.getIntTotal();
        wisdom = personagem.getWisTotal();
        charisma = personagem.getChaTotal();
        
        modSTR = personagem.getStrMod();
        modDEX = personagem.getDexMod();
        modCON = personagem.getConMod();
        modINT = personagem.getIntMod();
        modWIS = personagem.getWisMod();
        modCHA = personagem.getChaMod();
        
        inspirado = personagem.isInspirado();
        
        bonusProficiencia = 2;
        int cont = 0;
        for(int i = 1; i <= personagem.getNivel(); i++) {
            cont++;
            if(cont == 4) {
                cont = 0;
                bonusProficiencia += 1;
            }
        }
        
        saveSTR = modSTR;
        saveDEX = modDEX;
        saveCON = modCON;
        saveINT = modINT;
        saveWIS = modWIS;
        saveCHA = modCHA;
        profSaveSTR = false;
        profSaveDEX = false;
        profSaveCON = false;
        profSaveINT = false;
        profSaveWIS = false;
        profSaveCHA = false;
        for(ProficienciaSaveVO p : personagem.getProficienciasSave()) {
            switch(p.getNomeSave().toLowerCase()) {
                case "str":
                    saveSTR += bonusProficiencia;
                    profSaveSTR = true;
                    break;
                case "dex":
                    saveDEX += bonusProficiencia;
                    profSaveDEX = true;
                    break;
                case "con":
                    saveCON += bonusProficiencia;
                    profSaveCON = true;
                    break;
                case "int":
                    saveINT += bonusProficiencia;
                    profSaveINT = true;
                    break;
                case "wis":
                    saveWIS += bonusProficiencia;
                    profSaveWIS = true;
                    break;
                case "cha":
                    saveCHA += bonusProficiencia;
                    profSaveCHA = true;
                    break;
                default:
                    break;
            }
        }
        
        nomesSkill = NomesSkillEnum.getNomesPossiveis();
        profSkills = new boolean[nomesSkill.length];
        for(ProficienciaSaveVO p : personagem.getProficienciasSave()) {
            switch(p.getNomeSave()) { 
                case ATLETISMO:
                {
                    profSkills[0] = true;
                    break;
                }
                case ACROBACIA:
                {
                    profSkills[1] = true;
                    break;
                }
                case FURTIVIDADE:
                {
                    profSkills[2] = true;
                    break;
                }
                case PRESTIDIGITACAO :
                {
                    profSkills[3] = true;
                    break;
                }
                 case ARCANISMO:
                {
                    profSkills[4] = true;
                    break;
                }
                 case HISTORIA:
                {
                    profSkills[5] = true;
                    break;
                }
                 case INVESTIGACAO:
                {
                    profSkills[6] = true;
                    break;
                }
                 case NATUREZA:
                {
                    profSkills[7] = true;
                    break;
                }
                 case RELIGIAO:
                {
                    profSkills[8] = true;
                    break;
                }
                 case ADESTRAR_ANIMAIS:
                {
                    profSkills[9] = true;
                    break;
                }
                 case INTUICAO:
                {
                    profSkills[10] = true;
                    break;
                }
                 case MEDICINA:
                {
                    profSkills[11] = true;
                    break;
                }
                 case PERCEPCAO:
                {
                    profSkills[12] = true;
                    break;
                }
                 case SOBREVIVENCIA:
                {
                    profSkills[13] = true;
                    break;
                }
                 case ATUACAO:
                {
                    profSkills[14] = true;
                    break;
                }
                 case ENGANACAO:
                {
                    profSkills[15] = true;
                    break;
                }
                 case INTIMIDACAO:
                {
                    profSkills[16] = true;
                    break;
                }
                 case PERSUASAO:
                {
                    profSkills[17] = true;
                    break;
                }
            }
        }
        intuicaoPassiva = 10 + saveWIS;
        percepcaoPassiva = 10 + saveWIS;
        buffsSentido = ;
        armorClass = ;
        iniciativa = ;
        resistencias = ;
        vulnerabilidades = ;
        saveHabilidade = ;
        velocidade = ;
        hpMaximo = ;
        hpAtual = ;
        hpTemporario = ;
        hitDice = ;
        falhas = ;
        sucessos = ;
        proficiencias = ;
        linguagens = ;
        acoes = ;
        ataques = ;
        features = ;
        traits = ;
        equipamento = ;
        genero = ;
        idade = ;
        tamanho = ;
        altura = ;
        peso = ;
        alinhamento = ;
        fe = ;
        pele = ;
        olhos = ;
        cabelo = ;
        aparencia = ;
        aliadosEorganizacoes = ;
        tracosPersonalidade = ;
        ideais = ;
        lacos = ;
        pontosFracos = ;
        backstory = ;
        anotacoes = ;
        classeSpellcaster = ;
        atributoPrincipal = ;
        saveSpell = ;
        listaSpells = ;
    }

    
}
