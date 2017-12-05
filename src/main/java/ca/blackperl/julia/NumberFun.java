package ca.blackperl.julia;

import java.text.DecimalFormat;

public class NumberFun {

	public static void main(String[] args) {
		
		double notExact = 0.125;
		
		System.out.println("This is never exact =" + notExact);

		String rounded = String.format("%6.2f", notExact);
		
		System.out.println("This now rounded to 2 decimal places =" + rounded);
		
		DecimalFormat df = new DecimalFormat("#.##;#");
		
		System.out.println("X=" + df.format(notExact));
		
		int whatRound = 3;
		System.out.println((int) Math.pow(10.0, whatRound));
		
		double x = 2.25;
		double y = 2.25;
		
		String a = String.format("%6.2f", x);
		String b = df.format(y);
		
		System.out.println("A=[" + a + "] B=[" + b + "]");
		if ( a.equals(b) ) {
		}
	}

}

