/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;
import java.io.Serializable;
/**
 *
 * @author patri
 */

public class Move implements Serializable {
    private final Player player;
    private final Piece piece;
    private final int steps;

    public Move(Player player, Piece piece, int steps) {
        this.player = player;
        this.piece = piece;
        this.steps = steps;
    }

    public Player getPlayer() { return player; }
    public Piece getPiece() { return piece; }
    public int getSteps() { return steps; }

    @Override
    public String toString() {
        return player.getName() + " moveu a peça " + steps + " casas.";
    }
}

