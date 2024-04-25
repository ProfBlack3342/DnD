/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dudup
 */
public class HabilidadesVO extends ObjetoVO
{
    private int idPersonagem;
    private int idUsuario;
    
    private int valorSTRBase;
    private boolean proficienteSaveSTR;
    private int valorDEXBase;
    private boolean proficienteSaveDEX;
    private int valorCONBase;
    private boolean proficienteSaveCON;
    private int valorINTBase;
    private boolean proficienteSaveINT;
    private int valorWISBase;
    private boolean proficienteSaveWIS;
    private int valorCHABase;
    private boolean proficienteSaveCHA;

    public int getIdPersonagem() {return idPersonagem;}
    public void setIdPersonagem(int idPersonagem) {this.idPersonagem = idPersonagem;}

    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getValorSTRBase() {return valorSTRBase;}
    public void setValorSTRBase(int valorSTRBase) {this.valorSTRBase = valorSTRBase;}

    public boolean isProficienteSaveSTR() {return proficienteSaveSTR;}
    public void setProficienteSaveSTR(boolean proficienteSaveSTR) {this.proficienteSaveSTR = proficienteSaveSTR;}

    public int getValorDEXBase() {return valorDEXBase;}
    public void setValorDEXBase(int valorDEXBase) {this.valorDEXBase = valorDEXBase;}

    public boolean isProficienteSaveDEX() {return proficienteSaveDEX;}
    public void setProficienteSaveDEX(boolean proficienteSaveDEX) {this.proficienteSaveDEX = proficienteSaveDEX;}

    public int getValorCONBase() {return valorCONBase;}
    public void setValorCONBase(int valorCONBase) {this.valorCONBase = valorCONBase;}

    public boolean isProficienteSaveCON() {return proficienteSaveCON;}
    public void setProficienteSaveCON(boolean proficienteSaveCON) {this.proficienteSaveCON = proficienteSaveCON;}

    public int getValorINTBase() {return valorINTBase;}
    public void setValorINTBase(int valorINTBase) {this.valorINTBase = valorINTBase;}

    public boolean isProficienteSaveINT() {return proficienteSaveINT;}
    public void setProficienteSaveINT(boolean proficienteSaveINT) {this.proficienteSaveINT = proficienteSaveINT;}

    public int getValorWISBase() {return valorWISBase;}
    public void setValorWISBase(int valorWISBase) {this.valorWISBase = valorWISBase;}

    public boolean isProficienteSaveWIS() {return proficienteSaveWIS;}
    public void setProficienteSaveWIS(boolean proficienteSaveWIS) {this.proficienteSaveWIS = proficienteSaveWIS;}

    public int getValorCHABase() {return valorCHABase;}
    public void setValorCHABase(int valorCHABase) {this.valorCHABase = valorCHABase;}

    public boolean isProficienteSaveCHA() {return proficienteSaveCHA;}
    public void setProficienteSaveCHA(boolean proficienteSaveCHA) {this.proficienteSaveCHA = proficienteSaveCHA;}
}
