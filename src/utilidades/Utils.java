package utilidades;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import jbcrypt.BCrypt;

public class Utils {
    private static final int MAIOR_IDADE_POSSIVEL = 120;
    private static final int MAIOR_MES_VALIDO_ABSOLUTO = 12;
    private static final int MENOR_MES_VALIDO = 1;
    private static final int MAIOR_DIA_VALIDO_ABSOLUTO = 31;
    private static final int MENOR_DIA_VALIDO = 1;

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
    
    /**
     * Compara um texto/senha/código com um hash já existente.<p>
     * @param texto O texto que será comparado com o hash
     * @param hash O hash já existente
     * @return Verdadeiro se forem iguais, falso se não forem
     */
    public static boolean compararTextoComHash(String texto, String hash) {
        return BCrypt.checkpw(texto, hash);
    }

    // Conversões para SQL Date
    private static String converterDiaMesAnoParaString(String dia, String mes, String ano) {
        return ano + "-" + mes + "-" + dia;
    }
    private static java.sql.Date converterStringParaSQLDate(String data) {
        return java.sql.Date.valueOf(data);
    }

    public static java.sql.Date converterDiaMesAnoParaSQLDate(String dia, String mes, String ano) {
        return converterStringParaSQLDate(converterDiaMesAnoParaString(dia, mes, ano));
    }

    private static String converterSQLDateParaString(java.sql.Date dataSQL) {
        return SDF_SQLDATE.format(dataSQL);
    }
    private static String[] converterStringParaDiaMesAno(String dataEmStringEmFormatacaoSQL) {
        return new String[] { dataEmStringEmFormatacaoSQL.substring(8), dataEmStringEmFormatacaoSQL.substring(5, 7), dataEmStringEmFormatacaoSQL.substring(0, 4) };
    }
    
    public static String[] converterSQLDateParaDiaMesAno(java.sql.Date dataSQL) {
        return converterStringParaDiaMesAno(converterSQLDateParaString(dataSQL));
    }

    public static int getMaiorAnoValido() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    public static int getMenorAnoValido() {
        return getMaiorAnoValido() - MAIOR_IDADE_POSSIVEL;
    }

    private static int getMaiorMesValido(int mesAtual, int ano, int anoAtual) {
        if(ano == anoAtual)
            return mesAtual;
        else
            return MAIOR_MES_VALIDO_ABSOLUTO;
    }
    public static int getMaiorMesValido(int ano) {
        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);
        int mesAtual = calendario.get(Calendar.MONTH) + 1;

        return getMaiorMesValido(mesAtual, ano, anoAtual);
    }
    public static int getMenorMesValido() {
        return MENOR_MES_VALIDO;
    }

    private static int getMaiorDiaValido(int diaAtual, int mes, int mesAtual, int ano, int anoAtual) {
        // Se o ano e o mês informados forem os atuais, o último dia do mês é o dia atual.
        if(ano == anoAtual && mes == mesAtual)      
            return diaAtual;
        else {
            /*
            * Se o mês informado for de Janeiro até Julho:
            * 
            * 1 - Se esse mês for Fevereiro, testamos o ano para ver se ele é bissexto:
            * - Se o ano for bissexto, o último dia de Fevereiro é 29;
            * - Se o ano não for bissexto, o último dia de Fevereiro é 28;
            * 
            * 2 - Se for Abril ou Junho, o último dia do mês é 30;
            * 
            * 3 - Se esse mês for Janeiro, Março, Maio ou Julho, o último dia do mês é 31.
            *
            */
            if(mes <= 7) {                                   
                if(mes % 2 == 0) {                         
                    if(mes == 2) {                                      
                        boolean isBissexto;

                        if(ano % 4 == 0)
                            isBissexto = (ano % 100) != 0;      // Se o ano for divisível por 4 e não for divisível por 100, ele é bissexto.
                        else
                            isBissexto = (ano % 400) == 0;      // Se o ano não for divisível por 4, mas for divisível por 400, ele é bissexto.

                        return isBissexto ? 29 : 28;   
                    }
                    else {
                        return 30;  
                    }                       
                }
                else {
                    return 31;
                }
            }
            else {
            /*
            * Se o mês informado for de Agosto até Dezembro:
            * 
            * 1 - Se for um mês par, o último dia do mês é 31;
            * 
            * 2 - Se for um mês impar, o último dia do mês é 30.
            * 
            */
                return mes % 2 == 0 ? 31 : 30;
            }

        }
    }
    public static int getMaiorDiaValido(int mes, int ano) {
        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);
        int mesAtual = calendario.get(Calendar.MONTH) + 1;
        int diaAtual = calendario.get(Calendar.DAY_OF_MONTH);

        return getMaiorDiaValido(diaAtual, mes, mesAtual, ano, anoAtual);
    }
    public static int getMenorDiaValido() {
        return MENOR_DIA_VALIDO;
    }

    public static boolean verificarSeAnoValido(int ano) {
        if((ano >= getMenorAnoValido()) && (ano <= getMaiorAnoValido()))
            return true;
        else
            return false;
    }
    public static boolean verificarSeMesValido(int mes, int ano) {
        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);
        int mesAtual = calendario.get(Calendar.MONTH) + 1;

        if((mes >= getMenorMesValido()) && (mes <= getMaiorMesValido(mesAtual, ano, anoAtual)))
            return true;
        else
            return false;
    }
    public static boolean verificarSeDiaValido(int dia, int mes, int ano) {
        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);
        int mesAtual = calendario.get(Calendar.MONTH) + 1;
        int diaAtual = calendario.get(Calendar.DAY_OF_MONTH);

        if((dia >= getMenorDiaValido()) && (dia <= getMaiorDiaValido(diaAtual, mes, mesAtual, ano, anoAtual)))                        
            return false;
        else
            return false;
    }

    public static boolean verificarSeDataValida(int dia, int mes, int ano) {
        return verificarSeAnoValido(ano) && verificarSeMesValido(mes, ano) && verificarSeDiaValido(dia, mes, ano);
    }
    public static boolean verificarSeDataValida(Date dataMySQL) {
        String[] diaMesAno = Utils.converterSQLDateParaDiaMesAno(dataMySQL);
        return verificarSeDataValida(Integer.parseInt(diaMesAno[0]), Integer.parseInt(diaMesAno[1]), Integer.parseInt(diaMesAno[2]));
    }
    
    /**
     * Esse método verifica se o usuário digitou um e-mail válido
     * @param c String de entrada com o texto a ser verificado
     * @return true se a entrada for um e-mail, false se não for
     */
    public static boolean verificarSeEmail(String c) {
        return c.matches("^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$");
    }
    
    /**
     * Esse método verifica se o usuário digitou apenas números inteiros
     * @param c String de entrada com no mínimo 1 e no máximo 8 algoritmos
     * @return true se todos os caracteres da string forem números inteiros; false se não forem
     * @since 1.0
     */
    public static boolean verificarSeNumeroInteiro(String c)
    {
        return c.matches("^[0-9]{1,8}$");
    }
    
    /**
     * Esse método verifica se o usuário digitou apenas um números real
     * @param c String de entrada
     * @return true se a string for um número real; false se não for
     * @since 1.0
     */
    public static boolean verificarSeNumeroReal(String c)
    {
        return c.matches("^\\d*[0-9](\\.\\d*[0-9])?$");
    }
    
    /**
     * Esse método verifica se o usuário digitou apenas letras maiúsculas ou minúsculas
     * @param c String de entrada com no mínimo 1 e no máximo 50 caracteres
     * @return true se todos os caracteres da string forem letras maiúsculos/minúsculos; false se não forem
     * @since 1.0
     */
    public static boolean verificarSeTexto(String c)
    {
        return c.matches("^[a-zA-ZáÁéÉíÍóÓúÚâÂêÊôÔãÃõÕçÇ ]{1,50}$");
    }
    
    /**
     * Esse método verifica se o usuário digitou um texto com letras maiúsculas, minúsculas e números
     * @param c String de entrada com no mínimo 1 e no máximo 50 caracteres
     * @return true se todos os caracteres da string forem letras maiúsculos/minúsculos; false se não forem
     * @since 1.0
     */
    public static boolean verificarSeTextoComNumeros(String c)
    {
        return c.matches("^[a-zA-Z0-9áÁéÉíÍóÓúÚâÂêÊôÔãÃõÕçÇ ]{1,50}$");
    }
}
