package Action6.TaskThread;

public class Monitor {
    private String nameFile1, nameFile2;
    private ThreadWriter threadWriter;
    private ThreadCreator threadCreator;
    private Object sync = new Object();

    public Monitor(String nameFile1, String nameFile2) {
        this.nameFile1 = nameFile1;
        this.nameFile2 = nameFile2;
       // threadCreator =
    }

}
