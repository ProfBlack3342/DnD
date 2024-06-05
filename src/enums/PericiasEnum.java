/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author dudup
 */
public enum PericiasEnum
{
    ATLETISMO("Atletismo", "Athletics", AtributosEnum.STR),                         // STR
    
    ACROBACIA("Acrobacia", "Acrobatics", AtributosEnum.DEX),                        // DEX
    FURTIVIDADE("Furtividade", "Stealth", AtributosEnum.DEX),                       // DEX
    PRESTIDIGITACAO("Prestidigitação", "Sleight of Hand", AtributosEnum.DEX),       // DEX
    
    ARCANISMO("Arcanismo", "Arcana", AtributosEnum.INT),                            // INT
    HISTORIA("História", "History", AtributosEnum.INT),                             // INT
    INVESTIGACAO("Investigação", "Investigation", AtributosEnum.INT),               // INT
    NATUREZA("Natureza", "Nature", AtributosEnum.INT),                              // INT
    RELIGIAO("Religião", "Religion", AtributosEnum.INT),                            // INT
    
    ADESTRAR_ANIMAIS("Adestrar Animais", "Animal Handling", AtributosEnum.WIS),     // WIS
    INTUICAO("Intuição", "Insight", AtributosEnum.WIS),                             // WIS
    MEDICINA("Medicina", "Medicine", AtributosEnum.WIS),                            // WIS
    PERCEPCAO("Percepção", "Perception", AtributosEnum.WIS),                        // WIS
    SOBREVIVENCIA("Sobrevivência", "Survival", AtributosEnum.WIS),                  // WIS
    
    ATUACAO("Atuação", "Performance", AtributosEnum.CHA),                           // CHA
    ENGANACAO("Enganação", "Deception", AtributosEnum.CHA),                         // CHA
    INTIMIDACAO("Intimidação", "Intimidation", AtributosEnum.CHA),                  // CHA
    PERSUASAO("Persuasão", "Persuasion", AtributosEnum.CHA);                        // CHA
    
    private final String nomePT;
    private final String nomeEN;
    private final AtributosEnum modificador;
    
    private PericiasEnum(String nomePT, String nomeEN, AtributosEnum modificador) {
        this.nomePT = nomePT;
        this.nomeEN = nomeEN;
        this.modificador = modificador;
    }
    
    public String getNomePT() {return nomePT;}
    public String getNomeEN() {return nomeEN;}
    public AtributosEnum getModificador() {return modificador;}
    
    public static String[] getNomesPericiasPT() {
        int tamanho = values().length;
        String[] valoresPossiveis = new String[tamanho];
        
        for(int i = 0; i < tamanho; i ++) {
            valoresPossiveis[i] = values()[i].nomePT;
        }
        
        return valoresPossiveis;
    }
    public static String[] getNomesPericiasEN() {
        int tamanho = values().length;
        String[] valoresPossiveis = new String[tamanho];
        
        for(int i = 0; i < tamanho; i ++) {
            valoresPossiveis[i] = values()[i].nomeEN;
        }
        
        return valoresPossiveis;
    }
}
