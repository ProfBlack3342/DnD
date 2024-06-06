/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exception;

/**
 * Erro que indica que nenhum dado foi encontrado no banco de dados pela pesquisa
 * @author Eduardo Pereira Moreira
 */
public class NoDataFoundException extends Exception {

    /**
     * Creates a new instance of <code>NoUserFoundException</code> without
     * detail message.
     */
    public NoDataFoundException() {
    }

    /**
     * Constructs an instance of <code>NoUserFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoDataFoundException(String msg) {
        super(msg);
    }
}
