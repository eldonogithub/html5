package ca.blackperl.julia;

import java.util.Scanner;

public class Assignment_2_Question_1 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("please enter number of rows");
		int n = kb.nextInt();
		System.out.print("Enter Symbol : ");
		char c = kb.next().charAt(0);
		int i = 1;
		int j;
		while (i <= n) {
			j = 1;
			while (j++ <= n - i) {
				System.out.print(" ");
			}
		}
		j = 1;
		while (j++ <= i * 2 - 1) {
			System.out.print(c);
		}
		System.out.println();
		i++;
		i = n - 1;
		while (i > 0) {
			j = 1;
			while (j++ <= n - i) {
				System.out.print(" ");
			}
			j = 1;
			while (j++ <= i * 2 - 1) {
				System.out.print(c);
			}
			System.out.println();
			i--;
		}
	}
}