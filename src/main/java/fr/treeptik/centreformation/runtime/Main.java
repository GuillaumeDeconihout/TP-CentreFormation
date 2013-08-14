package fr.treeptik.centreformation.runtime;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("****** Application ready ******");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");

		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		
		System.out.println(line);
		
		scanner.close();
	}

}
