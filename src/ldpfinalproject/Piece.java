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

public class Piece implements Serializable {
    private Player owner;
    private Cell position;     // célula atual (null se na casa)
    private boolean isActive;  // se já saiu da casa

    public Piece(Player owner) {
        this.owner = owner;
        this.position = null;
        this.isActive = false;
    }

    public Player getOwner() {
        return owner;
    }

    public Cell getPosition() {
        return position;
    }

    public boolean isActive() {
        return isActive;
    }

    /** Ativa a peça (sai da casa inicial) */
    public void activate(Cell startCell) {
        this.position = startCell;
        this.isActive = true;
        startCell.setOccupant(this);
    }

    /** Move a peça para a célula destino */
    public void moveTo(Cell dest) {
        if (position != null) {
            position.clearOccupant();
        }
        dest.setOccupant(this);
        this.position = dest;
    }

    /** Volta a casa inicial (quando é capturada) */
    public void sendToStart() {
        if (position != null) {
            position.clearOccupant();
        }
        this.position = null;
        this.isActive = false;
    }
}
