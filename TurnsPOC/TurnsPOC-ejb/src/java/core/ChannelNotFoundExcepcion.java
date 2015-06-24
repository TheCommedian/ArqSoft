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
public class ChannelNotFoundExcepcion extends Exception {

    /**
     * Creates a new instance of <code>ChannelNotFoundExcepcion</code> without
     * detail message.
     */
    public ChannelNotFoundExcepcion() {
    }

    /**
     * Constructs an instance of <code>ChannelNotFoundExcepcion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ChannelNotFoundExcepcion(String msg) {
        super(msg);
    }
}
