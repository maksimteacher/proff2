package AndreyKukuruzaHomeWork.Homework4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThreadWriter implements Runnable {
    Object sync;
    String nameFileFrom;

    String nameFileTo;

    public ThreadWriter(Object sync, String nameFileFrom, String nameFileTo) {
        this.sync = sync;
        this.nameFileFrom = nameFileFrom;
        this.nameFileTo = nameFileTo;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Writer");
            synchronized (sync) {
                try {
                    sync.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try (FileWriter fw = new FileWriter(nameFileTo, true);
                 FileReader fr = new FileReader(nameFileFrom);
                 Scanner scanner = new Scanner(fr)) {
                fw.write(scanner.nextLine());
                System.out.println("Write2");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
