/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosFront;

import enums.AtributosEnum;
import enums.PericiasEnum;
import java.util.Arrays;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class FichaPersonagem
{
    // Objetos necessários
    private final UsuarioVO usuario;
    private final PersonagemVO personagem;
    private final ImagemVO imagemPersonagem;
    private final ClasseVO classe;
    private final SubclasseVO subclasse;
    private final RacaVO raca;
    private final SubRacaVO subraca;
    private final BackgroundVO background;
    private final BackstoryVO backstory;
    private final DetalhesVO detalhes;
    
    private final AtributosVO valoresEProficienciasDosAtributos;
    private final PericiasVO proficienciasDasPericias;
    private final ProficienciasVO proficiencias;
    private final FeatVO[] feats;
    private final EquipamentoVO[] equipamentos;
    
    // Cabeçalho 1
    private final String nomePersonagem;
    private final int nivelPersonagem;
    private final int xpPersonagem;
    private final String nomeUsuario;
    private final String nomeClasse;
    private final String nomeRaca;
    private final String nomeBackground;
    
    // Pontos de Atributo e seus modificadores
    // - Score total = Score Base (roll, array ou point buy) + Bônus de Raça/Subraça + Melhorias de nível + Bônus extras
    // - Modificador = ((atributo - 10) / 2); Arrendodar pra baixo se necessário(Math.Floor)
    private final int strTotal, dexTotal, conTotal, intTotal, wisTotal, chaTotal;
    private final int modSTR, modDEX, modCON, modINT, modWIS, modCHA;
    
    // Inspiração
    private final boolean personagemInspirado;
    
    // Valor do Bônus de Proficiencia
    // - Valor começa em 2, +1 a cada 4 níveis (lv4 = +2, lv5 = +3, lv9 = +4, etc.)
    private final int bonusProficienciaPersonagem;
    
    // Saving Throws e suas proficiencias
    // - Afetados pela Classe, SubClasse e Feats
    private final boolean[] proficienciasSaves;
    private final int[] valoresSaves;
    
    // Skills e suas proficiencias
    // - Afetados pela Classe, SubClasse, Background e Feats
    private final boolean[] proficienciasSkills;
    private final String[] nomesSkills;
    
    // Sentidos
    // - Status passivos
    // - Quaisquer buffs de sentidos (Darkvision)
    private int valorIntuicaoPassiva;
    private int valorPercepcaoPassiva;
    private String buffsSentido;
    
    // Iniciativa:
    // - 1d20 + modificador de DEX
    
    // Defesas
    // - Resistencias (Metade do dano)
    // - Vulnerabilidades (Dobro do dano)
    
    // Valor do Save de Habilidade de classe
    // - Para habilidades de classe/subclasse que forçam um save, mas que não são spells
    
    // Velocidade
    // - Afetada pela raça, subraça, equipamento, feats, spells
    
    // Hit Point Máximo e Atual
    // - Lvl.1: HP Máximo = Dado da Classe + modificador de CON
    // - A cada novo nível: HP Máximo novo = HP Máximo antigo + (rolar o dado da Classe + modificador de CON)
    // - Guardar cada valor separado
    
    // Hit Points Temporários
    
    // Hit Dice
    // - Rolar o dado da Classe uma vez por nível atual
    
    // Death saves
    // - Rolar 1d20 e adicionar qualquer bônus de spells e feats
    // Resultados do Dado:
    // - 20 -> Revive com 1 HP
    // - [10, 19] -> 1 vitória
    // - [2, 9] -> 1 falha
    // - 1 -> 2 falhas
    // - Receber dano -> 1 falha, 2 se for um crítico
    // O primeiro resultado é o que conta:
    // - Receber cura -> Revive
    // - Estabilizado por algúem -> Vc para de morrer (n tem mais que girar), mas permanece inconsciente e acorda em 1d4 horas com 1 de HP. Se receber dano nesse estado deve rolar Death saves denovo
    // - 3 Sucessos -> Vc para de morrer (n tem mais que girar), mas permanece inconsciente e acorda em 1d4 horas com 1 de HP. Se receber dano nesse estado deve rolar Death saves denovo
    // - 3 Falhas -> R.I.P. in Pepperoni
    // - Se o dano recebido, após subtrair seu HP atual, é igual ou maior ao seu HP Máximo, vc morre imediatamente
    
    // Proficiencias e Linguagens
    
    // Ações
    // - Pulo alto -> Valor de STR, metade desse valor se o personagem não correr antes do pulo
    // - Pulo longo -> 3 + Modificador de STR, metade desse valor se o personagem não correr antes do pulo
    
    // Ataques com Armas
    // - Afetados pela classe, subclasse, raça, subraça e equipamento
    
    // Features & Traits
    
    // Equipamento
    // - Iniciais são definidos pela Classe, Subclasse e Background
    
    // Cabeçalho 2 (Detalhes do Personagem)
    // - Gênero
    // - Idade
    // - Tamanho
    // - Altura
    // - Peso
    // - Alinhamento
    // - Fé
    // - Pele
    // - Olhos
    // - Cabelo
    

    // Aparência do Personagem


    // Aliados e Organizações


    // Traços de Personalidade


    // Ideais


    // Laços


    // Pontos Fracos


    // Backstory do Personagem


    // Anotações Extras


    //Cabeçalho 3 (Spells)
    //- Classe de Spellcaster
    //- Atributo Principal do Spellcaster
    //- Valor do Save de Spell


    //Lista de Spells

    
    private AtributosVO definirValoresEProficienciasAtributos() {
        int strSoma = 0;
        int dexSoma = 0;
        int conSoma = 0;
        int intSoma = 0;
        int wisSoma = 0;
        int chaSoma = 0;
        AtributosVO atributosFinais = new AtributosVO(modSTR, modDEX, modCON, modINT, modWIS, modCHA);
        
        if(personagem != null) {
            AtributosPersonagemVO atributosPersonagem = personagem.getValoresEProficienciasAtributosPersonagem();
            strSoma += atributosPersonagem.getValorAtributo(AtributosEnum.STR);
            dexSoma += atributosPersonagem.getValorAtributo(AtributosEnum.DEX);
            conSoma += atributosPersonagem.getValorAtributo(AtributosEnum.CON);
            intSoma += atributosPersonagem.getValorAtributo(AtributosEnum.INT);
            wisSoma += atributosPersonagem.getValorAtributo(AtributosEnum.WIS);
            chaSoma += atributosPersonagem.getValorAtributo(AtributosEnum.CHA);
            
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.STR)) && atributosPersonagem.isProficienteAtributo(AtributosEnum.STR))
                atributosFinais.setProficienciaAtributo(AtributosEnum.STR, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.DEX)) && atributosPersonagem.isProficienteAtributo(AtributosEnum.DEX))
                atributosFinais.setProficienciaAtributo(AtributosEnum.DEX, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CON)) && atributosPersonagem.isProficienteAtributo(AtributosEnum.CON))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CON, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.INT)) && atributosPersonagem.isProficienteAtributo(AtributosEnum.INT))
                atributosFinais.setProficienciaAtributo(AtributosEnum.INT, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.WIS)) && atributosPersonagem.isProficienteAtributo(AtributosEnum.WIS))
                atributosFinais.setProficienciaAtributo(AtributosEnum.WIS, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CHA)) && atributosPersonagem.isProficienteAtributo(AtributosEnum.CHA))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CHA, true);
        }
        if(classe != null) {
            AtributosVO bonusAtributosClasse = classe.getBonusEProficienciasAtributos();
            strSoma += bonusAtributosClasse.getValorAtributo(AtributosEnum.STR);
            dexSoma += bonusAtributosClasse.getValorAtributo(AtributosEnum.DEX);
            conSoma += bonusAtributosClasse.getValorAtributo(AtributosEnum.CON);
            intSoma += bonusAtributosClasse.getValorAtributo(AtributosEnum.INT);
            wisSoma += bonusAtributosClasse.getValorAtributo(AtributosEnum.WIS);
            chaSoma += bonusAtributosClasse.getValorAtributo(AtributosEnum.CHA);
            
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.STR)) && bonusAtributosClasse.isProficienteAtributo(AtributosEnum.STR))
                atributosFinais.setProficienciaAtributo(AtributosEnum.STR, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.DEX)) && bonusAtributosClasse.isProficienteAtributo(AtributosEnum.DEX))
                atributosFinais.setProficienciaAtributo(AtributosEnum.DEX, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CON)) && bonusAtributosClasse.isProficienteAtributo(AtributosEnum.CON))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CON, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.INT)) && bonusAtributosClasse.isProficienteAtributo(AtributosEnum.INT))
                atributosFinais.setProficienciaAtributo(AtributosEnum.INT, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.WIS)) && bonusAtributosClasse.isProficienteAtributo(AtributosEnum.WIS))
                atributosFinais.setProficienciaAtributo(AtributosEnum.WIS, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CHA)) && bonusAtributosClasse.isProficienteAtributo(AtributosEnum.CHA))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CHA, true);
        }
        if(subclasse != null) {
            AtributosVO bonusAtributosSubclasse = subclasse.getBonusEProficienciasAtributos();
            strSoma += bonusAtributosSubclasse.getValorAtributo(AtributosEnum.STR);
            dexSoma += bonusAtributosSubclasse.getValorAtributo(AtributosEnum.DEX);
            conSoma += bonusAtributosSubclasse.getValorAtributo(AtributosEnum.CON);
            intSoma += bonusAtributosSubclasse.getValorAtributo(AtributosEnum.INT);
            wisSoma += bonusAtributosSubclasse.getValorAtributo(AtributosEnum.WIS);
            chaSoma += bonusAtributosSubclasse.getValorAtributo(AtributosEnum.CHA);
            
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.STR)) && bonusAtributosSubclasse.isProficienteAtributo(AtributosEnum.STR))
                atributosFinais.setProficienciaAtributo(AtributosEnum.STR, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.DEX)) && bonusAtributosSubclasse.isProficienteAtributo(AtributosEnum.DEX))
                atributosFinais.setProficienciaAtributo(AtributosEnum.DEX, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CON)) && bonusAtributosSubclasse.isProficienteAtributo(AtributosEnum.CON))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CON, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.INT)) && bonusAtributosSubclasse.isProficienteAtributo(AtributosEnum.INT))
                atributosFinais.setProficienciaAtributo(AtributosEnum.INT, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.WIS)) && bonusAtributosSubclasse.isProficienteAtributo(AtributosEnum.WIS))
                atributosFinais.setProficienciaAtributo(AtributosEnum.WIS, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CHA)) && bonusAtributosSubclasse.isProficienteAtributo(AtributosEnum.CHA))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CHA, true);
        }
        if(raca != null) {
            AtributosVO bonusAtributosRaca = raca.getBonusEProficienciasAtributos();
            strSoma += bonusAtributosRaca.getValorAtributo(AtributosEnum.STR);
            dexSoma += bonusAtributosRaca.getValorAtributo(AtributosEnum.DEX);
            conSoma += bonusAtributosRaca.getValorAtributo(AtributosEnum.CON);
            intSoma += bonusAtributosRaca.getValorAtributo(AtributosEnum.INT);
            wisSoma += bonusAtributosRaca.getValorAtributo(AtributosEnum.WIS);
            chaSoma += bonusAtributosRaca.getValorAtributo(AtributosEnum.CHA);
            
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.STR)) && bonusAtributosRaca.isProficienteAtributo(AtributosEnum.STR))
                atributosFinais.setProficienciaAtributo(AtributosEnum.STR, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.DEX)) && bonusAtributosRaca.isProficienteAtributo(AtributosEnum.DEX))
                atributosFinais.setProficienciaAtributo(AtributosEnum.DEX, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CON)) && bonusAtributosRaca.isProficienteAtributo(AtributosEnum.CON))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CON, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.INT)) && bonusAtributosRaca.isProficienteAtributo(AtributosEnum.INT))
                atributosFinais.setProficienciaAtributo(AtributosEnum.INT, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.WIS)) && bonusAtributosRaca.isProficienteAtributo(AtributosEnum.WIS))
                atributosFinais.setProficienciaAtributo(AtributosEnum.WIS, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CHA)) && bonusAtributosRaca.isProficienteAtributo(AtributosEnum.CHA))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CHA, true);
        }
        if(subraca != null) {
            AtributosVO bonusAtributosSubraca = subraca.getBonusEProficienciasAtributos();
            strSoma += bonusAtributosSubraca.getValorAtributo(AtributosEnum.STR);
            dexSoma += bonusAtributosSubraca.getValorAtributo(AtributosEnum.DEX);
            conSoma += bonusAtributosSubraca.getValorAtributo(AtributosEnum.CON);
            intSoma += bonusAtributosSubraca.getValorAtributo(AtributosEnum.INT);
            wisSoma += bonusAtributosSubraca.getValorAtributo(AtributosEnum.WIS);
            chaSoma += bonusAtributosSubraca.getValorAtributo(AtributosEnum.CHA);
            
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.STR)) && bonusAtributosSubraca.isProficienteAtributo(AtributosEnum.STR))
                atributosFinais.setProficienciaAtributo(AtributosEnum.STR, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.DEX)) && bonusAtributosSubraca.isProficienteAtributo(AtributosEnum.DEX))
                atributosFinais.setProficienciaAtributo(AtributosEnum.DEX, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CON)) && bonusAtributosSubraca.isProficienteAtributo(AtributosEnum.CON))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CON, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.INT)) && bonusAtributosSubraca.isProficienteAtributo(AtributosEnum.INT))
                atributosFinais.setProficienciaAtributo(AtributosEnum.INT, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.WIS)) && bonusAtributosSubraca.isProficienteAtributo(AtributosEnum.WIS))
                atributosFinais.setProficienciaAtributo(AtributosEnum.WIS, true);
            if( (!atributosFinais.isProficienteAtributo(AtributosEnum.CHA)) && bonusAtributosSubraca.isProficienteAtributo(AtributosEnum.CHA))
                atributosFinais.setProficienciaAtributo(AtributosEnum.CHA, true);
        }
        
        atributosFinais.setValorAtributo(AtributosEnum.STR, strSoma);
        atributosFinais.setValorAtributo(AtributosEnum.DEX, dexSoma);
        atributosFinais.setValorAtributo(AtributosEnum.CON, conSoma);
        atributosFinais.setValorAtributo(AtributosEnum.INT, intSoma);
        atributosFinais.setValorAtributo(AtributosEnum.WIS, wisSoma);
        atributosFinais.setValorAtributo(AtributosEnum.CHA, chaSoma);

        return atributosFinais;
    }
    private PericiasVO definirProficienciasPericias() {
        PericiasVO pericias = new PericiasVO();
        
        if(personagem != null) {
            PericiasPersonagemVO proficienciasPericiasPersonagem = personagem.getProficienciasPericiasPersonagem();
            if(!pericias.isProficientePericia(PericiasEnum.ATLETISMO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.ATLETISMO))
                pericias.setProficienciaPericia(PericiasEnum.ATLETISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ACROBACIA) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.ACROBACIA))
                pericias.setProficienciaPericia(PericiasEnum.ACROBACIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.FURTIVIDADE) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.FURTIVIDADE))
                pericias.setProficienciaPericia(PericiasEnum.FURTIVIDADE, true);
            if(!pericias.isProficientePericia(PericiasEnum.PRESTIDIGITACAO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.PRESTIDIGITACAO))
                pericias.setProficienciaPericia(PericiasEnum.PRESTIDIGITACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ARCANISMO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.ARCANISMO))
                pericias.setProficienciaPericia(PericiasEnum.ARCANISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.HISTORIA) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.HISTORIA))
                pericias.setProficienciaPericia(PericiasEnum.HISTORIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.INVESTIGACAO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.INVESTIGACAO))
                pericias.setProficienciaPericia(PericiasEnum.INVESTIGACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.NATUREZA) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.NATUREZA))
                pericias.setProficienciaPericia(PericiasEnum.NATUREZA, true);
            if(!pericias.isProficientePericia(PericiasEnum.RELIGIAO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.RELIGIAO))
                pericias.setProficienciaPericia(PericiasEnum.RELIGIAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS))
                pericias.setProficienciaPericia(PericiasEnum.ADESTRAR_ANIMAIS, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTUICAO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.INTUICAO))
                pericias.setProficienciaPericia(PericiasEnum.INTUICAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.MEDICINA) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.MEDICINA))
                pericias.setProficienciaPericia(PericiasEnum.MEDICINA, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERCEPCAO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.PERCEPCAO))
                pericias.setProficienciaPericia(PericiasEnum.PERCEPCAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.SOBREVIVENCIA) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.SOBREVIVENCIA))
                pericias.setProficienciaPericia(PericiasEnum.SOBREVIVENCIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.ATUACAO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.ATUACAO))
                pericias.setProficienciaPericia(PericiasEnum.ATUACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ENGANACAO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.ENGANACAO))
                pericias.setProficienciaPericia(PericiasEnum.ENGANACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTIMIDACAO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.INTIMIDACAO))
                pericias.setProficienciaPericia(PericiasEnum.INTIMIDACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERSUASAO) && proficienciasPericiasPersonagem.isProficientePericia(PericiasEnum.PERSUASAO))
                pericias.setProficienciaPericia(PericiasEnum.PERSUASAO, true);
                
        }
        if(classe != null) {
            PericiasVO proficienciasPericiasClasse = classe.getProficienciasPericias();
            
            if(!pericias.isProficientePericia(PericiasEnum.ATLETISMO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.ATLETISMO))
                pericias.setProficienciaPericia(PericiasEnum.ATLETISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ACROBACIA) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.ACROBACIA))
                pericias.setProficienciaPericia(PericiasEnum.ACROBACIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.FURTIVIDADE) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.FURTIVIDADE))
                pericias.setProficienciaPericia(PericiasEnum.FURTIVIDADE, true);
            if(!pericias.isProficientePericia(PericiasEnum.PRESTIDIGITACAO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.PRESTIDIGITACAO))
                pericias.setProficienciaPericia(PericiasEnum.PRESTIDIGITACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ARCANISMO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.ARCANISMO))
                pericias.setProficienciaPericia(PericiasEnum.ARCANISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.HISTORIA) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.HISTORIA))
                pericias.setProficienciaPericia(PericiasEnum.HISTORIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.INVESTIGACAO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.INVESTIGACAO))
                pericias.setProficienciaPericia(PericiasEnum.INVESTIGACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.NATUREZA) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.NATUREZA))
                pericias.setProficienciaPericia(PericiasEnum.NATUREZA, true);
            if(!pericias.isProficientePericia(PericiasEnum.RELIGIAO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.RELIGIAO))
                pericias.setProficienciaPericia(PericiasEnum.RELIGIAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS))
                pericias.setProficienciaPericia(PericiasEnum.ADESTRAR_ANIMAIS, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTUICAO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.INTUICAO))
                pericias.setProficienciaPericia(PericiasEnum.INTUICAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.MEDICINA) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.MEDICINA))
                pericias.setProficienciaPericia(PericiasEnum.MEDICINA, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERCEPCAO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.PERCEPCAO))
                pericias.setProficienciaPericia(PericiasEnum.PERCEPCAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.SOBREVIVENCIA) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.SOBREVIVENCIA))
                pericias.setProficienciaPericia(PericiasEnum.SOBREVIVENCIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.ATUACAO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.ATUACAO))
                pericias.setProficienciaPericia(PericiasEnum.ATUACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ENGANACAO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.ENGANACAO))
                pericias.setProficienciaPericia(PericiasEnum.ENGANACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTIMIDACAO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.INTIMIDACAO))
                pericias.setProficienciaPericia(PericiasEnum.INTIMIDACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERSUASAO) && proficienciasPericiasClasse.isProficientePericia(PericiasEnum.PERSUASAO))
                pericias.setProficienciaPericia(PericiasEnum.PERSUASAO, true);
        }
        if(subclasse != null) {
            PericiasVO proficienciasPericiasSubclasse = subclasse.getProficienciasPericias();
            
            if(!pericias.isProficientePericia(PericiasEnum.ATLETISMO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.ATLETISMO))
                pericias.setProficienciaPericia(PericiasEnum.ATLETISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ACROBACIA) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.ACROBACIA))
                pericias.setProficienciaPericia(PericiasEnum.ACROBACIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.FURTIVIDADE) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.FURTIVIDADE))
                pericias.setProficienciaPericia(PericiasEnum.FURTIVIDADE, true);
            if(!pericias.isProficientePericia(PericiasEnum.PRESTIDIGITACAO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.PRESTIDIGITACAO))
                pericias.setProficienciaPericia(PericiasEnum.PRESTIDIGITACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ARCANISMO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.ARCANISMO))
                pericias.setProficienciaPericia(PericiasEnum.ARCANISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.HISTORIA) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.HISTORIA))
                pericias.setProficienciaPericia(PericiasEnum.HISTORIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.INVESTIGACAO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.INVESTIGACAO))
                pericias.setProficienciaPericia(PericiasEnum.INVESTIGACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.NATUREZA) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.NATUREZA))
                pericias.setProficienciaPericia(PericiasEnum.NATUREZA, true);
            if(!pericias.isProficientePericia(PericiasEnum.RELIGIAO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.RELIGIAO))
                pericias.setProficienciaPericia(PericiasEnum.RELIGIAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS))
                pericias.setProficienciaPericia(PericiasEnum.ADESTRAR_ANIMAIS, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTUICAO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.INTUICAO))
                pericias.setProficienciaPericia(PericiasEnum.INTUICAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.MEDICINA) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.MEDICINA))
                pericias.setProficienciaPericia(PericiasEnum.MEDICINA, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERCEPCAO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.PERCEPCAO))
                pericias.setProficienciaPericia(PericiasEnum.PERCEPCAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.SOBREVIVENCIA) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.SOBREVIVENCIA))
                pericias.setProficienciaPericia(PericiasEnum.SOBREVIVENCIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.ATUACAO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.ATUACAO))
                pericias.setProficienciaPericia(PericiasEnum.ATUACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ENGANACAO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.ENGANACAO))
                pericias.setProficienciaPericia(PericiasEnum.ENGANACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTIMIDACAO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.INTIMIDACAO))
                pericias.setProficienciaPericia(PericiasEnum.INTIMIDACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERSUASAO) && proficienciasPericiasSubclasse.isProficientePericia(PericiasEnum.PERSUASAO))
                pericias.setProficienciaPericia(PericiasEnum.PERSUASAO, true);
        }
        if(raca != null) {
            PericiasVO proficienciasPericiasRaca = raca.getProficienciasPericias();
            
            if(!pericias.isProficientePericia(PericiasEnum.ATLETISMO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.ATLETISMO))
                pericias.setProficienciaPericia(PericiasEnum.ATLETISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ACROBACIA) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.ACROBACIA))
                pericias.setProficienciaPericia(PericiasEnum.ACROBACIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.FURTIVIDADE) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.FURTIVIDADE))
                pericias.setProficienciaPericia(PericiasEnum.FURTIVIDADE, true);
            if(!pericias.isProficientePericia(PericiasEnum.PRESTIDIGITACAO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.PRESTIDIGITACAO))
                pericias.setProficienciaPericia(PericiasEnum.PRESTIDIGITACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ARCANISMO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.ARCANISMO))
                pericias.setProficienciaPericia(PericiasEnum.ARCANISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.HISTORIA) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.HISTORIA))
                pericias.setProficienciaPericia(PericiasEnum.HISTORIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.INVESTIGACAO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.INVESTIGACAO))
                pericias.setProficienciaPericia(PericiasEnum.INVESTIGACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.NATUREZA) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.NATUREZA))
                pericias.setProficienciaPericia(PericiasEnum.NATUREZA, true);
            if(!pericias.isProficientePericia(PericiasEnum.RELIGIAO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.RELIGIAO))
                pericias.setProficienciaPericia(PericiasEnum.RELIGIAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS))
                pericias.setProficienciaPericia(PericiasEnum.ADESTRAR_ANIMAIS, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTUICAO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.INTUICAO))
                pericias.setProficienciaPericia(PericiasEnum.INTUICAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.MEDICINA) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.MEDICINA))
                pericias.setProficienciaPericia(PericiasEnum.MEDICINA, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERCEPCAO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.PERCEPCAO))
                pericias.setProficienciaPericia(PericiasEnum.PERCEPCAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.SOBREVIVENCIA) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.SOBREVIVENCIA))
                pericias.setProficienciaPericia(PericiasEnum.SOBREVIVENCIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.ATUACAO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.ATUACAO))
                pericias.setProficienciaPericia(PericiasEnum.ATUACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ENGANACAO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.ENGANACAO))
                pericias.setProficienciaPericia(PericiasEnum.ENGANACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTIMIDACAO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.INTIMIDACAO))
                pericias.setProficienciaPericia(PericiasEnum.INTIMIDACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERSUASAO) && proficienciasPericiasRaca.isProficientePericia(PericiasEnum.PERSUASAO))
                pericias.setProficienciaPericia(PericiasEnum.PERSUASAO, true);
        }
        if(subraca != null) {
            PericiasVO proficienciasPericiasSubraca = subraca.getProficienciasPericias();
            
            if(!pericias.isProficientePericia(PericiasEnum.ATLETISMO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.ATLETISMO))
                pericias.setProficienciaPericia(PericiasEnum.ATLETISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ACROBACIA) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.ACROBACIA))
                pericias.setProficienciaPericia(PericiasEnum.ACROBACIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.FURTIVIDADE) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.FURTIVIDADE))
                pericias.setProficienciaPericia(PericiasEnum.FURTIVIDADE, true);
            if(!pericias.isProficientePericia(PericiasEnum.PRESTIDIGITACAO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.PRESTIDIGITACAO))
                pericias.setProficienciaPericia(PericiasEnum.PRESTIDIGITACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ARCANISMO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.ARCANISMO))
                pericias.setProficienciaPericia(PericiasEnum.ARCANISMO, true);
            if(!pericias.isProficientePericia(PericiasEnum.HISTORIA) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.HISTORIA))
                pericias.setProficienciaPericia(PericiasEnum.HISTORIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.INVESTIGACAO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.INVESTIGACAO))
                pericias.setProficienciaPericia(PericiasEnum.INVESTIGACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.NATUREZA) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.NATUREZA))
                pericias.setProficienciaPericia(PericiasEnum.NATUREZA, true);
            if(!pericias.isProficientePericia(PericiasEnum.RELIGIAO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.RELIGIAO))
                pericias.setProficienciaPericia(PericiasEnum.RELIGIAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS))
                pericias.setProficienciaPericia(PericiasEnum.ADESTRAR_ANIMAIS, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTUICAO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.INTUICAO))
                pericias.setProficienciaPericia(PericiasEnum.INTUICAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.MEDICINA) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.MEDICINA))
                pericias.setProficienciaPericia(PericiasEnum.MEDICINA, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERCEPCAO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.PERCEPCAO))
                pericias.setProficienciaPericia(PericiasEnum.PERCEPCAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.SOBREVIVENCIA) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.SOBREVIVENCIA))
                pericias.setProficienciaPericia(PericiasEnum.SOBREVIVENCIA, true);
            if(!pericias.isProficientePericia(PericiasEnum.ATUACAO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.ATUACAO))
                pericias.setProficienciaPericia(PericiasEnum.ATUACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.ENGANACAO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.ENGANACAO))
                pericias.setProficienciaPericia(PericiasEnum.ENGANACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.INTIMIDACAO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.INTIMIDACAO))
                pericias.setProficienciaPericia(PericiasEnum.INTIMIDACAO, true);
            if(!pericias.isProficientePericia(PericiasEnum.PERSUASAO) && proficienciasPericiasSubraca.isProficientePericia(PericiasEnum.PERSUASAO))
                pericias.setProficienciaPericia(PericiasEnum.PERSUASAO, true);
        }
        
        return pericias;
    }
    private ProficienciasVO definirProficiencias() {
        ArmaduraVO[] armaduras;
        LinguagemVO[] linguagens;
        FerramentaVO[] ferramentas;
        ArmaVO[] armas;
        
        final ArrayList<ArmaduraVO> proficienciasArmaduras = new ArrayList();
        final ArrayList<LinguagemVO> proficienciasLinguagens = new ArrayList();
        final ArrayList<FerramentaVO> proficienciasFerramentas = new ArrayList();
        final ArrayList<ArmaVO> proficienciasArmas = new ArrayList();
        
        if(personagem != null) {
            final ProficienciasPersonagemVO proficienciasPersonagem = personagem.getProficienciasPersonagem();
            armaduras = proficienciasPersonagem.getProficienciasArmaduras();
            linguagens = proficienciasPersonagem.getProficienciasLinguagens();
            ferramentas = proficienciasPersonagem.getProficienciasFerramentas();
            armas = proficienciasPersonagem.getProficienciasArmas();
            
            if(armaduras != null)
                proficienciasArmaduras.addAll(Arrays.asList(armaduras));
            if(linguagens!= null)
                proficienciasLinguagens.addAll(Arrays.asList(linguagens));
            if(ferramentas != null)
                proficienciasFerramentas.addAll(Arrays.asList(ferramentas));
            if(armas != null)
                proficienciasArmas.addAll(Arrays.asList(armas));
        }
        if(classe != null) {
            final ProficienciasVO proficienciasClasse = classe.getProficiencias();
            armaduras = proficienciasClasse.getProficienciasArmaduras();
            linguagens = proficienciasClasse.getProficienciasLinguagens();
            ferramentas = proficienciasClasse.getProficienciasFerramentas();
            armas = proficienciasClasse.getProficienciasArmas();
            
            if(armaduras != null)
                proficienciasArmaduras.addAll(Arrays.asList(armaduras));
            if(linguagens!= null)
                proficienciasLinguagens.addAll(Arrays.asList(linguagens));
            if(ferramentas != null)
                proficienciasFerramentas.addAll(Arrays.asList(ferramentas));
            if(armas != null)
                proficienciasArmas.addAll(Arrays.asList(armas));
        }
        if(subclasse != null) {
            final ProficienciasVO proficienciasSubclasse = subclasse.getProficiencias();
            armaduras = proficienciasSubclasse.getProficienciasArmaduras();
            linguagens = proficienciasSubclasse.getProficienciasLinguagens();
            ferramentas = proficienciasSubclasse.getProficienciasFerramentas();
            armas = proficienciasSubclasse.getProficienciasArmas();
            
            if(armaduras != null)
                proficienciasArmaduras.addAll(Arrays.asList(armaduras));
            if(linguagens!= null)
                proficienciasLinguagens.addAll(Arrays.asList(linguagens));
            if(ferramentas != null)
                proficienciasFerramentas.addAll(Arrays.asList(ferramentas));
            if(armas != null)
                proficienciasArmas.addAll(Arrays.asList(armas));
        }
        if(raca != null) {
            final ProficienciasVO proficienciasRaca = raca.getProficiencias();
            armaduras = proficienciasRaca.getProficienciasArmaduras();
            linguagens = proficienciasRaca.getProficienciasLinguagens();
            ferramentas = proficienciasRaca.getProficienciasFerramentas();
            armas = proficienciasRaca.getProficienciasArmas();
            
            if(armaduras != null)
                proficienciasArmaduras.addAll(Arrays.asList(armaduras));
            if(linguagens!= null)
                proficienciasLinguagens.addAll(Arrays.asList(linguagens));
            if(ferramentas != null)
                proficienciasFerramentas.addAll(Arrays.asList(ferramentas));
            if(armas != null)
                proficienciasArmas.addAll(Arrays.asList(armas));
        }
        if(subraca != null) {
            final ProficienciasVO proficienciasSubraca = subraca.getProficiencias();
            armaduras = proficienciasSubraca.getProficienciasArmaduras();
            linguagens = proficienciasSubraca.getProficienciasLinguagens();
            ferramentas = proficienciasSubraca.getProficienciasFerramentas();
            armas = proficienciasSubraca.getProficienciasArmas();
            
            if(armaduras != null)
                proficienciasArmaduras.addAll(Arrays.asList(armaduras));
            if(linguagens!= null)
                proficienciasLinguagens.addAll(Arrays.asList(linguagens));
            if(ferramentas != null)
                proficienciasFerramentas.addAll(Arrays.asList(ferramentas));
            if(armas != null)
                proficienciasArmas.addAll(Arrays.asList(armas));
        }
        if(background != null) {
            final ProficienciasVO proficienciasBackground = background.getProficiencias();
            armaduras = proficienciasBackground.getProficienciasArmaduras();
            linguagens = proficienciasBackground.getProficienciasLinguagens();
            ferramentas = proficienciasBackground.getProficienciasFerramentas();
            armas = proficienciasBackground.getProficienciasArmas();
            
            if(armaduras != null)
                proficienciasArmaduras.addAll(Arrays.asList(armaduras));
            if(linguagens!= null)
                proficienciasLinguagens.addAll(Arrays.asList(linguagens));
            if(ferramentas != null)
                proficienciasFerramentas.addAll(Arrays.asList(ferramentas));
            if(armas != null)
                proficienciasArmas.addAll(Arrays.asList(armas));
        }
        
        return new ProficienciasVO (
                proficienciasArmaduras.toArray(new ArmaduraVO[0]),
                        proficienciasLinguagens.toArray(new LinguagemVO[0]),
                                proficienciasFerramentas.toArray(new FerramentaVO[0]),
                                        proficienciasArmas.toArray(new ArmaVO[0])
                                        );
    }
    private FeatVO[] definirFeats() {
        ArrayList<FeatVO> featsJuntos = new ArrayList<>();
        
        if(personagem != null) {
            FeatVO[] featsPersonagem = personagem.getFeatsPersonagem();
            if(featsPersonagem != null) {
                featsJuntos.addAll(Arrays.asList(featsPersonagem));
            }
        }
        if(classe != null) {
            FeatClasseVO[] featsClasse = classe.getFeatsClasse();
            if(featsClasse != null) {
                for(FeatClasseVO f : featsClasse) {
                    FeatVO feat = new FeatVO(
                            f.getNome(), f.getDescricao(), f.getFonte(), f.getSpells(), f.getBonusEProficienciasAtributos(), f.getProficienciasPericias(), f.getProficiencias()
                    );
                    featsJuntos.add(feat);
                }
            }
        }
        if(subclasse != null) {
            FeatClasseVO[] featsSubclasse = subclasse.getFeatsClasse();
            if(featsSubclasse != null) {
                for(FeatClasseVO f : featsSubclasse) {
                    FeatVO feat = new FeatVO(
                            f.getNome(), f.getDescricao(), f.getFonte(), f.getSpells(), f.getBonusEProficienciasAtributos(), f.getProficienciasPericias(), f.getProficiencias()
                    );
                    featsJuntos.add(feat);
                }
            }
        }
        if(raca != null) {
            FeatRacaVO[] featsRaca = raca.getFeatsRaca();
            if(featsRaca != null) {
                for(FeatRacaVO f : featsRaca) {
                    FeatVO feat = new FeatVO(
                            f.getNome(), f.getDescricao(), f.getFonte(), f.getSpells(), f.getBonusEProficienciasAtributos(), f.getProficienciasPericias(), f.getProficiencias()
                    );
                    featsJuntos.add(feat);
                }
            }
        }
        if(subraca != null) {
            FeatRacaVO[] featsSubraca = subraca.getFeatsRaca();
            if(featsSubraca != null) {
                for(FeatRacaVO f : featsSubraca) {
                    FeatVO feat = new FeatVO(
                            f.getNome(), f.getDescricao(), f.getFonte(), f.getSpells(), f.getBonusEProficienciasAtributos(), f.getProficienciasPericias(), f.getProficiencias()
                    );
                    featsJuntos.add(feat);
                }
            }
        }
        return featsJuntos.toArray(new FeatVO[0]);
        }
    private EquipamentoVO[] definirEquipamentos() {
        ArrayList<EquipamentoVO> equipamentosJuntos = new ArrayList<>();
        
        if(personagem != null) {
            EquipamentoVO[] equipamentosPersonagem = personagem.getInventarioPersonagem();
            if(equipamentosPersonagem != null)
                equipamentosJuntos.addAll(Arrays.asList(equipamentosPersonagem));
        }
        if(background != null) {
            EquipamentoVO[] equipamentosBackground = background.getEquipamento();
            if(equipamentosBackground != null)
                equipamentosJuntos.addAll(Arrays.asList(equipamentosBackground));
        }
        
        return equipamentosJuntos.toArray(new EquipamentoVO[0]);
    }
    public int getPericiaPassiva(PericiasEnum pericia, boolean vantagem, boolean desvantagem) {
        int retorno = 0;
        
        switch(pericia) {
            case ATLETISMO: {
                retorno = 10 + modSTR;
                break;
            }
            case ACROBACIA:
            case FURTIVIDADE:
            case PRESTIDIGITACAO: {
                retorno = 10 + modDEX;
                break;
            }
            case ARCANISMO:
            case HISTORIA:
            case INVESTIGACAO:
            case NATUREZA:
            case RELIGIAO: {
                retorno = 10 + modINT;
                break;
            }
            case ADESTRAR_ANIMAIS:
            case INTUICAO:
            case MEDICINA:
            case PERCEPCAO:
            case SOBREVIVENCIA: {
                retorno = 10 + modWIS;
                break;
            }
            case ATUACAO:
            case ENGANACAO:
            case INTIMIDACAO:
            case PERSUASAO: {
                retorno = 10 + modCHA;
                break;
            }
        }
        
        if(vantagem)
            retorno += 5;
        if(desvantagem)
            retorno -= 5;
        
        return retorno;
                
    }
    public int calcularAC(int bonus, int shield) {return 10 + modDEX + bonus + shield;}
    
    public FichaPersonagem(UsuarioVO usuario, PersonagemVO personagem, ClasseVO classe, SubclasseVO subclasse, RacaVO raca, SubRacaVO subraca, BackgroundVO background, BackstoryVO backstory, DetalhesVO detalhes) {
        // Objetos necessários
        this.usuario = usuario;
        this.personagem = personagem;
        this.imagemPersonagem = this.personagem.getImagemPersonagem();
        this.classe = classe;
        this.subclasse = subclasse;
        this.raca = raca;
        this.subraca = subraca;
        this.background = background;
        this.backstory = backstory;
        this.detalhes = detalhes;
        
        this.valoresEProficienciasDosAtributos = definirValoresEProficienciasAtributos();
        this.proficienciasDasPericias = definirProficienciasPericias();
        this.proficiencias = definirProficiencias();
        this.feats = definirFeats();
        this.equipamentos = definirEquipamentos();
        
        // Cabeçalho 1
        nomePersonagem = this.personagem.getNome();
        nivelPersonagem = this.personagem.getNivel();
        xpPersonagem = this.personagem.getXp();
        nomeUsuario = this.usuario.getNome();
        nomeClasse = this.classe.getNome() + " (" + this.subclasse.getNome() + ")";
        nomeRaca = this.raca.getNome() + " (" + this.subraca.getNome() + ")";
        nomeBackground = this.background.getNome();
        
        // Pontos de Atributo e seus modificadores
        strTotal = this.valoresEProficienciasDosAtributos.getValorAtributo(AtributosEnum.STR);
        dexTotal = this.valoresEProficienciasDosAtributos.getValorAtributo(AtributosEnum.DEX);
        conTotal = this.valoresEProficienciasDosAtributos.getValorAtributo(AtributosEnum.CON);
        intTotal = this.valoresEProficienciasDosAtributos.getValorAtributo(AtributosEnum.INT);
        wisTotal = this.valoresEProficienciasDosAtributos.getValorAtributo(AtributosEnum.WIS);
        chaTotal = this.valoresEProficienciasDosAtributos.getValorAtributo(AtributosEnum.CHA);
        
        modSTR = (int) Math.floor( (strTotal - 10) / 2 );
        modDEX = (int) Math.floor( (dexTotal - 10) / 2 );
        modCON = (int) Math.floor( (conTotal - 10) / 2 );
        modINT = (int) Math.floor( (intTotal - 10) / 2 );
        modWIS = (int) Math.floor( (wisTotal - 10) / 2 );
        modCHA = (int) Math.floor( (chaTotal - 10) / 2 );
        
        // Inspiração
        personagemInspirado = this.personagem.isInspirado();
        
        // Valor do Bônus de Proficiencia
        if(nivelPersonagem <= 4)
            bonusProficienciaPersonagem = 2;
        else if(nivelPersonagem <= 8)
            bonusProficienciaPersonagem = 3;
        else if(nivelPersonagem <= 12)
            bonusProficienciaPersonagem = 4;
        else if(nivelPersonagem <= 16)
            bonusProficienciaPersonagem = 5;
        else
            bonusProficienciaPersonagem = 6;
        
        // Saving Throws e suas proficiencias
        proficienciasSaves = new boolean[] {
            this.valoresEProficienciasDosAtributos.isProficienteAtributo(AtributosEnum.STR),
            this.valoresEProficienciasDosAtributos.isProficienteAtributo(AtributosEnum.DEX),
            this.valoresEProficienciasDosAtributos.isProficienteAtributo(AtributosEnum.CON),
            this.valoresEProficienciasDosAtributos.isProficienteAtributo(AtributosEnum.INT),
            this.valoresEProficienciasDosAtributos.isProficienteAtributo(AtributosEnum.WIS),
            this.valoresEProficienciasDosAtributos.isProficienteAtributo(AtributosEnum.CHA)
        };
        valoresSaves = new int[] {
            modSTR,
            modDEX,
            modCON,
            modINT,
            modWIS,
            modCHA
        };
        for(int i = 0; i < 6; i++) {
            if(proficienciasSaves[i])
                valoresSaves[i] += bonusProficienciaPersonagem;
        }
        
        // Skills e suas proficiencias
        proficienciasSkills = new boolean[] {
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.ATLETISMO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.ACROBACIA),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.FURTIVIDADE),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.PRESTIDIGITACAO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.ARCANISMO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.HISTORIA),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.INVESTIGACAO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.NATUREZA),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.RELIGIAO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.ADESTRAR_ANIMAIS),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.INTUICAO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.MEDICINA),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.PERCEPCAO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.SOBREVIVENCIA),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.ATUACAO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.ENGANACAO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.INTIMIDACAO),
            this.proficienciasDasPericias.isProficientePericia(PericiasEnum.PERSUASAO)
        };
        nomesSkills = PericiasEnum.getNomesPericiasPT();
        
        // Sentidos
        for(FeatVO f : feats) {
            if(f.getNome().equals("Darkvision"))
                buffsSentido = f.getNome() + "\n" + f.getDescricao();
        }
        
        // Iniciativa:

        
        // Defesas

        
        // Valor do Save de Habilidade de classe

        
        // Velocidade

        
        // Hit Point Máximo e Atual

        
        // Hit Points Temporários

        
        // Hit Dice

        
        // Death saves

        
        // Proficiencias e Linguagens

        
        // Ações

        
        // Ataques com Armas

        
        // Features & Traits

        
        // Equipamento

        
        // Cabeçalho 2 (Detalhes do Personagem)
        
        
        // Aparência do Personagem

        
        // Aliados e Organizações

        
        // Traços de Personalidade

        
        // Ideais

        
        // Laços

        
        // Pontos Fracos

        
        // Backstory do Personagem

        
        // Anotações Extras
        
        
        //Cabeçalho 3 (Spells)
        //- Classe de Spellcaster
        //- Atributo Principal do Spellcaster
        //- Valor do Save de Spell

        
        //Lista de Spells
        
    }
    
    
}
