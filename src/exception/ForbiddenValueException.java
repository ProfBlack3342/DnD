/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author 181700271
 */
public class ForbiddenValueException extends Exception {

    /**
     * Creates a new instance of <code>InvalidValueException</code> without
     * detail message.
     */
    public ForbiddenValueException() {
    }

    /**
     * Constructs an instance of <code>InvalidValueException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ForbiddenValueException(String msg) {
        super(msg);
    }
}
