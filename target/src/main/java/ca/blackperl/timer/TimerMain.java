package ca.blackperl.timer;

import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {

	private static final class TimerExtension extends Timer {
		@Override
		public void cancel() {
			System.err.println("cancelling...");
			super.cancel();
		}

		@Override
		public void schedule(TimerTask task, long delay, long period) {
			System.err.println("scheduling...");
			super.schedule(task, delay, period);
		}
	}

	static class TimerThread extends TimerTask {

		private PrintStream out;
		private int runs = 0;

		public TimerThread(PrintStream out) {
			super();
			this.out = out;
		}

		@Override
		public void run() {
			runs++;
			out.println("task run=" + runs);
		}

		@Override
		protected void finalize() throws Throwable {
			out.println("finalize runs=" + runs);
			super.finalize();
		}
	}

	public static void main(String[] args) {

		TimerThread timerThread = new TimerThread(System.out);
		Timer timer = new TimerExtension();

		try {
			timer.schedule(timerThread, 1000L, 1000L);

			Thread.sleep(5000);
			System.err.println("done sleeping");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			timer.cancel();
		}
	}
}
