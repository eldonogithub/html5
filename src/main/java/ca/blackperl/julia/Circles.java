package ca.blackperl.julia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Circles {
	private static final Logger log = LogManager.getLogger(Circles.class);

	public static void main(String[] args) {
		
		double radius = 3.0;
		
		double circumference = Math.pow(radius, 2) * Math.PI;
		
		System.out.println(String.format("%f", circumference));
	}
}

