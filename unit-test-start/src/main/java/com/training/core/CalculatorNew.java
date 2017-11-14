package com.training.core;

import java.util.Scanner;

import com.training.core.management.CalculatorOperationManager;
import com.training.core.management.CalculatorOperationsBuilder;

public class CalculatorNew {
	public static void main(final String[] args) {
		CalculatorOperationManager com = CalculatorOperationsBuilder.getCalcManager();

		Scanner scanner = new Scanner(System.in);
		rootloop: while (true) {
			System.out.println(com.getMenu());
			int opIndex = scanner.nextInt();

			System.out.println("First Val : ");
			int first = scanner.nextInt();

			System.out.println("Second Val : ");
			int second = scanner.nextInt();
			try {
				System.out.println("Result : " + com.execute(opIndex,
				                                             first,
				                                             second));
			} catch (Exception e) {
				continue rootloop;
			}

		}
	}
}
