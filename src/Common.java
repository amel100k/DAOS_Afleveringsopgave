import java.util.Random;

public class Common extends Thread{
    private volatile int nuværendeNummer = 0;
    private volatile int næsteNummerIKø = 0;
    private boolean[] flag = {false, false};
    private volatile int turn = 0;
    public synchronized int fåNæsteNummer(){
        int id = (int) Thread.currentThread().getId() % 2;
        setFlag(true,id);
        turn = 1 - id;
        int næsteNummer = næsteNummerIKø++;
        setFlag(false, id);
        while (flag[1 - id] && turn == (1 - id));
        return næsteNummer;
    }
    public int næsteNummerIKø(){
        return næsteNummerIKø++;
    }
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

    public int getNuværendeNummer() {
        return nuværendeNummer;
    }

    public void setNuværendeNummer(int nuværendeNummer) {
        this.nuværendeNummer = nuværendeNummer;
    }

    public int getNæsteNummerIKø() {
        return næsteNummerIKø;
    }

    public void setNæsteNummerIKø(int næsteNummerIKø) {
        this.næsteNummerIKø = næsteNummerIKø;
    }
    public void setFlag(boolean b, int id) {
        this.flag[id] = b;
    }
    public boolean getFlag(int conCurrentId) {
        return flag[conCurrentId];
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
