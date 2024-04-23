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
public class FichaVO extends ObjetoVO
{
    private PersonagemVO personagem;
    
    // Cabeçalho 1 (Pontos)
    private String nomePersonagem;
    private String caminhoImagemPersonagem;
    private String nomeClassePersonagem;
    private int nivelPersonagem;
    private String nomeJogador;
    private String nomeRaca;
    private String nomeBackground;
    private int xpPersonagem;
    
    // Pontos de Atributo e seus modificadores
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;
    private int modSTR, modDEX, modCON, modINT, modWIS, modCHA;
    
    // Inspiração
    private boolean inspirado;
    
    // Valor do Bônus de Proficiencia
    private int bonusProficiencia;
    
    // Saving Throws e suas proficiencias
    private int saveSTR, saveDEX, saveCON, saveINT, saveWIS, saveCHA;
    private boolean profSaveSTR, profSaveDEX, profSaveCON, profSaveINT, profSaveWIS, profSaveCHA;
    
    // Skills e suas proficiencias
    private boolean skill;
    
    // Sentidos
    private int statusPassivo;
    private String[] buffsSentido;
    
    // Armor Class
    private int armorClass;
    
    // Iniciativa
    private int iniciativa;
    
    // Defesas
    private boolean[] resistencias;
    private boolean[] vulnerabilidades;
    
    // Valor do Save de Habilidade de classe
    private int saveHabilidade;
    
    // Velocidade
    private int velocidade;
    
    // Hit Point Máximo e Atual
    private int hpMaximo, hpAtual;
    
    // Hit Points Temporários
    private int hpTemporario;
    
    // Hit Dice
    private int hitDice;
    
    // Death saves
    private boolean[] falhas;
    private boolean[] sucessos;
    
    // Proficiencias e Linguagens
    private String[] proficiencias;
    private String[] lingugagens;
    
    // Ações
    private String[][] acoes;
    
    // Ataques com Armas, Traço de Raça ou Feature da Classe
    private String[][] ataques;
    
    // Features & Traits
    private String[] features;
    private String[] traits;
    
    // Equipamento
    private String[][] equipamento;
    
    // Cabeçalho 2 (Detalhes do Personagem)
    private String genero;
    private int idade;
    private String tamanho;
    private int altura;
    private int peso;
    private String alinhamento;
    private String fe;
    private String pele;
    private String olhos;
    private String cabelo;
    
    // Aparência do Personagem
    private String aparencia;
    
    // Aliados e Organizações
    private String aliadosEorganizacoes;
    
    // Traços de Personalidade
    private String tracosPersonalidade;
    
    // Ideais
    private String ideais;
    
    // Laços
    private String lacos;
    
    // Pontos Fracos
    private String pontosFracos;
    
    // Backstory do Personagem
    private String backstory;
    
    // Anotações Extras
    private String anotacoes;
    
    // Cabeçalho 3 (Spells)
    private String classeSpellcaster;
    private String atributoPrincipal;
    private String saveSpell;
    
    // Lista de Spells
    private String[][] listaSpells;

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
        
        saveSTR = ;
        saveDEX = ;
        saveCON = ;
        saveINT = ;
        saveWIS = ;
        saveCHA = ;
        profSaveSTR = ;
        profSaveDEX = ;
        profSaveCON = ;
        profSaveINT = ;
        profSaveWIS = ;
        profSaveCHA = ;
        skill = ;
        statusPassivo = ;
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
        lingugagens = ;
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
