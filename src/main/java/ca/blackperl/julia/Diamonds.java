package ca.blackperl.julia;

/*
Julia Olmstead
B00780639
Makes a diamond using nested for loops after receiving integer from user with scanner class.
*/
import java.util.Scanner;

public class Diamonds {
	public static void main(String[] args) {
		System.out.print("Please type an integer number: ");
		Scanner console = new Scanner(System.in);
		String nextLine = console.nextLine();
		System.out.println();
		int number = Integer.parseInt(nextLine);

		for (int j = number; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				System.out.print("*");
			}
			for (int i = 0; i < 2 * (number - j); i++) {
				System.out.print("#");
			}
			for (int i = 0; i < j; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int j = 1; j <= number; j++) {
			for (int i = 0; i < j; i++) {
				System.out.print("*");
			}
			for (int i = 0; i < 2 * (number - j); i++) {
				System.out.print("#");
			}
			for (int i = 0; i < j; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}