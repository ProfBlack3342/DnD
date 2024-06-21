/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import jbcrypt.BCrypt;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class Verificar
{
    /**
     * Compara um texto/senha/código com um hash já existente.<p>
     * @param texto O texto que será comparado com o hash
     * @param hash O hash já existente
     * @return Verdadeiro se forem iguais, falso se não forem
     */
    public static boolean compararTextoComHash(String texto, String hash) {
        return BCrypt.checkpw(texto, hash);
    }
    
    /**
     * Esse método verifica se o usuário digitou um e-mail válido
     * @param c String de entrada com o texto a ser verificado
     * @return true se a entrada for um e-mail, false se não for
     */
    public static boolean verificarEmail(String c) {
        return c.matches("^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$");
    }
    
    /**
     * Esse método verifica se o usuário digitou apenas números inteiros
     * @param c String de entrada com no mínimo 1 e no máximo 8 algoritmos
     * @return true se todos os caracteres da string forem números inteiros; false se não forem
     * @since 1.0
     */
    public static boolean verificarNumeroInteiro(String c)
    {
        return c.matches("^[0-9]{1,8}$");
    }
    
    /**
     * Esse método verifica se o usuário digitou apenas um números real
     * @param c String de entrada
     * @return true se a string for um número real; false se não for
     * @since 1.0
     */
    public static boolean verificarNumeroReal(String c)
    {
        return c.matches("^\\d*[0-9](\\.\\d*[0-9])?$");
    }
    
    /**
     * Esse método verifica se o usuário digitou apenas letras maiúsculas ou minúsculas
     * @param c String de entrada com no mínimo 1 e no máximo 50 caracteres
     * @return true se todos os caracteres da string forem letras maiúsculos/minúsculos; false se não forem
     * @since 1.0
     */
    public static boolean verificarTexto(String c)
    {
        return c.matches("^[a-zA-ZáÁéÉíÍóÓúÚâÂêÊôÔãÃõÕçÇ ]{1,50}$");
    }
    
    /**
     * Esse método verifica se o usuário digitou um texto com letras maiúsculas, minúsculas e números
     * @param c String de entrada com no mínimo 1 e no máximo 50 caracteres
     * @return true se todos os caracteres da string forem letras maiúsculos/minúsculos; false se não forem
     * @since 1.0
     */
    public static boolean verificarTextoComNumeros(String c)
    {
        return c.matches("^[a-zA-Z0-9áÁéÉíÍóÓúÚâÂêÊôÔãÃõÕçÇ ]{1,50}$");
    }
}
