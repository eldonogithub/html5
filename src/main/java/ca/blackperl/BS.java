package ca.blackperl;

import java.util.*;

public class BS {
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Scanner input = new Scanner(System.in);
		int total = 0;
		int duration;
		while (input.hasNextInt()) {
			duration = input.nextInt();
			ll.add(duration);
		}
		for (int i = 0; i < ll.size(); i++) {
			duration = ll.get(i);
			total += duration;
			System.out.println("next patient was processed at " + total + "minutes for " + duration + " minutes");

		}

	}
}