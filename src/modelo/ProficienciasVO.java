/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;

/**
 *
 * @author 181700271
 */
public class ProficienciasVO extends ObjetoVO
{
    private final int idUsuario;
    private final int idPersonagem;
    
    private final HashMap<ArmaduraVO, Boolean> proficienciasArmaduras;
    private final HashMap<LinguagemVO, Boolean> proficienciasLinguagens;
    private final HashMap<FerramentaVO, Boolean> proficienciasFerramentas;
    private final HashMap<ArmaVO, Boolean> proficienciasArmas;

    public ProficienciasVO(int idUsuario, int idPersonagem) {
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
        proficienciasArmaduras = new HashMap<>();
        proficienciasLinguagens = new HashMap<>();
        proficienciasFerramentas = new HashMap<>();
        proficienciasArmas = new HashMap<>();
    }

    public ProficienciasVO(int idUsuario, int idPersonagem, HashMap<ArmaduraVO, Boolean> proficienciasArmaduras, HashMap<LinguagemVO, Boolean> proficienciasLinguagens, HashMap<FerramentaVO, Boolean> proficienciasFerramentas, HashMap<ArmaVO, Boolean> proficienciasArmas) {
        this.idUsuario = idUsuario;
        this.idPersonagem = idPersonagem;
        this.proficienciasArmaduras = proficienciasArmaduras;
        this.proficienciasLinguagens = proficienciasLinguagens;
        this.proficienciasFerramentas = proficienciasFerramentas;
        this.proficienciasArmas = proficienciasArmas;
    }

    public int getIdUsuario() {return idUsuario;}

    public int getIdPersonagem() {return idPersonagem;}

    public boolean getProficienciaArmadura(ArmaduraVO armadura) {
        return proficienciasArmaduras.get(armadura);
    }
    public void setProficienciaArmadura(ArmaduraVO armadura, boolean proficiencia) {
        proficienciasArmaduras.remove(armadura);
        proficienciasArmaduras.put(armadura, proficiencia);
    }

    public boolean getProficienciaLinguagem(LinguagemVO linguagem) {
        return proficienciasLinguagens.get(linguagem);
    }
    public void setProficienciaLinguagem(LinguagemVO linguagem, boolean proficiencia) {
        proficienciasLinguagens.remove(linguagem);
        proficienciasLinguagens.put(linguagem, proficiencia);
    }

    public boolean getProficienciaFerramenta(FerramentaVO ferramenta) {
        return proficienciasFerramentas.get(ferramenta);
    }
    public void setProficienciaFerramenta(FerramentaVO ferramenta, boolean proficiencia) {
        proficienciasFerramentas.remove(ferramenta);
        proficienciasFerramentas.put(ferramenta, proficiencia);
    }

    public boolean getProficienciaArma(ArmaVO arma) {
        return proficienciasArmas.get(arma);
    }
    public void setProficienciaArma(ArmaVO arma, boolean proficiencia) {
        proficienciasArmas.remove(arma);
        proficienciasArmas.put(arma, proficiencia);
    }
}
