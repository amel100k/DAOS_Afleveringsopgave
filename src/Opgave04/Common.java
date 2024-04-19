package Opgave04;

import java.util.Random;

public class Common extends Thread{
    private int nuværendeNummer = 0;
    private int sidsteNummer = 0;
    private boolean[] flag = {false, false};
    private volatile int turn = 0;
    private String[] buffer = new String[20];
    private int nextin = 0;
    private int nextout = 0;
    private int count = 0;

    public void TagerRanTid (int max)
    {
        int x,y;
        Random r = new Random(1023);
        int max2 = Math.abs(r.nextInt()) % max +1;
        for (int j=0; j<max2; j++) {
            for (int i=0; i<max2; i++) {
                x = i + j;
                y = i - j;
            }
        }
    }
    public synchronized void append(String x){
        while (count == buffer.length){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        buffer[nextin] = x;
        nextin = (nextin + 1) % buffer.length;
        count++;
        notifyAll();
        System.out.println("I kø: " + x.toString());
    }
    public synchronized String take(){
        String x;
        while (count == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        x = buffer[nextout];
        nextout = (nextout + 1) % buffer.length;
        count--;
        notifyAll();
        return "Bliver nu ekspederet: " + x;
    }
}
