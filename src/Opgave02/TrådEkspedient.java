package Opgave02;

public class TrådEkspedient extends Thread{
    private Common common;
    public TrådEkspedient(Common common){
        this.common = common;
    }
    public void run(){
        for (int i = 1; i <= 19 ; i++) {
            int sidsteNummer = common.getSidsteNummer();
            System.out.println("Bageren er ved at ekspedere " + (sidsteNummer + 1));
            common.setSidsteNummer(sidsteNummer + 1);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
