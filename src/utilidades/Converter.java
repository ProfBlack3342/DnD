/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.text.SimpleDateFormat;

import jbcrypt.BCrypt;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public class Converter
{
    private static final SimpleDateFormat SDF_SQLDATE = new SimpleDateFormat("YYYY-MM-dd");
    
    /**
     * Converte um texto/senha/código em um hash.<p>
     * Gera um código único a cada uso, se quiser comparar hashes use Verificar.compararTextoComHash
     * @param texto O texto que será convertido em hash
     * @return O hash criada a partir do texto
     */
    public static String converterTextoParaHash(String texto)
    {
        return BCrypt.hashpw(texto, BCrypt.gensalt(12));
    }
    
    private static String converterDiaMesAnoParaString(String dia, String mes, String ano) {
        return ano + "-" + mes + "-" + dia;
    }
    private static java.sql.Date converterStringParaSQLDate(String data) {
        return java.sql.Date.valueOf(data);
    }
    /**
     * 
     * @param dia
     * @param mes
     * @param ano
     * @return 
     */
    public static java.sql.Date converterDiaMesAnoParaSQLDate(String dia, String mes, String ano)
    {
        return converterStringParaSQLDate(converterDiaMesAnoParaString(dia, mes, ano));
    }
    
    private static String converterSQLDateParaString(java.sql.Date dataSQL) {
        return SDF_SQLDATE.format(dataSQL);
    }
    private static String[] converterStringParaDiaMesAno(String dataSQL) {
        return new String[] {
            dataSQL.substring(8), dataSQL.substring(5, 7), dataSQL.substring(0, 4)
        };
    }
    /**
     * 
     * @param dataSQL
     * @return 
     */
    public static String[] converterSQLDateParaDiaMesAno(java.sql.Date dataSQL)
    {
        return converterStringParaDiaMesAno(converterSQLDateParaString(dataSQL));
    }
}
