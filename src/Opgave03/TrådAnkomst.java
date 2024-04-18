package Opgave03;

public class TrådAnkomst extends Thread{
    private Common common;
    private int kundeId;
    private int conCurrentId;

    public TrådAnkomst (Common common, int kundeId){
        this.common = common;
        this.kundeId = kundeId;
    }
    public void run(){
        for (int i = 1; i <= 10; i++) {
            conCurrentId = (kundeId + 1) % 2;
            common.setFlag(true, kundeId);
            common.setTurn(conCurrentId);
            while (common.getFlag(conCurrentId) && common.getTurn() == conCurrentId);
            System.out.println("Kunde nr. " + kundeId + " har fået nummer: " + common.nuværendeNummer());
            common.setFlag(false,kundeId);
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
