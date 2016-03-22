package Action6.TaskThread;

import java.util.Scanner;

public class ThreadCreator implements Runnable {
    Thread thread = null;
    String nameFile;
    Object sync;

    public ThreadCreator(Thread thread, String nameFile, Object sync) {
        this.thread = thread;
        this.nameFile = nameFile;
        this.sync = sync;
    }

    @Override
    public void run() {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        while (!str.equals("exit")) {


        }
    }

    public boolean isInterrupted() {
        return thread.isInterrupted();
    }

    public void start() {
        thread.start();
    }

    public void interrupt() {
        thread.interrupt();
    }
}