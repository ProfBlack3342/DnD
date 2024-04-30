/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.HashMap;

/**
 *
 * @author dudup
 */
public class ProficienciasVO extends ObjetoVO
{
    private ArmaduraVO[] proficienciasArmaduras;
    private LinguagemVO[] proficienciasLinguagens;
    private FerramentaVO[] proficienciasFerramentas;
    private ArmaVO[] proficienciasArmas;

    public ProficienciasVO() {
        proficienciasArmaduras = new ArmaduraVO[0];
        proficienciasLinguagens = new LinguagemVO[0];
        proficienciasFerramentas = new FerramentaVO[0];
        proficienciasArmas = new ArmaVO[0];
    }

    public ProficienciasVO(ArmaduraVO[] proficienciasArmaduras, LinguagemVO[] proficienciasLinguagens, FerramentaVO[] proficienciasFerramentas, ArmaVO[] proficienciasArmas) {
        this.proficienciasArmaduras = proficienciasArmaduras;
        this.proficienciasLinguagens = proficienciasLinguagens;
        this.proficienciasFerramentas = proficienciasFerramentas;
        this.proficienciasArmas = proficienciasArmas;
    }

    public ArmaduraVO[] getProficienciasArmaduras() {return proficienciasArmaduras;}
    public void setProficienciaArmadura(ArmaduraVO[] proficienciasArmaduras) {this.proficienciasArmaduras = proficienciasArmaduras;}
    public boolean isProficienteArmadura(ArmaduraVO armadura) {
        int idArmadura = armadura.getId();
        for(ArmaduraVO a : proficienciasArmaduras)
        {
            if(idArmadura == a.getId())
                return true;
        }
        return false;
    }
    
    public LinguagemVO[] getProficienciasLinguagens() {return proficienciasLinguagens;}
    public void setProficienciaLinguagem(LinguagemVO[] proficienciasLinguagens) {this.proficienciasLinguagens = proficienciasLinguagens;}
    public boolean isProficienteLinguagem(LinguagemVO linguagem) {
        int idLinguagem = linguagem.getId();
        for(LinguagemVO l : proficienciasLinguagens)
        {
            if(idLinguagem == l.getId())
                return true;
        }
        return false;
    }
    

    public FerramentaVO[] getProficienciasFerramentas() {return proficienciasFerramentas;}
    public void setProficienciaFerramenta(FerramentaVO[] proficienciasFerramentas) {this.proficienciasFerramentas = proficienciasFerramentas;}
    public boolean isProficienteFerramenta(FerramentaVO ferramenta)
    {
        int idFerramenta = ferramenta.getId();
        for(FerramentaVO f : proficienciasFerramentas) {
            if(idFerramenta == f.getId()) {
                return true;
            }
        }
        return false;
    }
    
    
    public ArmaVO[] getProficienciasArmas() {return proficienciasArmas;}
    public void setProficienciaArma(ArmaVO[] proficienciasArmas) {this.proficienciasArmas = proficienciasArmas;}
    public boolean isProficienteArma(ArmaVO arma)
    {
        int idArma = arma.getId();
        for(ArmaVO a : proficienciasArmas) {
            if(idArma == a.getId())
                return true;
        }
        return false;
    }
}
