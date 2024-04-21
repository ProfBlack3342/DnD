/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;

import jbcrypt.BCrypt;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class Converter
{
    private static final SimpleDateFormat SDF_SQLDATE = new SimpleDateFormat("YYYY-MM-dd");
    
    /**
     * Converte um texto/senha/código em um hash.<p>
     * Gera um código único a cada uso, se quiser comparar hashes use Verificar.compararTextoComHash
     * @param texto O texto que será convertido em hash
     * @return O hash criada a partir do texto
     */
    public static String converterTextoParaHash(String texto) {
        return BCrypt.hashpw(texto, BCrypt.gensalt(12));
    }
    
    private static String converterDiaMesAnoParaString(String dia, String mes, String ano) {
        return ano + "-" + mes + "-" + dia;
    }
    private static java.sql.Date converterStringParaSQLDate(String data) {
        return java.sql.Date.valueOf(data);
    }
    /**
     * Converte um dia, mes e ano para o formato SQLDate
     * @param dia O dia do mês como String
     * @param mes O mês do ano como String
     * @param ano O ano como String
     * @return A data formatada como SQLDate
     */
    public static java.sql.Date converterDiaMesAnoParaSQLDate(String dia, String mes, String ano) {
        return converterStringParaSQLDate(converterDiaMesAnoParaString(dia, mes, ano));
    }
    private static String converterSQLDateParaString(java.sql.Date dataSQL) {
        return SDF_SQLDATE.format(dataSQL);
    }
    /**
     * Converte uma data em SQLDate para uma String
     * @param dataSQL A data em SQLDate
     * @return A data em uma String
     */
    public static String[] converterStringParaDiaMesAno(String dataSQL) {
        return new String[] { dataSQL.substring(8), dataSQL.substring(5, 7), dataSQL.substring(0, 4) };
    }
    /**
     * Converte uma data em String para três Strings de dia, mes e ano
     * @param dataSQL A data inteira em uma String
     * @return Um array de Strings com os valores em de dia, mes e ano separados
     */
    public static String[] converterSQLDateParaDiaMesAno(java.sql.Date dataSQL) {
        return converterStringParaDiaMesAno(converterSQLDateParaString(dataSQL));
    }
    
    /**
     * Converte um score de habilidade no seu modificador equivalente:<p>
     * @param scoreHabilidade Um score de habilidade
     * @return O modificador que corresponde ao score informado
     */
    public static int converterScoreEmModificador(int scoreHabilidade){
       return (int) Math.floor( (scoreHabilidade - 10) / 2 );
    }
    
    /**
     * Recebe um valor que representa o total de lados de um dado e retorna um valor aleatório entre 1 e o total de lados.<p>
     * Usado para representar uma jogada com o dado informado<p>
     * @param ladosDado O total de lados no dado a ser jogado
     * @return Um valor aleatório que representa o dado sendo jogado
     */
    public static int converterDadoEmJogada(int ladosDado) {
        return ( (new SecureRandom().nextInt(ladosDado)) + 1 );
    }
}
