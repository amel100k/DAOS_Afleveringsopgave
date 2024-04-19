package Opgave04;

public class TrådEkspedient extends Thread{
    private Common common;
    public TrådEkspedient(Common common){
        this.common = common;
    }
    public void run(){
        for (int i = 1; i <= 10 ; i++) {

            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(common.take());
        }
    }
}
