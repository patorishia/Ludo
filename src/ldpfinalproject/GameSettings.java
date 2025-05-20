/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;

/**
 *
 * @author patri
 */
public class GameSettings {
    private int playerCount;
    private boolean fastStartEnabled;

    public GameSettings(int playerCount, boolean fastStartEnabled) {
        this.playerCount = playerCount;
        this.fastStartEnabled = fastStartEnabled;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public boolean isFastStartEnabled() {
        return fastStartEnabled;
    }

    public void setFastStartEnabled(boolean fastStartEnabled) {
        this.fastStartEnabled = fastStartEnabled;
    }

    /**
     * Validações:
     * - Jogadores entre 2 e 4
     * @return 
     */
    public boolean validateSettings() {
        return playerCount >= 2 && playerCount <= 4;
    }
}
