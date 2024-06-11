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
 * @author Eduardo Pereira Moreira
 */
public final class PersonagemVO extends ObjetoVO
{
    private static final String NOME_TABELA = "Personagem";
    /*
        Tabela Personagem (
            idPersonagem INT NOT NULL,
            idUsuario INT NOT NULL,
            idImagemPersonagem INT NOT NULL,
            idClasse INT NOT NULL,
            idSubclasse INT NOT NULL,
            idRaca INT NOT NULL,
            idSubraca INT NOT NULL,
            idBackground INT NOT NULL,
            nomePersonagem VARCHAR(50) NULL,
            nivelPersonagem INT NOT NULL DEFAULT 1,
            xpPersonagem INT NOT NULL DEFAULT 0,
            inspiracaoPersonagem TINYINT(1) NOT NULL DEFAULT 0,
            descricaoPersonagem VARCHAR(2000) NULL,
            dataCriacaoPersonagem DATE NOT NULL,
            personagemAtivo TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String[] NOMES_COLUNAS = new String[]{
        "idPersonagem",
        "idUsuario",
        "idImagemPersonagem",
        "idClasse",
        "idSubclasse",
        "idRaca",
        "idSubraca",
        "idBackground",
        "nomePersonagem",
        "nivelPersonagem",
        "xpPersonagem",
        "inspiracaoPersonagem",
        "descricaoPersonagem",
        "dataCriacaoPersonagem",
        "personagemAtivo"
    };
    private static final int LIMITE_NOME_PERSONAGEM = 50;
    private static final int LIMITE_DESCRICAO_PERSONAGEM = 2000;
    
    private int idUsuario;
    private int idImagemPersonagem;
    private int idClasse;
    private int idSubclasse;
    private int idRaca;
    private int idSubraca;
    private int idBackground;
    private String nomePersonagem;
    private int nivelPersonagem = 1;
    private int xpPersonagem = 0;
    private boolean inspirado = false;
    private String descricaoPersonagem;
    
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
    
    public PersonagemVO() {
    }

    public PersonagemVO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}
    public static int getLimiteNomePersonagem() {return LIMITE_NOME_PERSONAGEM;}
    public static int getLimiteDescricaoPersonagem() {return LIMITE_DESCRICAO_PERSONAGEM;}

    
    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public ImagemVO getImagemPersonagem() {return imagemPersonagem;}
    public void setImagemPersonagem(ImagemVO imagemPersonagem) {this.imagemPersonagem = imagemPersonagem;}

    public int getIdImagemPersonagem() {return idImagemPersonagem;}
    public void setIdImagemPersonagem(int idImagemPersonagem) {this.idImagemPersonagem = idImagemPersonagem;}

    public int getIdClasse() {return idClasse;}
    public void setIdClasse(int idClasse) {this.idClasse = idClasse;}

    public int getIdSubclasse() {return idSubclasse;}
    public void setIdSubclasse(int idSubclasse) {this.idSubclasse = idSubclasse;}

    public int getIdRaca() {return idRaca;}
    public void setIdRaca(int idRaca) {this.idRaca = idRaca;}

    public int getIdSubraca() {return idSubraca;}
    public void setIdSubraca(int idSubraca) {this.idSubraca = idSubraca;}

    public int getIdBackground() {return idBackground;}
    public void setIdBackground(int idBackground) {this.idBackground = idBackground;}

    public String getNomePersonagem() {return nomePersonagem;}
    public void setNomePersonagem(String nomePersonagem) {this.nomePersonagem = nomePersonagem;}

    private void setNivelPeloXp() {
        if(xpPersonagem < 300)
            nivelPersonagem = 1;
        else if(xpPersonagem < 900)
            nivelPersonagem = 2;
        else if(xpPersonagem < 2700)
            nivelPersonagem = 3;
        else if(xpPersonagem < 6500)
            nivelPersonagem = 4;
        else if(xpPersonagem < 14000)
            nivelPersonagem = 5;
        else if(xpPersonagem < 23000)
            nivelPersonagem = 6;
        else if(xpPersonagem < 34000)
            nivelPersonagem = 7;
        else if(xpPersonagem < 48000)
            nivelPersonagem = 8;
        else if(xpPersonagem < 64000)
            nivelPersonagem = 9;
        else if(xpPersonagem < 85000)
            nivelPersonagem = 10;
        else if(xpPersonagem < 100000)
            nivelPersonagem = 11;
        else if(xpPersonagem < 120000)
            nivelPersonagem = 12;
        else if(xpPersonagem < 140000)
            nivelPersonagem = 13;
        else if(xpPersonagem < 165000)
            nivelPersonagem = 14;
        else if(xpPersonagem < 195000)
            nivelPersonagem = 15;
        else if(xpPersonagem < 225000)
            nivelPersonagem = 16;
        else if(xpPersonagem < 265000)
            nivelPersonagem = 17;
        else if(xpPersonagem < 305000)
            nivelPersonagem = 18;
        else if(xpPersonagem < 355000)
            nivelPersonagem = 19;
        else
            nivelPersonagem = 20;
        
    }
    private void setXpPeloNivel() {
        switch(nivelPersonagem) {
            case 1:
            {
                xpPersonagem = 0;
                break;
            }
            case 2:
            {
                xpPersonagem = 300;
                break;
            }
            case 3:
            {
                xpPersonagem = 900;
                break;
            }
            case 4:
            {
                xpPersonagem = 2700;
                break;
            }
            case 5:
            {
                xpPersonagem = 6500;
                break;
            }
            case 6:
            {
                xpPersonagem = 14000;
                break;
            }
            case 7:
            {
                xpPersonagem = 23000;
                break;
            }
            case 8:
            {
                xpPersonagem = 34000;
                break;
            }
            case 9:
            {
                xpPersonagem = 48000;
                break;
            }
            case 10:
            {
                xpPersonagem = 64000;
                break;
            }
            case 11:
            {
                xpPersonagem = 85000;
                break;
            }
            case 12:
            {
                xpPersonagem = 100000;
                break;
            }
            case 13:
            {
                xpPersonagem = 120000;
                break;
            }
            case 14:
            {
                xpPersonagem = 140000;
                break;
            }
            case 15:
            {
                xpPersonagem = 165000;
                break;
            }
            case 16:
            {
                xpPersonagem = 195000;
                break;
            }
            case 17:
            {
                xpPersonagem = 225000;
                break;
            }
            case 18:
            {
                xpPersonagem = 265000;
                break;
            }
            case 19:
            {
                xpPersonagem = 305000;
                break;
            }
            case 20:
            {
                xpPersonagem = 355000;
                break;
            }
            default:
                break;
        }
    }
    
    public int getNivelPersonagem() {return nivelPersonagem;}
    public void setNivelPersonagem(int nivelPersonagem) {
        this.nivelPersonagem = nivelPersonagem;
        setXpPeloNivel();
    }
    
    public int getXpPersonagem() {return xpPersonagem;}
    public void setXpPersonagem(int xpPersonagem) {
        this.xpPersonagem = xpPersonagem;
        setNivelPeloXp();
    }
    
    public boolean isInspirado() {return inspirado;}
    public void setInspirado(boolean inspirado) {this.inspirado = inspirado;}

    public String getDescricaoPersonagem() {return descricaoPersonagem;}
    public void setDescricaoPersonagem(String descricaoPersonagem) {this.descricaoPersonagem = descricaoPersonagem;}
    
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

    public EquipamentoVO[] getInventarioPersonagem() {return inventarioPersonagem;}
    public void setInventarioPersonagem(EquipamentoVO[] inventarioPersonagem) {this.inventarioPersonagem = inventarioPersonagem;}
}