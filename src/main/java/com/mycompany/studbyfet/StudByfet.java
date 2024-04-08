
package com.mycompany.studbyfet;
import java.util.concurrent.Semaphore;
public class StudByfet {
    public static void main(String[] args) {
        //используем симафор(перекулючатель),чтобы в SvobodTable не сидело больше 2 человек 
        Semaphore SvobodTable = new Semaphore(2); 
        Thread[] students = new Thread[7];

        for (int i = 0; i < 7; i++) {
            students[i]=new Thread(new StudGO(i+1,SvobodTable));
            students[i].start();
        }
        try {
            for (Thread student:students) {
                student.join(); 
            }
        } catch (InterruptedException x) {
            x.printStackTrace();
        }
    }
}
