/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author 181700271
 */
public final class PersonagemVO extends ObjetoVO
{
    private int idUsuario;
    private ImagemVO imagemPersonagem;
    private ClasseVO classe;
    private SubclasseVO subclasse;
    private RacaVO raca;
    private SubRacaVO subraca;
    private BackgroundVO background;
    
    private DetalhesVO detalhes;
    private BackstoryVO backstory;
    private ProficienciasPersonagemVO proficienciasPersonagem;
    private AtributosPersonagemVO valoresEProficienciasAtributosPersonagem;
    private PericiasPersonagemVO proficienciasPericiasPersonagem;
    private final ArrayList<FeatVO> featsPersonagem = new ArrayList<>();
    private EquipamentoVO[] inventarioPersonagem;
    
    private String nome = "Sem Nome";
    private int nivel = 1;
    private int xp = 0;
    private int iniciativa = 0;
    private boolean inspirado = false;

    public PersonagemVO() {
    }

    public PersonagemVO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public ImagemVO getImagemPersonagem() {return imagemPersonagem;}
    public void setImagemPersonagem(ImagemVO imagemPersonagem) {this.imagemPersonagem = imagemPersonagem;}

    public ClasseVO getClasse() {return classe;}
    public void setClasse(ClasseVO classe) {this.classe = classe;}

    public SubclasseVO getSubclasse() {return subclasse;}
    public void setSubclasse(SubclasseVO subclasse) {this.subclasse = subclasse;}

    public RacaVO getRaca() {return raca;}
    public void setRaca(RacaVO raca) {this.raca = raca;}

    public SubRacaVO getSubraca() {return subraca;}
    public void setSubraca(SubRacaVO subraca) {this.subraca = subraca;}

    public BackgroundVO getBackground() {return background;}
    public void setBackground(BackgroundVO background) {this.background = background;}

    public DetalhesVO getDetalhes() {return detalhes;}
    public void setDetalhes(DetalhesVO detalhes) {this.detalhes = detalhes;}

    public BackstoryVO getBackstory() {return backstory;}
    public void setBackstory(BackstoryVO backstory) {this.backstory = backstory;}

    public ProficienciasPersonagemVO getProficienciasPersonagem() {return proficienciasPersonagem;}
    public void setProficienciasPersonagem(ProficienciasPersonagemVO proficienciasPersonagem) {this.proficienciasPersonagem = proficienciasPersonagem;}

    public AtributosPersonagemVO getValoresEProficienciasAtributosPersonagem() {return valoresEProficienciasAtributosPersonagem;}
    public void setValoresEProficienciasAtributosPersonagem(AtributosPersonagemVO valoresEProficienciasAtributosPersonagem) {this.valoresEProficienciasAtributosPersonagem = valoresEProficienciasAtributosPersonagem;}

    public PericiasPersonagemVO getProficienciasPericiasPersonagem() {return proficienciasPericiasPersonagem;}
    public void setProficienciasPericiasPersonagem(PericiasPersonagemVO proficienciasPericiasPersonagem) {this.proficienciasPericiasPersonagem = proficienciasPericiasPersonagem;}

    public FeatVO[] getFeatsPersonagem() {return featsPersonagem.toArray(new FeatVO[featsPersonagem.size()]);}
    public void setFeatsPersonagem(ArrayList<FeatVO> featsPersonagem) {
        this.featsPersonagem.clear();
        this.featsPersonagem.addAll(featsPersonagem);
    }
    public void setFeatsPersonagem(FeatVO[] featsPersonagem) {
        this.featsPersonagem.clear();
        this.featsPersonagem.addAll(Arrays.asList(featsPersonagem));
    }
    public void addFeatPersonagem(FeatVO featPersonagem) {this.featsPersonagem.add(featPersonagem);}
    public void removeFeatPersonagem(int indice) {featsPersonagem.remove(indice);}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    private void setNivelPeloXp() {
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
    private void setXpPeloNivel() {
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
            default:
                break;
        }
    }
    
    public int getNivel() {return nivel;}
    public void setNivel(int nivel) {
        this.nivel = nivel;
        setXpPeloNivel();
    }
    
    public int getXp() {return xp;}
    public void setXp(int xp) {
        this.xp = xp;
        setNivelPeloXp();
    }

    public int getIniciativa() {return iniciativa;}
    public void setIniciativa(int iniciativa) {this.iniciativa = iniciativa;}
    
    public boolean isInspirado() {return inspirado;}
    public void setInspirado(boolean inspirado) {this.inspirado = inspirado;}

    public EquipamentoVO[] getInventarioPersonagem() {return inventarioPersonagem;}
    public void setInventarioPersonagem(EquipamentoVO[] inventarioPersonagem) {this.inventarioPersonagem = inventarioPersonagem;}
}