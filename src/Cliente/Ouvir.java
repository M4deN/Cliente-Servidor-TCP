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
import java.net.Socket;
import java.util.Scanner;

public class Ouvir extends Thread {
    private Socket socket;
    private Scanner input = null;

    public Ouvir(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            input = new Scanner(socket.getInputStream());
            String mensagem;
            
            do {
                // Recebe mensagem do servidor
                mensagem = input.nextLine();
                System.out.println(mensagem);

            } while (true);
            //input.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
