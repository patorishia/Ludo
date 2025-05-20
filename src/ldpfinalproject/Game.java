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

public class Game implements Serializable {
    private final List<Player> players;
    private final Board board;
    private final Dice dice;
    private int currentPlayerIndex;
    private boolean isFinished;

    public Game(List<Player> players) {
        if (players.size() < 2 || players.size() > 4) {
            throw new IllegalArgumentException("Número de jogadores deve ser entre 2 e 4.");
        }
        

        this.players = players;
        this.board = new Board();
        this.dice = new Dice();
        this.currentPlayerIndex = 0;
        this.isFinished = false;

        assignColorsToPlayers();
        initPieces();
    }

    private void assignColorsToPlayers() {
        PlayerColor[] availableColors = PlayerColor.values();
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setColor(availableColors[i]);
        }
    }

    private void initPieces() {
        for (Player player : players) {
            player.initPieces();
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public int rollDice() {
        return dice.roll();
    }

    public void nextTurn() {
        if (!isFinished) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    public boolean isGameFinished() {
        return isFinished;
    }

    public void checkForWinner() {
        for (Player player : players) {
            if (player.hasWon()) {
                isFinished = true;
                break;
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public Dice getDice() {
        return dice;
    }

    public void resetGame() {
        board.reset();
        for (Player player : players) {
            player.resetPieces();
        }
        currentPlayerIndex = 0;
        isFinished = false;
    }
}