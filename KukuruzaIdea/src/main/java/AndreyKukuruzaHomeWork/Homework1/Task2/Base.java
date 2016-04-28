package AndreyKukuruzaHomeWork.Homework1.Task2;


import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Base {
    HashSet<User> users = new HashSet<>();

    public Base() {
        addToBase(new User());
        addToBase(new User("olol", "passlol", 20));
    }

    public void addToBase(User user) {
        if (user != null) {
            users.add(user);
        }
    }

    public boolean auth(String login, String pass) {
        return users.contains(new User(login, pass, 20));
    }

    public void usersToFile(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (User user : users) {
                writer.write(user.toFileStream());
            }
        }
    }

    public User[] usersFromFile(String fileName) throws IOException {
        List<User> users = new ArrayList<>();
        try (FileReader fr = new FileReader(fileName);
             Scanner sc = new Scanner(fr)) {
            while (sc.hasNext()) {
                users.add(User.fromFileStream(sc.nextLine()));
            }
        }
        return users.toArray(new User[users.size()]);
    }

    public void serializeToFile(String fileName) throws IOException {
        try (FileOutputStream writer = new FileOutputStream(fileName, false);
             ObjectOutputStream outputStream = new ObjectOutputStream(writer)) {
            for (User user : users) {
                outputStream.writeObject(user);
            }
        }
    }

//    public User[] serializeFromFile(String fileName) throws IOException {
//        List<User> users = new ArrayList<>();
//        try (FileReader fr = new FileReader(fileName);Scanner scan = new Scanner(fr);
//             FileInputStream reader = new FileInputStream(fileName);
//             ObjectInputStream objectInputStream = new ObjectInputStream(reader)) {
//            while (scan.hasNext())
//            {objectInputStream..available()
//                users.add((User).fromFileStream(sc.nextLine()));
//            }
//        }
//        return users.toArray(new User[users.size()]);
//    }
}