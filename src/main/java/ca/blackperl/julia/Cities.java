package ca.blackperl.julia;

import java.util.Scanner;

public class Cities {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter total cities: ");
		int total = console.nextInt();
		String cities[] = new String[total];
		
		for( int i = 0; i < total; i++) {
			System.out.print("Enter a city name: ");
			cities[i] = console.next();
		}
		
		System.out.println("Enter a starting letter: ");
		String input = console.next();

		System.out.println("Cities starting with [" + input + "]");

		// normalize input
		String lowerCaseString = input.toLowerCase();
		
		// get just the first letter of input
		char lowerCaseLetter = lowerCaseString.charAt(0);
		
		String lowerCaseCities[] = new String[total];
		for( int i = 0; i < total; i++) {
			lowerCaseCities[i] = cities[i].toLowerCase();
		}

		for( int i = 0; i < total; i++) {
			if ( lowerCaseCities[i].charAt(0) == lowerCaseLetter ) {
				System.out.println(cities[i]);
			}
		}
		
		System.out.println("Cities containing [" + input + "]");
		for( int i = 0; i < total; i++) {
			if ( lowerCaseCities[i].contains(lowerCaseString) ) {
				System.out.println(cities[i]);
			}
		}
	}
}

