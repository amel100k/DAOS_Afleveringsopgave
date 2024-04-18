public class Main {
    public static void main(String[] args) {
        Common common = new Common();
        TrådAnkomst trådAnkomst = new TrådAnkomst(common,0);
        TrådAnkomst trådAnkomst1 = new TrådAnkomst(common,1);
        trådAnkomst.start();
        trådAnkomst1.start();
    }
}
