/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
public class TurnSourceNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>TurnSourceNotFoundException</code>
     * without detail message.
     */
    public TurnSourceNotFoundException() {
    }

    /**
     * Constructs an instance of <code>TurnSourceNotFoundException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public TurnSourceNotFoundException(String msg) {
        super(msg);
    }
}
