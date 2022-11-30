/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat.Cliente.Servidor;
/**
 *
 * @author aleciom
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Atende_Cliente> threads = new ArrayList<>(); 

    public static void main(String[] args) {
        final int PORTA = 5000; // Constante com o numero da porta
        ServerSocket serverSocket;
        Socket clientSocket = null;

        // Criar o socket e fazer o bind
        // try/catch para o tratamento da excessao
        try {
            serverSocket = new ServerSocket(PORTA);
        } catch (Exception e) {
            System.out.println("Porta " + PORTA + " ja esta em uso.");
            return;
        }

        // Aguardar pedido de conexao
        try {
            while (true) {
                System.out.println("Aguardando pedido de conexao...");
                clientSocket = serverSocket.accept(); // Atribuindo o retorno do socket do cliente
                System.out.println("Conectado com " + clientSocket.getInetAddress().getHostAddress());
                Atende_Cliente atendeCli = new Atende_Cliente(clientSocket, threads);
                threads.add(atendeCli);
                atendeCli.start();
            }
        } catch (Exception e) {
            System.out.println("Erro na conexao.");
            System.out.println(e.getMessage());
        }

        // Encerrar conexao
        try {
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
