package AndreyKukuruzaHomeWork.Homework4;

public class Monitor implements Runnable {
    Object sync = new Object();
    ThreadCreator threadCreator = new ThreadCreator(sync, "File.txt");
    ThreadWriter threadWriter = new ThreadWriter(sync, "File.txt", "File2.txt");

    @Override
    public void run() {
        Thread t1 = new Thread(threadCreator);
        Thread t2 = new Thread(threadWriter);
        t2.setDaemon(true);
        t1.start();
        t2.start();

    }
}
