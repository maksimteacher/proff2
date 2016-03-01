package action03;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

/*
создать класс пользователь с полями:логин,пароль,кол-во дней до истечения пароля.
написать метод, в который передается логин и пароль пользователя.
метод проверяет авторизирован пользователь или нет.
* */

/*
 Домашнее задание:
В класс Base добавить метод
- void usersToFile(String fileName)
- User[] usersFromFile(String fileName)
- void usersSerializeToFile(User[] users,String fileName)
- User[] usersDeSerializeFromFile(String fileName) 

*/
public class Base {
	Set<User> users;

	public Base() {
		users = new HashSet<>();
		users.add(new User("user1", "1", 2));
		users.add(new User("user2", "1", 3));
		users.add(new User("user3", "1", 4));
	}

	public Base(String file) {
		User[] arrUsers = Base.usersFromFile(file);
		users = new HashSet<>(Arrays.asList(arrUsers));
	}

	public boolean auth(String login, String pass) {
		for (User user : users) {
			if (user.equals(new User(login, pass)))
				return true;
		}
		return false;
	}

	public void usersToFile(String fileName) {
		try (FileWriter fw = new FileWriter(fileName);) {
			for (User user : users) {
				fw.write(user.toFileStream());
			}
		} catch (Exception e) {
		}
	}

	public static User[] usersFromFile(String fileName) {
		List<User> list = new ArrayList<>();
		try (FileReader fr = new FileReader(fileName); Scanner scan = new Scanner(fr);) {
			while (scan.hasNextLine()) {
				User user = User.fromFileStream(scan.nextLine());
				if (user != null)
					list.add(user);
			}
		} catch (Exception e) {
		}
		// return (User[]) list.toArray();
		
		return list.toArray(new User[0]);

	}

	public void addUser(User user) {
		if (user != null)
			users.add(user);
	}

	public void printAllUsers() {
		// users.forEach(user->System.out.print(user+"\n"));
		if (users != null && users.size()>0) {
			System.out.println("Список пользователей:");
			users.forEach(new Consumer<User>() {
				@Override
				public void accept(User user) {
					System.out.print(user + "\n");
				}
			});
		} else System.out.println("Список пользователей пуст");
		System.out.println();
	}
}
