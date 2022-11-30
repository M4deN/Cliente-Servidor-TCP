/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author aleciom
 */
public class myThread extends Thread { // Heranca

    public myThread(String nome) {
        super(nome);
    }

    // sobrescrita do metodo run - equivalente ao main()
    @Override
    public void run() {
        System.out.println("Thread " + getName() + " iniciou.");

        try {
            sleep(2000); // "dorme" por 2 segundos
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Thread " + getName() + " terminou.");
    }

}
