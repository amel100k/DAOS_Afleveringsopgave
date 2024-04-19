package Opgave04;

public class TrådAnkomst extends Thread{
    private Common common;
    private int kundeId;
    private String navn;

    public TrådAnkomst (Common common, int kundeId, String navn){
        this.common = common;
        this.kundeId = kundeId;
        this.navn = navn;
    }
    public void run(){
        for (int i = 1; i <= 10; i++) {
            common.append(navn + i);

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
