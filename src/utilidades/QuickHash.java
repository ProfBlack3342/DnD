/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utilidades;

import java.util.Scanner;

/**
 *
 * @author Eduardo Pereira Moreira
 */
public final class QuickHash {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String senha = entrada.nextLine();
        System.out.println(Converter.converterTextoParaHash(senha));
    }
}
