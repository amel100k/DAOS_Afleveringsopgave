package Opgave04;

public class Main {
    public static void main(String[] args) {
        Common common = new Common();

        TrådEkspedient trådEkspedient = new TrådEkspedient(common);
        TrådEkspedient trådEkspedient2 = new TrådEkspedient(common);

        TrådAnkomst trådAnkomst = new TrådAnkomst(common,0, "Emil");
        TrådAnkomst trådAnkomst2 = new TrådAnkomst(common,1, "William");

        trådAnkomst.start();
        trådAnkomst2.start();
        trådEkspedient.start();
        trådEkspedient2.start();

        try {
            trådAnkomst.join();
            trådAnkomst2.join();
            trådEkspedient.join();
            trådEkspedient2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Slut");
    }
}
