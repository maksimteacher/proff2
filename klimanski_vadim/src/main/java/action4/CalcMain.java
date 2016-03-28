package action4;

import java.util.Scanner;

public class CalcMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите первое число:");
		int n1 = sc.nextInt();
		System.out.println("Введите знак операции:");
		String op = sc.next();
		System.out.println("Введите второе число:");
		int n2 = sc.nextInt();
		sc.close();
		System.out.println("Результат:" + Calc.metodCalc(n1, op, n2));

	}

}
//почему, если убрать static - metodCalc не видно в main?
 