package AndreyKukuruzaHomeWork.Homework4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThreadCreator implements Runnable {
    Object sync;
    String nameFile;

    public ThreadCreator(Object sync, String nameFile) {
        this.sync = sync;
        this.nameFile = nameFile;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Creator");
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("exit")) break;
            try (FileWriter fw = new FileWriter(nameFile)) {
                fw.write(line);
                System.out.println("Write1");
                synchronized (sync) {
                    sync.notify();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
