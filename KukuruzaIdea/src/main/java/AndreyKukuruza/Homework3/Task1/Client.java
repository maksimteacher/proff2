package AndreyKukuruza.Homework3.Task1;

public class Client {
    private static int count = 0;
    private static Client[] base = new Client[3];

    private Client() {
    }

    public static Client getInstance(int count) {
        if (count > 3) throw new IndexOutOfBoundsException("Only 3 obj max");
        if (Client.count < 3) {
            Client.count++;
            base[count] = new Client();
        }
        return base[count];
    }
}