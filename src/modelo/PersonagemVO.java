/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import utilidades.Converter;

/**
 *
 * @author 181700271
 */
public final class PersonagemVO extends ObjetoVO
{
    private int nivel;
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;
    private RacaVO raca;
    private SubRacaVO subRaca;
    private final AtaquesESpellsVO ataquesESpells;
    private final ArrayList<LinguagemVO> listaLinguagensAprendidas;
    private LinguagemVO[] listaTodasLinguagens;
    private int strTotal, dexTotal, conTotal, intTotal, wisTotal, chaTotal;
    private int modStr, modDex, modCon, modInt, modWis, modCha;
    private final SkillVO skills;
    private ClasseVO classe;
    private SubClasseVO subClasse;
    private ArrayList<Integer> HitPoints;
    private ArrayList<EquipamentoVO> listaEquipamentos;
    private BackgroundPersonagemVO backgroundPersonagem;
    private ArrayList<FeatureVO> listaFeats;
    private BackstoryPersonagemVO backstoryPersonagem;
    private DescricaoPersonagemVO descricaoPersonagem;
    
    public PersonagemVO() {
        this.nivel = 1;
        this.raca = null;
        this.subRaca = null;
        this.ataquesESpells = null;
        this.listaLinguagensAprendidas = new ArrayList();
        this.skills = null;
        this.classe = null;
        this.subClasse = null;
        this.HitPoints = new ArrayList();
        this.listaEquipamentos = new  ArrayList();
        this.backgroundPersonagem = null;
        this.listaFeats = new ArrayList();
        this.backstoryPersonagem = null;
        this.descricaoPersonagem = null;
    }
    public PersonagemVO(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.nivel = 1;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.raca = null;
        this.subRaca = null;
        this.ataquesESpells = null;
        this.listaLinguagensAprendidas = new ArrayList();
        this.skills = null;
        this.classe = null;
        this.subClasse = null;
        this.HitPoints = new ArrayList();
        this.listaEquipamentos = new  ArrayList();
        this.backgroundPersonagem = null;
        this.listaFeats = new ArrayList();
        this.backstoryPersonagem = null;
        this.descricaoPersonagem = null;
    }
    
    // Nivel
    public int getNivel() { return nivel;}
    public void setNivel(int nivel) {this.nivel = nivel;}
    
    // Atributos base (Strength, dexterity, constitution, intelligence, wisdom, charisma)
    public int getStrength() {return strength;}
    public void setStrength(int strength) {this.strength = strength; setStrTotal();}
    public int getDexterity() {return dexterity;}
    public void setDexterity(int dexterity) {this.dexterity = dexterity; setDexTotal();}
    public int getConstitution() {return constitution;}
    public void setConstitution(int constitution) {this.constitution = constitution; setConTotal();}
    public int getIntelligence() {return intelligence;}
    public void setIntelligence(int intelligence) {this.intelligence = intelligence; setIntTotal();}
    public int getWisdom() {return wisdom;}
    public void setWisdom(int wisdom) {this.wisdom = wisdom; setWisTotal();}
    public int getCharisma() {return charisma;}
    public void setCharisma(int charisma) {this.charisma = charisma; setChaTotal();}
    
    // Raça
    public RacaVO getRaca() {return raca;}
    public void setRaca(RacaVO raca) {
        this.raca = raca;
        atualizarListaTodasLinguagens();
    }
    
    // SubRaça
    public SubRacaVO getSubRaca() {return subRaca;}
    public void setSubRaca(SubRacaVO subRaca) {
        this.subRaca = subRaca;
        atualizarListaTodasLinguagens();
    }

    // Ataques & Spells
    public AtaquesESpellsVO getAtaquesESpells() {return ataquesESpells;}

    // Linguagens Aprendidas
    public ArrayList<LinguagemVO> GetListaLinguagensAprendidas() { return listaLinguagensAprendidas;}
    public void addLinguagemAprendida(LinguagemVO linguagem) {
        listaLinguagensAprendidas.add(linguagem);
        atualizarListaTodasLinguagens();
    }
    public void removeLinguagemAprendida(int indice) {
        listaLinguagensAprendidas.remove(indice);
        atualizarListaTodasLinguagens();
    }
    public void zerarListaLinguagensAprendidas() {
        listaLinguagensAprendidas.clear();
        atualizarListaTodasLinguagens();
    }
    
    // Todas as Linguagens Conhecidas pelo Personagem (Aprendidas + linguas de raça e background)
    public LinguagemVO[] getListaTodasLinguagens() {
        return listaTodasLinguagens;
    }
    private void atualizarListaTodasLinguagens() {
        LinguagemVO[] linguagensRaca = raca.getLinguagensRaca();
        LinguagemVO[] linguagensSubRaca = subRaca.getLinguagensRaca();
        LinguagemVO[] linguagensBackground = backgroundPersonagem.getLinguagensBackground();
        ArrayList<LinguagemVO> listaLinguagens = new ArrayList<>();
        
        if( !(listaLinguagensAprendidas.isEmpty()) )
            listaLinguagens.addAll(listaLinguagensAprendidas);
        if(linguagensRaca.length != 0)
            listaLinguagens.addAll(Arrays.asList(linguagensRaca));
        if(linguagensSubRaca.length != 0)
            listaLinguagens.addAll(Arrays.asList(linguagensSubRaca));
        if(linguagensBackground.length != 0)
            listaLinguagens.addAll(Arrays.asList(linguagensBackground));
        
        if(listaLinguagens.isEmpty()) {
            listaTodasLinguagens = null;
        }
        else {
            int tamanho = listaLinguagens.size();
            listaTodasLinguagens = new LinguagemVO[tamanho];
            for(int i = 0; i < tamanho; i++) {
                listaTodasLinguagens[i] = listaLinguagens.get(i);
            }
        }
    }
    
    // Atributos base + buffs de raça e subraça
    public int getStrTotal() {return strTotal;}
    public void setStrTotal() {
        strTotal = strength;
        
        if(raca != null)  {
            strTotal += raca.getBonusStr();
            if(subRaca != null) {
                strTotal += subRaca.getBonusStr();
            }
        }
        
        setModStr();
    }
    public int getDexTotal() {return dexTotal;}
    public void setDexTotal() {
        dexTotal = dexterity;
        
        if(raca != null) {
            dexTotal+= raca.getBonusDex();
            if(subRaca != null) {
                dexTotal+= subRaca.getBonusDex();
            }
        }
        
        setModDex();
    }
    public int getConTotal() {return conTotal;}
    public void setConTotal() {
        conTotal = constitution;
        
        if(raca != null) {
            conTotal += raca.getBonusCon();
            if(subRaca != null) {
                conTotal += subRaca.getBonusCon();
            }
        }
        
        setModCon();
    }
    public int getIntTotal() {return intTotal;}
    public void setIntTotal() {
        intTotal = intelligence;
        
        if(raca != null) {
            intTotal += raca.getBonusInt();
            if(subRaca != null) {
                intTotal += subRaca.getBonusInt();
            }
        }
        
        setModInt();
    }
    public int getWisTotal() {return wisTotal;}
    public void setWisTotal() {
        wisTotal = wisdom;
        
        if(raca != null) {
            wisTotal += raca.getBonusWis();
            if(subRaca != null) {
                wisTotal += subRaca.getBonusWis();
            }
        }
        
        setModWis();
    }
    public int getChaTotal() {return chaTotal;}
    public void setChaTotal() {
        chaTotal = charisma;
        
        if(raca != null) {
            chaTotal += raca.getBonusCha();
            if(subRaca != null) {
                chaTotal += subRaca.getBonusCha();
            }
        }
        
        setModCha();
    }
    
    //Modificadores dos Atributos com buffs
    public int getModStr() {return modStr;}
    public void setModStr() {
        modStr = Converter.converterScoreEmModificador(strTotal);
        skills.setAtletismo(modStr);
    }
    public int getModDex() {return modDex;}
    public void setModDex() {
        modDex = Converter.converterScoreEmModificador(dexTotal);
        skills.setAcrobacia(modDex);
        skills.setFurtividade(modDex);
        skills.setPrestidigitacao(modDex);
    }
    public int getModCon() {return modCon;}
    public void setModCon() {
        modCon = Converter.converterScoreEmModificador(conTotal);
    }
    public int getModInt() {return modInt;}
    public void setModInt() {
        modInt = Converter.converterScoreEmModificador(intTotal);
        skills.setArcanismo(modInt);
        skills.setHistoria(modInt);
        skills.setInvestigacao(modInt);
        skills.setNatureza(modInt);
        skills.setReligiao(modInt);
    }
    public int getModWis() {return modWis;}
    public void setModWis() {
        modWis = Converter.converterScoreEmModificador(wisTotal);
        skills.setAdestrarAnimais(modWis);
        skills.setIntuicao(modWis);
        skills.setMedicina(modWis);
        skills.setPercepcao(modWis);
        skills.setSobrevivencia(modWis);
    }
    public int getModCha() {return modCha;}
    public void setModCha() {
        modCha = Converter.converterScoreEmModificador(chaTotal);
        skills.setAtuacao(modCha);
        skills.setEnganacao(modCha);
        skills.setIntimidacao(modCha);
        skills.setPersuasao(modCha);
    }
    
    // Lista de skills e suas proficiencias
    public SkillVO getSkills() { return skills;}
    
    // Classe ############
    public ClasseVO getClasse() {return classe;}
    public void setClasse(ClasseVO classe) {
        this.classe = classe;
    }
    
    // SubClasse ############
    public SubClasseVO getSubClasse() {return subClasse;}
    public void setSubClasse(SubClasseVO subClasseVO) {
        this.subClasse = subClasseVO;
    }

    // Hit Points ############
    public ArrayList<Integer> getHitPoints() {
        return HitPoints;
    }
    public int[] getHitPointsAsArray() {
        int[] retorno = new int[HitPoints.size()];
        for(int i = 0; i < retorno.length; i++) {
            retorno[i] = HitPoints.get(i);
        }
        return retorno;
    }
    public int getSomaHitPoints() {
        int somaHitPoints = 0;
        
        for(Integer i : HitPoints) {
            somaHitPoints += i;
        }
        
        return somaHitPoints;
    }
    public void setHitPoints(ArrayList<Integer> HitPoints) {this.HitPoints = HitPoints;}
    public void setHitPoints(int[] HitPoints) {
        ArrayList<Integer> novaLista = new ArrayList();
        
        for(int i : HitPoints) {
            novaLista.add(i);
        }
        
        this.HitPoints = novaLista;
    }
    
    // Lista de equipamentos ############
    public ArrayList<EquipamentoVO> getListaEquipamentos() {
        return listaEquipamentos;
    }
    public void setListaEquipamentos(ArrayList<EquipamentoVO> listaEquipamentos) {
        this.listaEquipamentos = listaEquipamentos;
    }
    
    // Background do Personagem ############
    public BackgroundPersonagemVO getBackgroundPersonagem() {
        return backgroundPersonagem;
    }
    public void setBackgroundPersonagem(BackgroundPersonagemVO backgroundPersonagem) {
        this.backgroundPersonagem = backgroundPersonagem;
        atualizarListaTodasLinguagens();
    }

    //Lista de Feats ############
    public ArrayList<FeatureVO> getListaFeats() {
        return listaFeats;
    }
    public void setListaFeats(ArrayList<FeatureVO> listaFeats) {
        this.listaFeats = listaFeats;
    }

    // Backstory do Personagem
    public BackstoryPersonagemVO getBackstoryPersonagem() {
        return backstoryPersonagem;
    }
    public void setBackstoryPersonagem(BackstoryPersonagemVO backstoryPersonagem) {
        this.backstoryPersonagem = backstoryPersonagem;
    }

    //Descrição do Personagem
    public DescricaoPersonagemVO getDescricaoPersonagem() {
        return descricaoPersonagem;
    }
    public void setDescricaoPersonagem(DescricaoPersonagemVO descricaoPersonagem) {
        this.descricaoPersonagem = descricaoPersonagem;
    }
}