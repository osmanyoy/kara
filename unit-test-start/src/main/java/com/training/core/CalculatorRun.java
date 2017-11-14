package com.training.core;

import java.util.Scanner;

public class CalculatorRun {
	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calculator calculator = new Calculator();
		rootloop: while (true) {
			System.out.println("1-Zet");
			System.out.println("2-Multiply");
			System.out.println("3-Subs");
			System.out.println("Choose your operation:");
			int opIndex = scanner.nextInt();
			if ((opIndex < 1) || (opIndex > 2)) {
				continue rootloop;
			}
			System.out.println("First Val : ");
			int first = scanner.nextInt();

			System.out.println("Second Val : ");
			int second = scanner.nextInt();
			int result = 0;
			switch (opIndex) {
			case 1:
				result = calculator.add(first,
				                        second);
				break;
			case 2:
				result = calculator.multiply(first,
				                             second);
				break;

			default:
				break;
			}
			System.out.println("Result : " + result);
		}
	}
}
