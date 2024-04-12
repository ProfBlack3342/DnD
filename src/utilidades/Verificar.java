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
public class Verificar
{
    /**
     * Compara um texto/senha/código com um hash já existente.<p>
     * @param texto O texto que será comparado com o hash
     * @param hash O hash já existente
     * @return Verdadeiro se forem iguais, falso se não forem
     */
    public static boolean compararTextoComHash(String texto, String hash)
    {
        return BCrypt.checkpw(texto, hash);
    }
}
