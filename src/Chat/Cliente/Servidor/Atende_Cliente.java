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
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Atende_Cliente extends Thread {
    private Socket cliente;
    private Scanner input = null;
    private PrintStream output = null;
    private ArrayList<Atende_Cliente> threads = new ArrayList<>(); 

    // Receber o cliente
    public Atende_Cliente(Socket cliente, ArrayList<Atende_Cliente> threads) {
        this.cliente = cliente;
        this.threads = threads;
    }

    @Override
    public void run() {
        // Comunicacao
        try {
            // Ler as mensagens dentro deste canal de comunicacao
            input = new Scanner(cliente.getInputStream());
            output = new PrintStream(cliente.getOutputStream());

            // Enviar a mensagem dentro deste canal de comunicacao
            String mensagem;
            do {
                mensagem = input.nextLine();
                System.out.println("Recebido: " + mensagem);
                for (Atende_Cliente atendeCli : threads) {
                    atendeCli.enviaMensagem(mensagem);
                }      

            } while (!mensagem.equalsIgnoreCase("exit"));

            System.out.println("Conexao encerrada com " + cliente.getInetAddress().getHostAddress());
            
            input.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void enviaMensagem(String mensagem) {
        output.println("> " + mensagem); // Printa  mensagem recebida
    }

}
