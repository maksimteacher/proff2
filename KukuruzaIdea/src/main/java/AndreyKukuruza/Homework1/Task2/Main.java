package AndreyKukuruza.Homework1.Task2;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Base base = new Base();
        for (int i = 0; i < 5; i++) {
            base.addToBase(new User(i + "", i + "", i));
        }
        try {
            base.usersToFile("C:\\Users\\Administrator\\IdeaProjects\\lesson2\\Homework1\\src\\com\\company\\Task2\\users.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        User[] usersFromFile = base.usersFromFile("C:\\Users\\Administrator\\IdeaProjects\\lesson2\\Homework1\\src\\com\\company\\Task2\\users.txt");
        for (User user : usersFromFile) {
            System.out.println(user);
        }
        try {
            base.serializeToFile("C:\\Users\\Administrator\\IdeaProjects\\lesson2\\Homework1\\src\\com\\company\\Task2\\users2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
