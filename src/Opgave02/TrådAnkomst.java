package Opgave02;

import java.util.concurrent.Semaphore;

public class TrådAnkomst extends Thread{
    private Common common;
    private int kundeId;
    private int conCurrentId;
    private Semaphore semaphore;

    public TrådAnkomst (Common common, int kundeId, Semaphore semaphore){
        this.common = common;
        this.kundeId = kundeId;
        this.semaphore = semaphore;
    }
    public void run(){
        for (int i = 1; i <= 10; i++) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            common.nuværendeNummer();
            System.out.println("Kunde har fået nummer: " + common.getNuværendeNummer());
            semaphore.release();
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
