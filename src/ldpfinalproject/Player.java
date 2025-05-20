/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author patri
 */

public class Player implements Serializable {
    private String name;
    private PlayerColor color;
    private List<Piece> pieces;

public Player(String name, PlayerColor color) {
        this.name = name;
        this.color = color;
        this.pieces = new ArrayList<>();
        // Inicializa as 4 peças na "casa"
        for (int i = 0; i < 4; i++) {
            pieces.add(new Piece(this));
        }
}
public Player(String name) {
    this.name = name;
    this.pieces = new ArrayList<>();
}

public void setColor(PlayerColor color) {
    this.color = color;
    this.pieces.clear();  // reinicializa com cor definida
    for (int i = 0; i < 4; i++) {
        pieces.add(new Piece(this));
    }
}
    public String getName() {
        return name;
    }

    public PlayerColor getColor() {
        return color;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    /**  Lança o dado
     * @param dice 
     * @return de 1 a 6 */
    public int rollDice(Dice dice) {
        return dice.roll();
    }

    /** Move uma peça específica um certo número de casas
     * @param piece
     * @param steps
     * @param board */
    public void movePiece(Piece piece, int steps, Board board) {
        board.movePiece(piece, steps);
    }
    
    public void initPieces() {
    pieces.clear();
    for (int i = 0; i < 4; i++) {
        pieces.add(new Piece(this));
    }
}

    public void resetPieces() {
    for (Piece piece : pieces) {
        piece.sendToStart();
    }
}
    
    public boolean hasWon() {
    for (Piece piece : pieces) {
        if (!piece.isActive() || piece.getPosition() == null) {
            return false;
        }
    }
    return true; // Ganha quando todas as peças chegaram ao fim (ajusta a lógica conforme teu jogo)
}


}
