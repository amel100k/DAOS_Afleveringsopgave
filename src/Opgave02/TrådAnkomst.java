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
            System.out.println("Kunde nr. " + kundeId + " har fået nummer: " + common.nuværendeNummer());
            semaphore.release();
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int getKundeId() {
        return kundeId;
    }

    public void setKundeId(int kundeId) {
        this.kundeId = kundeId;
    }
}
