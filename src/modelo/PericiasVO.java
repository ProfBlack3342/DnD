/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import enums.PericiasEnum;
import java.util.HashMap;

/**
 *
 * @author dudup
 */
public class PericiasVO extends ObjetoVO
{
    private final HashMap<PericiasEnum, Boolean> proficienciasPericias;

    public PericiasVO() {
        
        proficienciasPericias = new HashMap<>();
        proficienciasPericias.put(PericiasEnum.ATLETISMO, false);
        proficienciasPericias.put(PericiasEnum.ACROBACIA, false);
        proficienciasPericias.put(PericiasEnum.FURTIVIDADE, false);
        proficienciasPericias.put(PericiasEnum.PRESTIDIGITACAO, false);
        proficienciasPericias.put(PericiasEnum.ARCANISMO, false);
        proficienciasPericias.put(PericiasEnum.HISTORIA, false);
        proficienciasPericias.put(PericiasEnum.INVESTIGACAO, false);
        proficienciasPericias.put(PericiasEnum.NATUREZA, false);
        proficienciasPericias.put(PericiasEnum.RELIGIAO, false);
        proficienciasPericias.put(PericiasEnum.ADESTRAR_ANIMAIS, false);
        proficienciasPericias.put(PericiasEnum.INTUICAO, false);
        proficienciasPericias.put(PericiasEnum.MEDICINA, false);
        proficienciasPericias.put(PericiasEnum.PERCEPCAO, false);
        proficienciasPericias.put(PericiasEnum.SOBREVIVENCIA, false);
        proficienciasPericias.put(PericiasEnum.ATUACAO, false);
        proficienciasPericias.put(PericiasEnum.ENGANACAO, false);
        proficienciasPericias.put(PericiasEnum.INTIMIDACAO, false);
        proficienciasPericias.put(PericiasEnum.PERSUASAO, false);
    }

    public PericiasVO(HashMap<PericiasEnum, Boolean> proficienciasPericias) {
        this.proficienciasPericias = proficienciasPericias;
    }

    /**
     * Retorna se o personagem é proficiente em uma pericia
     * @param pericia A pericia que se deseja saber a proficiencia
     * @return Verdadeiro se for proficiente, Falso se não for
     */
    public boolean isProficientePericia(PericiasEnum pericia) {
        return proficienciasPericias.get(pericia);
    }
    
    /**
     * Muda o valor da proficiencia de uma pericia
     * @param pericia A pericia com a proficiencia a ser alterada
     * @param proficiencia O valor novo para a proficiencia
     */
    public void setProficienciaPericia(PericiasEnum pericia, boolean proficiencia) {
        proficienciasPericias.remove(pericia);
        proficienciasPericias.put(pericia, proficiencia);
    }
}
