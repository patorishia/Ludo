/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author patri
 */

public class GameClient {
    private Socket socket;

    public void connect(String host, int port) throws IOException {
        socket = new Socket(host, port);
        System.out.println("Ligado ao servidor em " + host + ":" + port);
        // Comunicação com o servidor aqui...
    }
}