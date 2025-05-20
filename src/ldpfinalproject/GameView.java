/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author patri
 */
public class GameView extends VBox {
    private GameController controller;
    private Label status;

    public GameView(GameController controller) {
    this.controller = controller;
    this.status = new Label("Jogo iniciado.");
    Button diceButton = new Button("Lançar dado");
    diceButton.setOnAction(e -> {
        Player player = controller.getGame().getCurrentPlayer();
        Piece piece = player.getPieces().get(0);
        controller.playTurn(piece);
        status.setText("Turno de " + controller.getGame().getCurrentPlayer().getName());
    });
    getChildren().addAll(status, diceButton);
}

}


