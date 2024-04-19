package Opgave03;

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

            common.bagerNummer();
        }
    }
}
