/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;

/**
 *
 * @author patri
 */
public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void playTurn(Piece piece) {
        Player current = game.getCurrentPlayer();
        int roll = game.rollDice();

        current.movePiece(piece, roll, game.getBoard());

        game.checkForWinner();
        if (!game.isGameFinished() && roll != 6) {
            game.nextTurn();
        }
    }

    public Game getGame() {
    return game;
}
}


