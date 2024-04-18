package Opgave02;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Common common = new Common();
        Semaphore semaphore = new Semaphore(1);

        TrådEkspedient trådEkspedient = new TrådEkspedient(common);

        TrådAnkomst trådAnkomst = new TrådAnkomst(common,0, semaphore);
        TrådAnkomst trådAnkomst1 = new TrådAnkomst(common,1, semaphore);

        trådEkspedient.start();
        trådAnkomst.start();
        trådAnkomst1.start();
    }
}
