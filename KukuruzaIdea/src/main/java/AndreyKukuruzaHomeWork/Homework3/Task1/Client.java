package AndreyKukuruzaHomeWork.Homework3.Task1;

public class Client {
    private static final int MAX_CLIENTS = 3;
    private static int count = 0;
    private static Client[] base = new Client[MAX_CLIENTS];

    private Client() {
    }

    public static Client getInstance(int count) {
        if (count > MAX_CLIENTS) {
            throw new IndexOutOfBoundsException("Only " + MAX_CLIENTS + " obj max");
        }
        if (Client.count < MAX_CLIENTS) {
            Client.count++;
            base[count] = new Client();
        }
        return base[count];
    }
}