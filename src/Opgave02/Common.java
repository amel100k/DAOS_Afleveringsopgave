package Opgave02;

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

    public int getSidsteNummer() {
        return sidsteNummer;
    }

    public void setSidsteNummer(int sidsteNummer) {
        this.sidsteNummer = sidsteNummer;
    }
    public void nuværendeNummer(){
        nuværendeNummer++;
    }

    public int getNuværendeNummer() {
        return nuværendeNummer;
    }

    public void setNuværendeNummer(int nuværendeNummer) {
        this.nuværendeNummer = nuværendeNummer;
    }
}
