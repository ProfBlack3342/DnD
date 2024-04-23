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
    private int strBase, bonusStrNivel, bonusStrExtra, strTotal, strMod;
    private int dexBase, bonusDexNivel, bonusDexExtra, dexTotal, dexMod;
    private int conBase, bonusConNivel, bonusConExtra, conTotal, conMod;
    private int intBase, bonusIntNivel, bonusIntExtra, intTotal, intMod;
    private int wisBase, bonusWisNivel, bonusWisExtra, wisTotal, wisMod;
    private int chaBase, bonusChaNivel, bonusChaExtra, chaTotal, chaMod;
    private boolean inspirado;
    private FeatVO[] feats;
    private BackgroundVO background;
    private DetalhesPersonagemVO detalhes;
    private BackstoryVO backstory;
    private final ArrayList<EquipamentoVO> equipamentos;

    public PersonagemVO() {
        this.nome = "Escolha um Nome";
        this.nivel = 1;
        this.xp = 0;
        this.imagem = null;
        this.raca = null;
        this.classe = null;
        this.strBase = -1;
        this.dexBase = -1;
        this.conBase = -1;
        this.intBase = -1;
        this.wisBase = -1;
        this.chaBase = -1;
        this.feats = null;
        this.inspirado = false;
        this.background = null;
        this.detalhes = new DetalhesPersonagemVO();
        this.backstory = new BackstoryVO();
        this.equipamentos = new ArrayList<>();
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public int getNivel() {return nivel;}
    public void setNivel(int nivel) {
        this.nivel = nivel;
        setXpPeloNivel(this.nivel);
    }
    public void setNivelPeloXp(int xp) {
        
    }

    public int getXp() {return xp;}
    public void setXp(int xp) {
        this.xp = xp;
        setNivelPeloXp(this.xp);
    }
    public void setXpPeloNivel(int nivel) {
        
    }

    public ImagemVO getImagem() {return imagem;}
    public void setImagem(ImagemVO imagem) {this.imagem = imagem;}

    public RacaVO getRaca() {return raca;}
    public void setRaca(RacaVO raca) {this.raca = raca;}

    public ClasseVO getClasse() {return classe;}
    public void setClasse(ClasseVO classe) {this.classe = classe;}
    
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

    public FeatVO[] getFeats() {return feats;}
    public void setFeats(FeatVO[] feats) {this.feats = feats;}

    public boolean isInspirado() {return inspirado;}
    public void setInspirado(boolean inspirado) {this.inspirado = inspirado;}

    public BackgroundVO getBackground() {return background;}
    public void setBackground(BackgroundVO background) {this.background = background;}

    public DetalhesPersonagemVO getDetalhes() {return detalhes;}
    public void setDetalhes(DetalhesPersonagemVO detalhes) {this.detalhes = detalhes;}

    public BackstoryVO getBackstory() {return backstory;}
    public void setBackstory(BackstoryVO backstory) {this.backstory = backstory;}

    public EquipamentoVO[] getEquipamentos() {
        int tamanho = equipamentos.size();
        EquipamentoVO[] retorno = new EquipamentoVO[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            retorno[i] = equipamentos.get(i);
        }
        
        return retorno;
    }
    public void setEquipamentos(EquipamentoVO[] equipClasse, EquipamentoVO[] equipBack) {
        this.equipamentos.clear();
        this.equipamentos.addAll(Arrays.asList(equipClasse));
        this.equipamentos.addAll(Arrays.asList(equipBack));
    }
    public void setEquipamentos(EquipamentoVO[] equipamentos, EquipamentoVO[] equipClasse, EquipamentoVO[] equipBack) {
        this.equipamentos.clear();
        this.equipamentos.addAll(Arrays.asList(equipClasse));
        this.equipamentos.addAll(Arrays.asList(equipBack));
        this.equipamentos.addAll(Arrays.asList(equipamentos));
    }
    public void setEquipamentos(ArrayList<EquipamentoVO> equipamentos, EquipamentoVO[] equipClasse, EquipamentoVO[] equipBack) {
        this.equipamentos.clear();
        this.equipamentos.addAll(Arrays.asList(equipClasse));
        this.equipamentos.addAll(Arrays.asList(equipBack));
        this.equipamentos.addAll(equipamentos);
    }
    public void adicionarEquipamento(EquipamentoVO equipamento) {
        equipamentos.add(equipamento);
    }
    public void removerEquipamento(int indice) throws IndexOutOfBoundsException {
        equipamentos.remove(indice);
    }
}