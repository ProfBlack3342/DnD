/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 181700271
 */
public final class PersonagemVO extends ObjetoVO
{
    private String nome;
    private ImagemVO imagem;
    private RacaVO raca;
    private ClasseVO classe;
    private int strBase, bonusStrNivel, bonusStrExtra, strTotal, strMod;
    private int dexBase, bonusDexNivel, bonusDexExtra, dexTotal, dexMod;
    private int conBase, bonusConNivel, bonusConExtra, conTotal, conMod;
    private int intBase, bonusIntNivel, bonusIntExtra, intTotal, intMod;
    private int wisBase, bonusWisNivel, bonusWisExtra, wisTotal, wisMod;
    private int chaBase, bonusChaNivel, bonusChaExtra, chaTotal, chaMod;
    private BackgroundVO background;
    private DetalhesPersonagemVO detalhes;
    private BackstoryVO backstory;
    private final ArrayList<EquipamentoVO> equipamentos;

    public PersonagemVO()
    {
        equipamentos = new ArrayList<>();
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public ImagemVO getImagem() {return imagem;}
    public void setImagem(ImagemVO imagem) {this.imagem = imagem;}

    public RacaVO getRaca() {return raca;}
    public void setRaca(RacaVO raca) {this.raca = raca;}

    public ClasseVO getClasse() {return classe;}
    public void setClasse(ClasseVO classe) {this.classe = classe;}

    public int getStrBase() {return strBase;}
    public void setStrBase(int strBase) {this.strBase = strBase;}
    public int getBonusStrNivel() {return bonusStrNivel;}
    public void setBonusStrNivel(int bonusStrNivel) {this.bonusStrNivel = bonusStrNivel;}
    public int getStrTotal() {
        if(strBase != -1)
           return strTotal;
        else
            return 0;
    }
    public void setStrTotal() {
        
        this.strTotal = raca.getBonusStr() + bonusStrNivel + bonusStrExtra;
    }
    public int getStrMod() {
        if(strTotal != -1)
            return strMod;
        else
            return 0;
    }
    public void setStrMod(int strMod) {
        this.strMod = strMod;
    }

    public int getDexBase() {return dexBase;}
    public void setDexBase(int dexBase) {this.dexBase = dexBase;}
    public int getBonusDexNivel() {return bonusDexNivel;}
    public void setBonusDexNivel(int bonusDexNivel) {this.bonusDexNivel = bonusDexNivel;}
    public int getDexTotal() {
        if(dexBase != -1)
            return dexTotal;
        else
            return 0;
    }
    public void setDexTotal(int dexTotal) {
        this.dexTotal = dexTotal;
    }
    public int getDexMod() {
        if(dexTotal != -1)
            return dexMod;
        else
            return 0;
    }
    public void setDexMod(int dexMod) {
        this.dexMod = dexMod;
    }

    public int getConBase() {return conBase;}
    public void setConBase(int conBase) {this.conBase = conBase;}
    public int getBonusConNivel() {return bonusConNivel;}
    public void setBonusConNivel(int bonusConNivel) {this.bonusConNivel = bonusConNivel;}
    public int getConTotal() {
        if(conBase != -1)
            return conTotal;
        else
            return 0;
    }
    public void setConTotal(int conTotal) {
        this.conTotal = conTotal;
    }
    public int getConMod() {
        if(conTotal != -1)
            return conMod;
        else
            return 0;
    }
    public void setConMod(int conMod) {
        this.conMod = conMod;
    }

    public int getIntBase() {return intBase;}
    public void setIntBase(int intBase) {this.intBase = intBase;}
    public int getBonusIntNivel() {return bonusIntNivel;}
    public void setBonusIntNivel(int bonusIntNivel) {this.bonusIntNivel = bonusIntNivel;}
    public int getIntTotal() {
        if(intBase != -1)
            return intTotal;
        else
            return 0;
    }
    public void setIntTotal(int intTotal) {
        this.intTotal = intTotal;
    }
    public int getIntMod() {
        if(intTotal != -1)
            return intMod;
        else
            return 0;
    }
    public void setIntMod(int intMod) {
        this.intMod = intMod;
    }

    public int getWisBase() {return wisBase;}
    public void setWisBase(int wisBase) {this.wisBase = wisBase;}
    public int getBonusWisNivel() {return bonusWisNivel;}
    public void setBonusWisNivel(int bonusWisNivel) {this.bonusWisNivel = bonusWisNivel;}
    public int getWisTotal() {
        if(wisBase != -1)
            return wisTotal;
        else
            return 0;
    }
    public void setWisTotal(int wisTotal) {
        this.wisTotal = wisTotal;
    }
    public int getWisMod() {
        if(wisTotal != -1)
            return wisMod;
        else
            return 0;
    }
    public void setWisMod(int wisMod) {
        this.wisMod = wisMod;
    }

    public int getChaBase() {return chaBase;}
    public void setChaBase(int chaBase) {this.chaBase = chaBase;}
    public int getBonusChaNivel() {return bonusChaNivel;}
    public void setBonusChaNivel(int bonusChaNivel) {this.bonusChaNivel = bonusChaNivel;}
    public int getChaTotal() {
        if(chaBase != -1)
            return chaTotal;
        else
            return 0;
    }
    public void setChaTotal(int chaTotal) {
        this.chaTotal = chaTotal;
    }
    public int getChaMod() {
        if(chaTotal != -1)
            return chaMod;
        else
            return 0;
    }
    public void setChaMod(int chaMod) {
        this.chaMod = chaMod;
    }

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