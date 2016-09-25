package ca.blackperl;

import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Syntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class Thrower {
	@CheckForNull
	private static final Logger log = LogManager.getLogger(Thrower.class);

	class X {
		private int a;

		public void name() {

		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}
	}

	@Test
	public void test() {
		String b = "";
		Integer c = 4;
		if (b.equals(c.toString())) {

		}
		@Syntax("SQL")
		String s = " asdf dasfd dassdf select * from";
		try {
			log.info("hello" + s);
			foo();
			increment(3);
		} catch (Exception e) {

		}
	}

	@CheckReturnValue
	private int increment(int bar) {
		return bar + 1;
	}

	public void foo() {
		int i = 1;
		// BUG: Diagnostic contains: remove this line
		increment(i);
		System.out.println(i);
	}

	public String bar() {
		return "Hello";
	}
	
	
}
