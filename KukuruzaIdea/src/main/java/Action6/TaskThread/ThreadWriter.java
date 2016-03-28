package Action6.TaskThread;

class ThreadWriter implements Runnable {
    Thread thread = null;

    public ThreadWriter() {
        thread = new Thread(this);
    }

    @Override
    public void run() {
        while (true) {
            if (isInterrupted()) break;
        }
        System.out.println("done MyThread3");
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