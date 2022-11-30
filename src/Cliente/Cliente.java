/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
/**
 *
 * @author aleciom
 */
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        final String IP = "127.0.0.1";
        final int PORTA = 5000;
        Socket socket;
        PrintStream output = null;
        Scanner teclado;

        //Criar socket e pedir conexao
        try {
            socket = new Socket(IP, PORTA);
        } catch (Exception e) {
            System.out.println("Nao foi possivel conectar ao servidor.");
            return;
        }

        //Comunicacao
        try {
            output = new PrintStream(socket.getOutputStream());
            teclado = new Scanner(System.in);
            Ouvir escuta = new Ouvir(socket);
            escuta.start();

            String mensagem;
            do {
                System.out.println("Digite a mensagem: ");
                mensagem = teclado.nextLine();
                output.println(mensagem); // Manda mensagem ao servidor
            } while (!mensagem.equalsIgnoreCase("exit"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Encerrar conexao
        try {
            output.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

