/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;

/**
 *
 * @author patri
 */
// GameSaver.java
import java.io.*;

public class GameSaver {
    /**
     * Serializa o estado de Game para um ficheiro.
     * @param game
     * @param file
     * @throws java.io.IOException
     */
    public void saveGame(Game game, File file) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(game);
            System.out.println("Game saved to " + file.getPath());
        }
    }

    /**
     * Desserializa o estado de Game a partir de um ficheiro.
     * @param file
     * @return 
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public Game loadGame(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Game game = (Game) in.readObject();
            System.out.println("Game loaded from " + file.getPath());
            return game;
        }
    }
}

