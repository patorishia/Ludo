/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;

import java.io.Serializable;
import java.util.Optional;

/**
 *
 * @author patri
 */



public class Cell implements Serializable {
    public enum CellType { NORMAL, START, HOME }

    private int index;
    private CellType type;
    private PlayerColor color;    // null se tipo NORMAL
    private Piece occupant;       // peça que estiver aqui, ou null

 
    public Cell(int index, CellType type, PlayerColor color) {
        this.index = index;
        this.type = type;
        this.color = color;
        this.occupant = null;
    }

    public int getIndex() {
        return index;
    }

    public CellType getType() {
        return type;
    }

    public Optional<PlayerColor> getColor() {
        return Optional.ofNullable(color);
    }

    public Optional<Piece> getOccupant() {
        return Optional.ofNullable(occupant);
    }

    public boolean isOccupied() {
        return occupant != null;
    }

    public void setOccupant(Piece piece) {
        this.occupant = piece;
    }

    public void clearOccupant() {
        this.occupant = null;
    }
}