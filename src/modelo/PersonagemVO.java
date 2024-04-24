/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import exception.ForbiddenValueException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 181700271
 */
public final class PersonagemVO extends ObjetoVO
{
    private String nome;
    private int nivel;
    private int xp;
    private ImagemVO imagem;
    
    private RacaVO raca;
    private ClasseVO classe;
    private BackgroundVO background;
    
    private boolean inspirado;
    private int strBase, bonusStrNivel, bonusStrExtra, strTotal, strMod;
    private int dexBase, bonusDexNivel, bonusDexExtra, dexTotal, dexMod;
    private int conBase, bonusConNivel, bonusConExtra, conTotal, conMod;
    private int intBase, bonusIntNivel, bonusIntExtra, intTotal, intMod;
    private int wisBase, bonusWisNivel, bonusWisExtra, wisTotal, wisMod;
    private int chaBase, bonusChaNivel, bonusChaExtra, chaTotal, chaMod;
    
    private final ArrayList<EquipamentoVO> equipamentos;
    private final ArrayList<ProficienciaArmaVO> proficienciasArma;
    private final ArrayList<ProficienciaArmaduraVO> proficienciasArmadura;
    private final ArrayList<ProficienciaFerramentaVO> proficienciasFerramenta;
    private final ArrayList<ProficienciaLinguagemVO> proficienciasLinguagem;
    private final ArrayList<ProficienciaSaveVO> proficienciasSave;
    private final ArrayList<ProficienciaSkillVO> proficienciasSkill;
    private final ArrayList<FeatVO> feats;
    
    private DetalhesPersonagemVO detalhes;
    private BackstoryVO backstory;
    
    
    public PersonagemVO() {
        this.nome = "Escolha um Nome";
        this.nivel = 1;
        this.xp = 0;
        this.imagem = null;
        this.raca = null;
        this.classe = null;
        this.background = null;
        this.inspirado = false;
        this.strBase = -1;
        this.dexBase = -1;
        this.conBase = -1;
        this.intBase = -1;
        this.wisBase = -1;
        this.chaBase = -1;
        this.equipamentos = new ArrayList<>();
        this.feats = new ArrayList<>();
        this.proficienciasArma  = new ArrayList<>();
        this.proficienciasArmadura = new ArrayList<>();
        this.proficienciasFerramenta = new ArrayList<>();
        this.proficienciasLinguagem = new ArrayList<>();
        this.proficienciasSave = new ArrayList<>();
        this.proficienciasSkill = new ArrayList<>();
        this.detalhes = new DetalhesPersonagemVO();
        this.backstory = new BackstoryVO();
    }
    

    

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public int getNivel() {return nivel;}
    public void setNivel(int nivel) {
        this.nivel = nivel;
        setXpPeloNivel(this.nivel);
    }
    public void setNivelPeloXp(int xp) {
        if(xp < 300)
            nivel = 1;
        else if(xp < 900)
            nivel = 2;
        else if(xp < 2700)
            nivel = 3;
        else if(xp < 6500)
            nivel = 4;
        else if(xp < 14000)
            nivel = 5;
        else if(xp < 23000)
            nivel = 6;
        else if(xp < 34000)
            nivel = 7;
        else if(xp < 48000)
            nivel = 8;
        else if(xp < 64000)
            nivel = 9;
        else if(xp < 85000)
            nivel = 10;
        else if(xp < 100000)
            nivel = 11;
        else if(xp < 120000)
            nivel = 12;
        else if(xp < 140000)
            nivel = 13;
        else if(xp < 165000)
            nivel = 14;
        else if(xp < 195000)
            nivel = 15;
        else if(xp < 225000)
            nivel = 16;
        else if(xp < 265000)
            nivel = 17;
        else if(xp < 305000)
            nivel = 18;
        else if(xp < 355000)
            nivel = 19;
        else
            nivel = 20;
        
    }

    public int getXp() {return xp;}
    public void setXp(int xp) {
        this.xp = xp;
        setNivelPeloXp(this.xp);
    }
    public void setXpPeloNivel(int nivel) {
        switch(nivel) {
            case 1:
            {
                xp = 0;
                break;
            }
            case 2:
            {
                xp = 300;
                break;
            }
            case 3:
            {
                xp = 900;
                break;
            }
            case 4:
            {
                xp = 2700;
                break;
            }
            case 5:
            {
                xp = 6500;
                break;
            }
            case 6:
            {
                xp = 14000;
                break;
            }
            case 7:
            {
                xp = 23000;
                break;
            }
            case 8:
            {
                xp = 34000;
                break;
            }
            case 9:
            {
                xp = 48000;
                break;
            }
            case 10:
            {
                xp = 64000;
                break;
            }
            case 11:
            {
                xp = 85000;
                break;
            }
            case 12:
            {
                xp = 100000;
                break;
            }
            case 13:
            {
                xp = 120000;
                break;
            }
            case 14:
            {
                xp = 140000;
                break;
            }
            case 15:
            {
                xp = 165000;
                break;
            }
            case 16:
            {
                xp = 195000;
                break;
            }
            case 17:
            {
                xp = 225000;
                break;
            }
            case 18:
            {
                xp = 265000;
                break;
            }
            case 19:
            {
                xp = 305000;
                break;
            }
            case 20:
            {
                xp = 355000;
                break;
            }
        }
    }

    public ImagemVO getImagem() {return imagem;}
    public void setImagem(ImagemVO imagem) {this.imagem = imagem;}

    public RacaVO getRaca() {return raca;}
    public void setRaca(RacaVO raca) {this.raca = raca;}

    public ClasseVO getClasse() {return classe;}
    public void setClasse(ClasseVO classe) {this.classe = classe;}
    
    public BackgroundVO getBackground() {return background;}
    public void setBackground(BackgroundVO background) {this.background = background;}
    
    public boolean isInspirado() {return inspirado;}
    public void setInspirado(boolean inspirado) {this.inspirado = inspirado;}
    
    public int getStrBase() {return strBase;}
    public void setStrBase(int strBase) throws ForbiddenValueException  {
            if(strBase >= -1) {
                this.strBase = strBase;
                setStrTotal();
            }
            else
                throw new ForbiddenValueException("Erro em PersonagemVO.getStrBase: Valores de STR devem ser maiores ou iguais a -1!");
    }
    
    public int getBonusStrNivel() {return bonusStrNivel;}
    public void setBonusStrNivel(int bonusStrNivel) {this.bonusStrNivel = bonusStrNivel;}
    
    public int getBonusStrExtra() {return bonusStrExtra;}
    public void setBonusStrExtra(int bonusStrExtra) {this.bonusStrExtra = bonusStrExtra;}
    
    public int getStrTotal(){  
        if(strBase != -1)
            return strTotal;
        else
            return 0; 
    }
    private void setStrTotal() {
        if(raca != null)
            strTotal = raca.getBonusStr() + bonusStrNivel + bonusStrExtra;
        else
            strTotal = bonusStrNivel + bonusStrExtra;
        
        setStrMod();
    }
    
    public int getStrMod() {
        if(strTotal != -1)
            return strMod;
        else
            return 0;
    }
    private void setStrMod() {
        strMod = (int) Math.floor( (strTotal - 10) / 2 );
    }

    public int getDexBase() {return dexBase;}
    public void setDexBase(int dexBase) throws ForbiddenValueException {
            if(dexBase >= -1) {
                this.dexBase = dexBase;
                setDexTotal();
            }
            else
                throw new ForbiddenValueException("Erro em PersonagemVO.setDexBase: Valores de DEX devem ser maiores ou iguais a -1!");
    }
    
    public int getBonusDexNivel() {return bonusDexNivel;}
    public void setBonusDexNivel(int bonusDexNivel) {this.bonusDexNivel = bonusDexNivel;}
    
    public int getBonusDexExtra() {return bonusDexExtra;}
    public void setBonusDexExtra(int bonusDexExtra) {this.bonusDexExtra = bonusDexExtra;}
    
    public int getDexTotal() {
        if(dexBase != -1)
            return dexTotal;
        else
            return 0;
    }
    private void setDexTotal() {
        if(raca != null)
            dexTotal = raca.getBonusDex()+ bonusDexNivel + bonusDexExtra;
        else
            dexTotal = bonusDexNivel + bonusDexExtra;
        
        setDexMod();
    }
    
    public int getDexMod() {
        if(dexBase != -1)
            return dexMod;
        else
            return 0;
    }
    private void setDexMod() {
        dexMod = (int) Math.floor( (dexTotal - 10) / 2 );
    }

    public int getConBase() {return conBase;}
    public void setConBase(int conBase) throws ForbiddenValueException {
        if(conBase >= -1) {
                this.conBase = conBase;
                setConTotal();
            }
            else
                throw new ForbiddenValueException("Erro em PersonagemVO.getConBase: Valores de CON devem ser maiores ou iguais a -1!");
    }
    
    public int getBonusConNivel() {return bonusConNivel;}
    public void setBonusConNivel(int bonusConNivel) {this.bonusConNivel = bonusConNivel;}
    
    public int getBonusConExtra() {return bonusConExtra;}
    public void setBonusConExtra(int bonusConExtra) {this.bonusConExtra = bonusConExtra;}
    
    public int getConTotal() {
        if(conBase != -1)
            return conTotal;
        else
            return 0;
    }
    private void setConTotal() {
        if(raca != null)
            conTotal = raca.getBonusCon()+ bonusConNivel + bonusConExtra;
        else
            conTotal = bonusConNivel + bonusConExtra;
        
        setConMod();
    }
    
    public int getConMod() {
        if(conBase != -1)
            return conMod;
        else
            return 0;
    }
    private void setConMod() {
        conMod = (int) Math.floor( (conTotal - 10) / 2 );
    }

    public int getIntBase() {return intBase;}
    public void setIntBase(int intBase) throws ForbiddenValueException {
        if(intBase >= -1) {
                this.intBase = intBase;
                setIntTotal();
            }
            else
                throw new ForbiddenValueException("Erro em PersonagemVO.getIntBase: Valores de INT devem ser maiores ou iguais a -1!");
    }
    
    public int getBonusIntNivel() {return bonusIntNivel;}
    public void setBonusIntNivel(int bonusIntNivel) {this.bonusIntNivel = bonusIntNivel;}
    
    public int getBonusIntExtra() {return bonusIntExtra;}
    public void setBonusIntExtra(int bonusIntExtra) {this.bonusIntExtra = bonusIntExtra;}
    
    public int getIntTotal() {
        if(intBase != -1)
            return intTotal;
        else
            return 0;
    }
    private void setIntTotal() {
        if(raca != null)
            intTotal = raca.getBonusInt()+ bonusIntNivel + bonusIntExtra;
        else
            intTotal = bonusIntNivel + bonusIntExtra;
        
        setIntMod();
    }
    
    public int getIntMod() {
        if(intBase != -1)
            return intMod;
        else
            return 0;
    }
    private void setIntMod() {
        intMod = (int) Math.floor( (intTotal - 10) / 2 );
    }

    public int getWisBase() {return wisBase;}
    public void setWisBase(int wisBase) throws ForbiddenValueException {
        if(wisBase >= -1) {
                this.wisBase = wisBase;
                setWisTotal();
            }
            else
                throw new ForbiddenValueException("Erro em PersonagemVO.getWisBase: Valores de WIS devem ser maiores ou iguais a -1!");
    }
    
    public int getBonusWisNivel() {return bonusWisNivel;}
    public void setBonusWisNivel(int bonusWisNivel) {this.bonusWisNivel = bonusWisNivel;}
    
    public int getBonusWisExtra() {return bonusWisExtra;}
    public void setBonusWisExtra(int bonusWisExtra) {this.bonusWisExtra = bonusWisExtra;}
    
    public int getWisTotal() {
        if(wisBase != -1)
            return wisTotal;
        else
            return 0;
    }
    private void setWisTotal() {
        if(raca != null)
            wisTotal = raca.getBonusWis()+ bonusWisNivel + bonusWisNivel;
        else
            wisTotal = bonusWisNivel + bonusWisNivel;
        
        setWisMod();
    }
    
    public int getWisMod() {
        if(wisBase != -1)
            return wisMod;
        else
            return 0;
    }
    private void setWisMod() {
        wisMod = (int) Math.floor( (wisTotal - 10) / 2 );
    }

    public int getChaBase() {return chaBase;}
    public void setChaBase(int chaBase) throws ForbiddenValueException {
        if(chaBase >= -1) {
                this.chaBase = chaBase;
                setChaTotal();
            }
            else
                throw new ForbiddenValueException("Erro em PersonagemVO.getChaBase: Valores de CHA devem ser maiores ou iguais a -1!");
    }
    
    public int getBonusChaNivel() {return bonusChaNivel;}
    public void setBonusChaNivel(int bonusChaNivel) {this.bonusChaNivel = bonusChaNivel;}
    
    public int getBonusChaExtra() {return bonusChaExtra;}
    public void setBonusChaExtra(int bonusChaExtra) {this.bonusChaExtra = bonusChaExtra;}
    
    public int getChaTotal() {
        if(chaBase != -1)
            return chaTotal;
        else
            return 0;
    }
    private void setChaTotal() {
        if(raca != null)
            chaTotal = raca.getBonusCha()+ bonusChaNivel + bonusChaExtra;
        else
            chaTotal = bonusChaNivel + bonusChaExtra;
        setChaMod();
    }
    
    public int getChaMod() {
        if(chaBase != -1)
            return chaMod;
        else
            return 0;
    }
    private void setChaMod() {
        chaMod = (int) Math.floor( (chaTotal - 10) / 2 );
    }
    
    public FeatVO[] getFeats() {
        int tamanho = feats.size();
        FeatVO[] retorno = new FeatVO[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            retorno[i] = feats.get(i);
        }
        
        return retorno;
    }
    public void setFeats(FeatVO[] feats) {
        this.feats.clear();
        this.feats.addAll(Arrays.asList(feats));
    }
    public void setFeats(ArrayList<FeatVO> feats) {
        this.feats.clear();
        this.feats.addAll(feats);
    }
    public void adicionarFeat(FeatVO feat) {feats.add(feat);}
    public void removerFeat(int indice) {feats.remove(indice);}
    
    public EquipamentoVO[] getEquipamentos() {
        int tamanho = equipamentos.size();
        EquipamentoVO[] retorno = new EquipamentoVO[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            retorno[i] = equipamentos.get(i);
        }
        
        return retorno;
    }
    public void setEquipamentos(EquipamentoVO[] equipamentos) {
        this.equipamentos.clear();
        this.equipamentos.addAll(Arrays.asList(equipamentos));
    }
    public void setEquipamentos(ArrayList<EquipamentoVO> equipamentos) {
        this.equipamentos.clear();
        this.equipamentos.addAll(equipamentos);
    }
    public void adicionarEquipamento(EquipamentoVO equipamento) {equipamentos.add(equipamento);}
    public void removerEquipamento(int indice) throws IndexOutOfBoundsException {equipamentos.remove(indice);}

    public ProficienciaArmaVO[] getProficienciasArma() {
        int tamanho = proficienciasArma.size();
        ProficienciaArmaVO[] retorno = new ProficienciaArmaVO[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            retorno[i] = proficienciasArma.get(i);
        }
        
        return retorno;
    }
    public void setProficienciasArma(ProficienciaArmaVO[] proficienciasArma) {
        this.proficienciasArma.clear();
        this.proficienciasArma.addAll(Arrays.asList(proficienciasArma));
    }
    public void setProficienciasArma(ArrayList<ProficienciaArmaVO> proficienciasArma) {
        this.proficienciasArma.clear();
        this.proficienciasArma.addAll(proficienciasArma);
    }
    public void adicionarProficienciaArma(ProficienciaArmaVO proficienciaArma) {proficienciasArma.add(proficienciaArma);}
    public void removerProficienciaArma(int indice) throws IndexOutOfBoundsException {proficienciasArma.remove(indice);}
    
    public ProficienciaArmaduraVO[] getProficienciasArmadura() {
        int tamanho = proficienciasArmadura.size();
        ProficienciaArmaduraVO[] retorno = new ProficienciaArmaduraVO[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            retorno[i] = proficienciasArmadura.get(i);
        }
        
        return retorno;
    }
    public void setProficienciasArmadura(ProficienciaArmaduraVO[] proficienciasArmadura) {
        this.proficienciasArmadura.clear();
        this.proficienciasArmadura.addAll(Arrays.asList(proficienciasArmadura));
    }
    public void setProficienciasArmadura(ArrayList<ProficienciaArmaduraVO> proficienciasArmadura) {
        this.proficienciasArmadura.clear();
        this.proficienciasArmadura.addAll(proficienciasArmadura);
    }
    public void adicionarProficienciasArmadura(ProficienciaArmaduraVO proficienciaArmadura) {proficienciasArmadura.add(proficienciaArmadura);}
    public void removerProficienciasArmadura(int indice) throws IndexOutOfBoundsException {proficienciasArmadura.remove(indice);}
    
    public ProficienciaFerramentaVO[] getProficienciasFerramenta() {
        int tamanho = proficienciasFerramenta.size();
        ProficienciaFerramentaVO[] retorno = new ProficienciaFerramentaVO[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            retorno[i] = proficienciasFerramenta.get(i);
        }
        
        return retorno;
    }
    public void setProficienciasFerramenta(ProficienciaFerramentaVO[] proficienciasFerramenta) {
        this.proficienciasFerramenta.clear();
        this.proficienciasFerramenta.addAll(Arrays.asList(proficienciasFerramenta));
    }
    public void setProficienciasFerramenta(ArrayList<ProficienciaFerramentaVO> proficienciasFerramenta) {
        this.proficienciasFerramenta.clear();
        this.proficienciasFerramenta.addAll(proficienciasFerramenta);
    }
    public void adicionarProficienciasFerramenta(ProficienciaFerramentaVO proficienciaFerramenta) {proficienciasFerramenta.add(proficienciaFerramenta);}
    public void removerProficienciasFerramenta(int indice) throws IndexOutOfBoundsException {proficienciasFerramenta.remove(indice);}
    
    public ProficienciaLinguagemVO[] getProficienciaLinguagem() {
        int tamanho = proficienciasLinguagem.size();
        ProficienciaLinguagemVO[] retorno = new ProficienciaLinguagemVO[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            retorno[i] = proficienciasLinguagem.get(i);
        }
        
        return retorno;
    }
    public void setProficienciaLinguagem(ProficienciaLinguagemVO[] proficienciasLinguagem) {
        this.proficienciasLinguagem.clear();
        this.proficienciasLinguagem.addAll(Arrays.asList(proficienciasLinguagem));
    }
    public void setProficienciaLinguagem(ArrayList<ProficienciaLinguagemVO> proficienciasLinguagem) {
        this.proficienciasLinguagem.clear();
        this.proficienciasLinguagem.addAll(proficienciasLinguagem);
    }
    public void adicionarProficienciasLinguagem(ProficienciaLinguagemVO proficienciaLinguagem) {proficienciasLinguagem.add(proficienciaLinguagem);}
    public void removerProficienciaLinguagem(int indice) throws IndexOutOfBoundsException {proficienciasLinguagem.remove(indice);}
    
    public ProficienciaSaveVO[] getProficienciasSave() {
        int tamanho = proficienciasSave.size();
        ProficienciaSaveVO[] retorno = new ProficienciaSaveVO[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            retorno[i] = proficienciasSave.get(i);
        }
        
        return retorno;
    }
    public void setProficienciasSave(ProficienciaSaveVO[] proficienciasSave) {
        this.proficienciasSave.clear();
        this.proficienciasSave.addAll(Arrays.asList(proficienciasSave));
    }
    public void setProficienciasSave(ArrayList<ProficienciaSaveVO> proficienciasSave) {
        this.proficienciasSave.clear();
        this.proficienciasSave.addAll(proficienciasSave);
    }
    public void adicionarProficienciasSave(ProficienciaSaveVO proficienciaSave) {proficienciasSave.add(proficienciaSave);}
    public void removerProficienciasSave(int indice) throws IndexOutOfBoundsException {proficienciasSave.remove(indice);}
    
    public ProficienciaSkillVO[] getProficienciasSkill() {
        int tamanho = proficienciasSkill.size();
        ProficienciaSkillVO[] retorno = new ProficienciaSkillVO[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            retorno[i] = proficienciasSkill.get(i);
        }
        
        return retorno;
    }
    public void setProficienciasSkill(ProficienciaSkillVO proficienciasSkill) {
        this.proficienciasSkill.clear();
        this.proficienciasSkill.addAll(Arrays.asList(proficienciasSkill));
    }
    public void setProficienciasSkill(ArrayList<ProficienciaSkillVO> proficienciasSkill) {
        this.proficienciasSkill.clear();
        this.proficienciasSkill.addAll(proficienciasSkill);
    }
    public void adicionarProficienciasSkill(ProficienciaSkillVO proficienciaSkill) {proficienciasSkill.add(proficienciaSkill);}
    public void removerProficienciasSkill(int indice) throws IndexOutOfBoundsException {proficienciasSkill.remove(indice);}
    
    public DetalhesPersonagemVO getDetalhes() {return detalhes;}
    public void setDetalhes(DetalhesPersonagemVO detalhes) {this.detalhes = detalhes;}

    public BackstoryVO getBackstory() {return backstory;}
    public void setBackstory(BackstoryVO backstory) {this.backstory = backstory;}
}