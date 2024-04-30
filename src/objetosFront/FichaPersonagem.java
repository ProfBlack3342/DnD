/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosFront;

import enums.AtributosEnum;
import enums.PericiasEnum;
import modelo.*;

/**
 *
 * @author 181700271
 */
public class FichaPersonagem
{
    // Objetos necessários
    private final UsuarioVO usuario;
    private final PersonagemVO personagem;
    private final ImagemVO imagemPersonagem;
    private final AtributosVO habilidadesPersonagem;
    private final PericiasVO proficienciasSkillPersonagem;
    private final ClasseVO classe;
    private final SubclasseVO subclasse;
    private final RacaVO raca;
    private final SubRacaVO subraca;
    private final BackgroundVO background;
    private final BackstoryVO backstory;
    private final DetalhesPersonagemVO detalhes;
    
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
    
    // Armor Class
    // - Sem armor -> 10 + modificador de DEX + bônus(Spell, Trait, etc.) + shield
    // - Com armor -> AC da armadura + shield
    
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

    
    public FichaPersonagem(UsuarioVO usuario, PersonagemVO personagem, ImagemVO imagemPersonagem, AtributosVO habilidadesPersonagem, PericiasVO proficienciasSkillPersonagem, ClasseVO classe, SubclasseVO subclasse, RacaVO raca, SubRacaVO subraca, BackgroundVO background, BackstoryVO backstory, DetalhesPersonagemVO detalhes) {
        // Objetos necessários
        this.usuario = usuario;
        this.personagem = personagem;
        this.imagemPersonagem = imagemPersonagem;
        this.habilidadesPersonagem = habilidadesPersonagem;
        this.proficienciasSkillPersonagem = proficienciasSkillPersonagem;
        this.classe = classe;
        this.subclasse = subclasse;
        this.raca = raca;
        this.subraca = subraca;
        this.background = background;
        this.backstory = backstory;
        this.detalhes = detalhes;
        
        // Cabeçalho 1
        nomePersonagem = this.personagem.getNome();
        nivelPersonagem = this.personagem.getNivel();
        xpPersonagem = this.personagem.getXp();
        nomeUsuario = this.usuario.getNome();
        nomeClasse = this.classe.getNome() + " (" + this.subclasse.getNome() + ")";
        nomeRaca = this.raca.getNome() + " (" + this.subraca.getNome() + ")";
        nomeBackground = this.background.getNome();
        
        // Pontos de Atributo e seus modificadores
        strTotal = this.habilidadesPersonagem.getValorAtributoPersonagem(AtributosEnum.STR) + this.raca.getBonusSTR();
        dexTotal = this.habilidadesPersonagem.getValorAtributoPersonagem(AtributosEnum.DEX) + this.raca.getBonusDEX();
        conTotal = this.habilidadesPersonagem.getValorAtributoPersonagem(AtributosEnum.CON) + this.raca.getBonusCON();
        intTotal = this.habilidadesPersonagem.getValorAtributoPersonagem(AtributosEnum.INT) + this.raca.getBonusINT();
        wisTotal = this.habilidadesPersonagem.getValorAtributoPersonagem(AtributosEnum.WIS) + this.raca.getBonusWIS();
        chaTotal = this.habilidadesPersonagem.getValorAtributoPersonagem(AtributosEnum.CHA) + this.raca.getBonusCHA();
        modSTR = (int) Math.floor( (strTotal - 10) / 2 );
        modDEX = (int) Math.floor( (dexTotal - 10) / 2 );
        modCON = (int) Math.floor( (conTotal - 10) / 2 );
        modINT = (int) Math.floor( (intTotal - 10) / 2 );
        modWIS = (int) Math.floor( (wisTotal - 10) / 2 );
        modCHA = (int) Math.floor( (chaTotal - 10) / 2 );
        
        // Inspiração
        personagemInspirado = this.personagem.isInspirado();
        
        // Valor do Bônus de Proficiencia
        bonusProficienciaPersonagem = this.personagem.getBonusProficiencia();
        
        // Saving Throws e suas proficiencias
        proficienciasSaves = new boolean[] {
            this.habilidadesPersonagem.getProficienciaAtributo(AtributosEnum.STR),
            this.habilidadesPersonagem.getProficienciaAtributo(AtributosEnum.DEX),
            this.habilidadesPersonagem.getProficienciaAtributo(AtributosEnum.CON),
            this.habilidadesPersonagem.getProficienciaAtributo(AtributosEnum.INT),
            this.habilidadesPersonagem.getProficienciaAtributo(AtributosEnum.WIS),
            this.habilidadesPersonagem.getProficienciaAtributo(AtributosEnum.CHA)
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
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.ATLETISMO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.ACROBACIA),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.FURTIVIDADE),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.PRESTIDIGITACAO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.ARCANISMO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.HISTORIA),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.INVESTIGACAO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.NATUREZA),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.RELIGIAO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.ADESTRAR_ANIMAIS),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.INTUICAO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.MEDICINA),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.PERCEPCAO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.SOBREVIVENCIA),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.ATUACAO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.ENGANACAO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.INTIMIDACAO),
            this.proficienciasSkillPersonagem.getProficienciaPericia(PericiasEnum.PERSUASAO)
        };
        nomesSkills = PericiasEnum.getNomesPossiveis();
        
        // Sentidos

        
        // Armor Class

        
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
