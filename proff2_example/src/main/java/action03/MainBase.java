package action03;

import java.util.Scanner;

@SuppressWarnings("resource")
public class MainBase {
	public static String[] menu1 = new String[]{"Инициализация из набора данных", "Инициализация из файла"};
	public static String[] menu2 = new String[]{"Добавить нового пользователя", "Отобразить список пользователей"
			,"Сохранить пользователей в файл", "Проверить пользователя", "Выход"};
	public final static String fileName = "file1.us";
	public static Base base = null;
	
	public static void main(String[] args) {
		
		int k = printMenu(menu1);
		if(k==1) base = new Base();
		else if(k==2) base = new Base(fileName);
		while(base!=null){
			switch (printMenu(menu2)){
				case 1: addUser();break;
				case 2: base.printAllUsers();break;
				case 3: base.usersToFile(fileName);break;
				case 4: checkUser();break;
				case 5: base=null;
			}
		}
	}
	public static void addUser(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите логин:");
		String s1 = scan.next();
		System.out.println("Введите пароль:");
		String s2 = scan.next();
		base.addUser(new User(s1, s2));
	}
	public static int printMenu(String[] menu){
		System.out.println("Список операций:");
		for(int i = 0; i< menu.length;i++){
			System.out.println(i+1+". "+menu[i]);
		}
		System.out.println("Выберите операцию:");
		Scanner scan = new Scanner(System.in);
		if(scan.hasNextInt()){
			System.out.println();
			return scan.nextInt();
		} else {
			scan.hasNext();
		}
		System.out.println();
		return 0;
	}
	public static void checkUser(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите логин:");
		String s1 = scan.next();
		System.out.println("Введите пароль:");
		String s2 = scan.next();
		boolean isAuth = base.auth(s1, s2);
		if(isAuth)System.out.println("\tесть такой пользователь\n");
		else System.out.println("\tнет такого пользователя\n");		
	}
}
