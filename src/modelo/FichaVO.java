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
    private static final String NOME_TABELA = "Ficha";
    /*
        Tabela Ficha (
            idFicha INT NOT NULL,
            idPersonagem INT NOT NULL,
            idUsuario INT NOT NULL,
            
            nivelPersonagem INT NOT NULL DEFAULT 1,
            xpPersonagem INT NOT NULL DEFAULT 0,
            personagemInspirado TINYINT(1) NOT NULL DEFAULT 0,
            
            dataCriacaoFicha DATE NOT NULL,
            fichaAtiva TINYINT(1) NOT NULL DEFAULT 1
        )
    */
    private static final String[] NOMES_COLUNAS = new String[]{
        "idFicha",
        "idPersonagem",
        "idUsuario",
        
        "nivelPersonagem",
        "xpPersonagem",
        "personagemInspirado",
        
        "dataCriacaoPersonagem",
        "personagemAtivo"
    };
    
    public static String getNomeTabela() {return NOME_TABELA;}
    public static String[] getNomesColunas() {return NOMES_COLUNAS;}
    
    private int idPersonagem, idUsuario;
    private int nivelPersonagem;
    private int xpPersonagem;
    private boolean personagemInspirado;

    public int getIdPersonagem() {return idPersonagem;}
    public void setIdPersonagem(int idPersonagem) {this.idPersonagem = idPersonagem;}

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getNivelPersonagem() {return nivelPersonagem;}
    public void setNivelPersonagem(int nivelPersonagem) {this.nivelPersonagem = nivelPersonagem;}
    public void setNivelPersonagemPeloXp(int xpPersonagem) {
        this.xpPersonagem = xpPersonagem;
        if(this.xpPersonagem < 300)
            nivelPersonagem = 1;
        else if(this.xpPersonagem < 900)
            nivelPersonagem = 2;
        else if(this.xpPersonagem < 2700)
            nivelPersonagem = 3;
        else if(this.xpPersonagem < 6500)
            nivelPersonagem = 4;
        else if(this.xpPersonagem < 14000)
            nivelPersonagem = 5;
        else if(this.xpPersonagem < 23000)
            nivelPersonagem = 6;
        else if(this.xpPersonagem < 34000)
            nivelPersonagem = 7;
        else if(this.xpPersonagem < 48000)
            nivelPersonagem = 8;
        else if(this.xpPersonagem < 64000)
            nivelPersonagem = 9;
        else if(this.xpPersonagem < 85000)
            nivelPersonagem = 10;
        else if(this.xpPersonagem < 100000)
            nivelPersonagem = 11;
        else if(this.xpPersonagem < 120000)
            nivelPersonagem = 12;
        else if(this.xpPersonagem < 140000)
            nivelPersonagem = 13;
        else if(this.xpPersonagem < 165000)
            nivelPersonagem = 14;
        else if(this.xpPersonagem < 195000)
            nivelPersonagem = 15;
        else if(this.xpPersonagem < 225000)
            nivelPersonagem = 16;
        else if(this.xpPersonagem < 265000)
            nivelPersonagem = 17;
        else if(this.xpPersonagem < 305000)
            nivelPersonagem = 18;
        else if(this.xpPersonagem < 355000)
            nivelPersonagem = 19;
        else
            nivelPersonagem = 20;
        
    }

    public int getXpPersonagem() {return xpPersonagem;}
    public void setXpPersonagem(int xpPersonagem) {this.xpPersonagem = xpPersonagem;}
    public void setXpPersonagemPeloNivel(int nivelPersonagem) {
        this.nivelPersonagem = nivelPersonagem;
        switch(this.nivelPersonagem) {
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

    public boolean isPersonagemInspirado() {return personagemInspirado;}
    public void setPersonagemInspirado(boolean personagemInspirado) {this.personagemInspirado = personagemInspirado;}
}
