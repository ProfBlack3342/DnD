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
     * Converte um score de habilidade no seu modificador equivalente, seguindo a lógica:<p>
     * 1 = −5 <p>
     * 2/3 = −4 <p>
     * 4/5 = −3 <p>
     * 6/7 = −2 <p>
     * 8/9 = −1 <p>
     * 10/11 = +0 <p>
     * 12/13 = +1 <p>
     * 14/15 = +2 <p>
     * 16/17 = +3 <p>
     * 18/19 = +4 <p>
     * 20/21 = +5 <p>
     * 22/23 = +6 <p>
     * 24/25 = +7 <p>
     * 26/27 = +8 <p>
     * 28/29 = +9 <p>
     * 30 = +10 <p>
     * @param scoreHabilidade Um score de habilidade
     * @return O modificador que correspone ao score informado
     * @throws java.lang.Exception Se o score informado não possuir um modificador correspondente
     */
    public static int converterScoreEmModificador(int scoreHabilidade) throws Exception {
        switch(scoreHabilidade) {
            case 1:
                return -5;
            case 2:
            case 3:
                return -4;
            case 4:
            case 5:
                return -3;
            case 6:
            case 7:
                return -2;
            case 8:
            case 9:
                return -1;
            case 10:
            case 11:
                return 0;
            case 12:
            case 13:
                return 1;
            case 14:
            case 15:
                return 2;
            case 16:
            case 17:
                return 3;
            case 18:
            case 19:
                return 4;
            case 20:
            case 21:
                return 5;
            case 22:
            case 23:
                return 6;
            case 24:
            case 25:
                return 7;
            case 26:
            case 27:
                return 8;
            case 28:
            case 29:
                return 9;
            case 30:
                return 10;
            default:
                throw new Exception("Erro em Converter.calcularModificadorHabilidade: Valor inválido informado como score!");
        }
    }
    /**
     * Converte um array com scores de habilidades em um array de modificadores equivalentes<p>
     * @param scoreHabilidade Um array com os scores de habilidade
     * @return Um array com os modificadores equivalentes
     * @throws Exception Se algum score tiver valor inválido
     */
    public static int[] converterScoresEmModificadores(int[] scoreHabilidade) throws Exception {
        int[] modificadores = new int[scoreHabilidade.length];
        
        for(int i = 0; i < scoreHabilidade.length; i++) {
            modificadores[i] = converterScoreEmModificador(scoreHabilidade[i]);
        }
        
        return modificadores;
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
    /**
     * Recebe um valor que representa o total de lados de um dado mais um valor que representa a quantidade de vezes, e retorna um array com valores aleatório entre 1 e o total de lados.<p>
     * Usado para representar várias jogadas com o dado informado<p>
     * @param ladosDado O total de lados no dado a ser jogado
     * @param quantJogadas O total de jogadas a serem feitas
     * @return Um array de valores aleatórios que representam o dado sendo jogado
     */
    public static int[] converterDadoEmJogadas(int ladosDado, int quantJogadas) {
        int[] jogadas;
        
        if(quantJogadas != 1) {
            jogadas = new int[quantJogadas];
            for(int i = 0; i < quantJogadas; i++) {
                jogadas[i] = converterDadoEmJogada(ladosDado);
            }
        }
        else {
            jogadas = new int[]{ converterDadoEmJogada(ladosDado) };
        }
        
        return jogadas;
    }
}
