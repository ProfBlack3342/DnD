/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exception;

/**
 * Erro que indica que nenhum usuário foi encontrado no banco de dados pelos dados de pesquisa informados
 * @author dudup
 */
public class NoUserFoundException extends Exception {

    /**
     * Creates a new instance of <code>NoUserFoundException</code> without
     * detail message.
     */
    public NoUserFoundException() {
    }

    /**
     * Constructs an instance of <code>NoUserFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoUserFoundException(String msg) {
        super(msg);
    }
}
