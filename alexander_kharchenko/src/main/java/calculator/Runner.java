package calculator;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Calc c = new Calc();
		Scanner scn = new Scanner(System.in);
		boolean end = true;
		do {
			String s = scn.next("[0-9\\+\\-/*=\\.]+");
			if (s.equals(".")) {
				end = false;
			} else {
				System.out.println("you entered: " + s);
				c.inChar(s.charAt(0));
				System.out.println(c);
			}
		} while (end);
		System.out.println("The end!");
		
	}

}
