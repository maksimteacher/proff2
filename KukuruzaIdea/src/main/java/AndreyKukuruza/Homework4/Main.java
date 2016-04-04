package AndreyKukuruza.Homework4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        new Thread(monitor).start();
    }
}
