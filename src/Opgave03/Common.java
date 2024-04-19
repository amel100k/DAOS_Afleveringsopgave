package Opgave03;

import java.util.Random;

public class Common extends Thread{
    private int nuværendeNummer = 0;
    private int sidsteNummer = 0;
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

    public synchronized void nuværendeNummer(){
        nuværendeNummer++;
        notify();
        System.out.println("Kunde har fået nummer: " + nuværendeNummer);
    }
    public synchronized void bagerNummer(){
        if (sidsteNummer == nuværendeNummer){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Bageren er ved at ekspedere " + (sidsteNummer + 1));
        setSidsteNummer(sidsteNummer + 1);
    }
    public int getNuværendeNummer() {
        return nuværendeNummer;
    }
    public void setNuværendeNummer(int nuværendeNummer) {
        this.nuværendeNummer = nuværendeNummer;
    }
    public int getSidsteNummer() {
        return sidsteNummer;
    }
    public void setSidsteNummer(int sidsteNummer) {
        this.sidsteNummer = sidsteNummer;
    }
}
