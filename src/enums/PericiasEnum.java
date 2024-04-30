/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author dudup
 */
public enum PericiasEnum {
    ATLETISMO("Atletismo"),                 // STR
    ACROBACIA("Acrobacia"),                 // DEX
    FURTIVIDADE("Furtividade"),             // DEX
    PRESTIDIGITACAO("Prestidigitação"),     // DEX
    ARCANISMO("Arcanismo"),                 // INT
    HISTORIA("História"),                   // INT
    INVESTIGACAO("Investigação"),           // INT
    NATUREZA("Natureza"),                   // INT
    RELIGIAO("Religião"),                   // INT
    ADESTRAR_ANIMAIS("Adestrar Animais"),   // WIS
    INTUICAO("Intuição"),                   // WIS
    MEDICINA("Medicina"),                   // WIS
    PERCEPCAO("Percepção"),                 // WIS
    SOBREVIVENCIA("Sobrevivência"),         // WIS
    ATUACAO("Atuação"),                     // CHA
    ENGANACAO("Enganação"),                 // CHA
    INTIMIDACAO("Intimidação"),             // CHA
    PERSUASAO("Persuasão");                 // CHA
    
    private final String nomeString;
    private PericiasEnum(String nomeString) {
        this.nomeString = nomeString;
    }
    
    public static String[] getNomesPossiveis() {
        int tamanho = values().length;
        String[] valoresPossiveis = new String[tamanho];
        
        for(int i = 0; i < tamanho; i ++) {
            valoresPossiveis[i] = values()[i].nomeString;
        }
        
        return valoresPossiveis;
    }
}
