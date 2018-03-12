import java.util.Scanner;

public class GuessingName {
	public static void main(String[] args) {
		// Generate a random integer.
		int counter = 0;
		int number1 = (int) (Math.random() * 10000);

		/**
		 * Program: Guessing Name File:GuessingName.java Summary:Generating random
		 * number and guess Author:Xinrui Ma Date:2018.3.11
		 */

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a guess between 1 and 10000: ");
		int guess = input.nextInt();

		// check the guess
		while (true) {

			if (guess > number1) {
				System.out.println("Lower \nEnter a guess between 1 and" + guess-- + ": ");
				counter++;
				guess = input.nextInt();
			}
			if (guess < number1) {
				System.out.println("Higher \nEnter a guess between " + guess++ + " and 10000: ");
				counter++;
				guess = input.nextInt();
			}
			if (guess == number1) {
				System.out.println("You win. It took you " + counter + " guess");
				break;
			}
		}
	}
}
