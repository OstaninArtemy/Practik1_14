
package com.mycompany.studbyfet;
import java.util.concurrent.Semaphore;

public class StudGO implements Runnable {
    private int id;
    private Semaphore table;
    public StudGO(int id, Semaphore table) {
        this.id = id;
        this.table = table;
    }
    @Override
    public void run() {
        try {
            System.out.println("Студент "+id+" waiting");
            table.acquire(); 
            System.out.println("Студент "+ id+" eating");
            Thread.sleep(100); 
            System.out.println("Студент "+id+" exit");
            table.release(); 
        } catch (InterruptedException x) {
            x.printStackTrace();
        }
    }
}
