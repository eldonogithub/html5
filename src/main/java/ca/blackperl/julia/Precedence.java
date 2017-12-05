package ca.blackperl.julia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Precedence {
	private static final Logger log = LogManager.getLogger(Precedence.class);

	public static void main(String[] args) {
		for( int i = 0; i < 8; i++ ) {
			System.out.print(i++ * 3 + " ");
		}
		for( int i = 0; i <= 5; i++) {
			for ( int j = 2 * i; j>i ; j--) {
				System.out.print(j);
				
			}
			System.out.println();
		}
		int i = 0;
		for( ; ; ) {
			if ( i > 5 ) {
				break;
			}
			for ( int j = 2 * i; j>i ; j--) {
				System.out.print(j);
				
			}
			System.out.println();
			i++;
		}
	}
}

