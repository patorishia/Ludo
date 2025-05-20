/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package ldpfinalproject;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author patri
 */
public class LDPFinalProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Criar jogadores
        Player player1 = new Player("Jogador 1");
        Player player2 = new Player("Jogador 2");

        // Inicializar jogo com 2 jogadores (podes adaptar para 3 ou 4)
        List<Player> players = Arrays.asList(player1, player2);
        Game game = new Game(players);

        // Criar controlador principal
        GameController controller = new GameController(game);

        // Criar interface gráfica principal (GameView ou BoardPane)
        GameView gameView = new GameView(controller);

        // Criar e configurar a cena
        Scene scene = new Scene(gameView, 800, 800); // ajusta o tamanho conforme o layout
        primaryStage.setTitle("Jogo Ludo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // inicia a aplicação JavaFX
    }
}
