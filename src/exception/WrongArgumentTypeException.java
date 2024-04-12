/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * Erro que indica a passagem de um argumento com tipo incorreto
 * @author 181700271
 */
public class WrongArgumentTypeException extends Exception {

    /**
     * Creates a new instance of <code>WrongArgumentTypeException</code> without
     * detail message.
     */
    public WrongArgumentTypeException() {
    }

    /**
     * Constructs an instance of <code>WrongArgumentTypeException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public WrongArgumentTypeException(String msg) {
        super(msg);
    }
}
