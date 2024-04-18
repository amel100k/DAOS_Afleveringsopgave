package Opgave01;

import Opgave01.Common;

public class TrådEkspedient extends Thread{
    private Common common;
    public TrådEkspedient(Common common){
        this.common = common;
    }
    public void run(){
        for (int i = 1; i <= 20 ; i++) {

            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (common.getSidsteNummer() == common.getNuværendeNummer());

            System.out.println("Bageren er ved at ekspedere " + (common.getSidsteNummer() + 1));
            common.setSidsteNummer(common.getSidsteNummer() + 1);
        }
    }
}
