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
public class AppThread {
    public static void main(String[] args) {
        myThread t1 = new myThread("T1");
        myThread t2 = new myThread("T2");
        myThread t3 = new myThread("T3");

        t1.start();
        t2.start();
        t3.start();



        System.out.println("Final do main");
    }
}
