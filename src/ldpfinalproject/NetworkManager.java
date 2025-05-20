/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ldpfinalproject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author patri
 */

public class NetworkManager {
    private Socket socket;
    
    public NetworkManager(Socket socket) {
        this.socket = socket;
    }
    
    
    /**
     * Conecta na rede local para partida multijogador.
     */
    public void connect() {
        // TODO: implementar sockets ou RMI
        System.out.println("Connected to local network.");
    }

    /**
     * Envia um objeto Move (representa um movimento de peça) ao(s) outro(s) cliente(s).
     * @param move
     */
    public void sendMove(Move move) {
        // TODO: serializar e enviar via socket
        System.out.println("Move sent: " + move);
    }

    public void receiveMove() throws IOException, ClassNotFoundException {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Move move = (Move) in.readObject();
            System.out.println("Recebido: " + move);
        }
}
