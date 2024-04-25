/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author dudup
 */
public enum NomesSkillEnum {
    ATLETISMO("Atletismo"),        // STR
    ACROBACIA("Acrobacia"), FURTIVIDADE("Furtividade"), PRESTIDIGITACAO("Prestidigitação"),      // DEX
    ARCANISMO("Arcanismo"), HISTORIA("História"), INVESTIGACAO("Investigação"), NATUREZA("Natureza"), RELIGIAO("Religião"),        // INT
    ADESTRAR_ANIMAIS("Adestrar Animais"), INTUICAO("Intuição"), MEDICINA("Medicina"), PERCEPCAO("Percepção"), SOBREVIVENCIA("Sobrevivência"),     // WIS
    ATUACAO("Atuação"), ENGANACAO("Enganação"), INTIMIDACAO("Intimidação"), PERSUASAO("Persuasão");      // CHA
    
    public final String nomeString;
    private NomesSkillEnum(String nomeString) {this.nomeString = nomeString;}
    public static String[] getNomesPossiveis() {
        int tamanho = values().length;
        String[] valoresPossiveis = new String[tamanho];
        
        for(int i = 0; i < tamanho; i ++) {
            valoresPossiveis[i] = values()[i].nomeString;
        }
        
        return valoresPossiveis;
    }
}
