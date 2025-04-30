/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;

/**
 *
 * @author patri
 */

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Dice implements Serializable {
    /*@return um valor aleatório entre 1 e 6 */
    public int roll() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}

