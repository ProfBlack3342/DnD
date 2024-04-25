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
public final class PersonagemVO extends ObjetoVO
{
    private int idUsuario = -1;
    private int idImagemPersonagem = -1;
    private int idClasse = -1;
    private int idSubclasse = -1;
    private int idRaca = -1;
    private int idSubraca = -1;
    private int idBackground = -1;
    private int idProficienciasArmadura = -1;
    private int idProficienciasLinguagem = -1;
    private int idProficienciasSave = -1;
    private int idProficienciasSkill = -1;
    private int idProficienciasFerramenta = -1;
    private int idProficienciasArmas = -1;
    
    private String nome = "Sem Nome";
    private int nivel = 1;
    private int xp = 0;
    private int hpMaximo = 0;
    private int hpAtual = 0;
    private int hpTemp = 0;
    private int armorClass = 0;
    private int bonusProficiencia = 0;
    private int iniciativa = 0;
    private boolean inspirado = false;

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

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

    public int getIdProficienciasArmadura() {return idProficienciasArmadura;}
    public void setIdProficienciasArmadura(int idProficienciasArmadura) {this.idProficienciasArmadura = idProficienciasArmadura;}

    public int getIdProficienciasLinguagem() {return idProficienciasLinguagem;}
    public void setIdProficienciasLinguagem(int idProficienciasLinguagem) {this.idProficienciasLinguagem = idProficienciasLinguagem;}

    public int getIdProficienciasSave() {return idProficienciasSave;}
    public void setIdProficienciasSave(int idProficienciasSave) {this.idProficienciasSave = idProficienciasSave;}

    public int getIdProficienciasSkill() {return idProficienciasSkill;}
    public void setIdProficienciasSkill(int idProficienciasSkill) {this.idProficienciasSkill = idProficienciasSkill;}

    public int getIdProficienciasFerramenta() {return idProficienciasFerramenta;}
    public void setIdProficienciasFerramenta(int idProficienciasFerramenta) {this.idProficienciasFerramenta = idProficienciasFerramenta;}

    public int getIdProficienciasArmas() {return idProficienciasArmas;}
    public void setIdProficienciasArmas(int idProficienciasArmas) {this.idProficienciasArmas = idProficienciasArmas;}
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public int getNivel() {return nivel;}
    public void setNivel(int nivel) {this.nivel = nivel;}
    public void setNivelPeloXp() {
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
    public void setXp(int xp) {this.xp = xp;}
    public void setXpPeloNivel() {
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

    public int getHpMaximo() {return hpMaximo;}
    public void setHpMaximo(int hpMaximo) {this.hpMaximo = hpMaximo;}

    public int getHpAtual() {return hpAtual;}
    public void setHpAtual(int hpAtual) {this.hpAtual = hpAtual;}

    public int getHpTemp() {return hpTemp;}
    public void setHpTemp(int hpTemp) {this.hpTemp = hpTemp;}

    public int getArmorClass() {return armorClass;}
    public void setArmorClass(int armorClass) {this.armorClass = armorClass;}

    public int getBonusProficiencia() {
        return bonusProficiencia;
    }

    public void setBonusProficiencia(int bonusProficiencia) {
        this.bonusProficiencia = bonusProficiencia;
    }

    public int getIniciativa() {return iniciativa;}
    public void setIniciativa(int iniciativa) {this.iniciativa = iniciativa;}
    
    public boolean isInspirado() {return inspirado;}
    public void setInspirado(boolean inspirado) {this.inspirado = inspirado;}
}