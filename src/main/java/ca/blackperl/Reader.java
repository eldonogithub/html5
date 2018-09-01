package ca.blackperl;

import java.util.LinkedList;
import java.util.Scanner;

public class Reader {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		readLinkedList(linkedList);

		displayList(linkedList);
	}

	private static void readLinkedList(LinkedList<Integer> linkedList) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				Integer duration = scanner.nextInt();
				linkedList.add(duration);
			}
		}
	}

	private static void testCloning(LinkedList<Integer> linkedList) {
		LinkedList<Integer> cloned = (LinkedList<Integer>) linkedList.clone();
		displayList(cloned);
		System.out.println("toString:");
		System.out.println(cloned);
	}

	private static void displayList(LinkedList<Integer> linkedList) {
		System.out.println("Linked List:");

		System.out.println("For loop 1:");
		int total = 0;
		for (int duration : linkedList) {
			System.out.println("Next patient was processed at " + total + " minutes for " + duration + " minutes");
			total += duration;
		}
		System.out.println("For loop 2:");
		total = 0;
		for (int index = 0; index < linkedList.size(); index++) {
			int duration = linkedList.get(index);
			System.out.println("Next patient was processed at " + total + " minutes for " + duration + " minutes");
			total += duration;
		}
		System.out.println("For loop 3:");
		total = 0;
		for (Integer duration : linkedList) {
			System.out.println("Next patient was processed at " + total + " minutes for " + duration + " minutes");
			total += duration;
		}
	}

}
