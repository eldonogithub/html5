package ca.blackperl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.blackperl.Bundles.Term;

public class Bundles {
	public static class Service {
		private static final Logger log = LogManager.getLogger(Service.class);
		private LocalDate start;
		private LocalDate end;
		private Term term;
		private boolean bundled;
		private double fee;

		public Service(LocalDate start, LocalDate end, Term term, int bundled, double fee) {
			this.start = start;
			this.end = end;
			this.term = term;
			this.bundled = bundled == 1 ? true : false;
			this.fee = fee;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Service other = (Service) obj;
			if (end == null) {
				if (other.end != null) {
					return false;
				}
			} else if (!end.equals(other.end)) {
				return false;
			}
			if (start == null) {
				if (other.start != null) {
					return false;
				}
			} else if (!start.equals(other.start)) {
				return false;
			}
			return true;
		}

		public LocalDate getEnd() {
			return end;
		}

		public LocalDate getStart() {
			return start;
		}

		public Term getTerm() {
			return term;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((end == null) ? 0 : end.hashCode());
			result = prime * result + ((start == null) ? 0 : start.hashCode());
			return result;
		}

		public boolean isBundled() {
			return bundled;
		}

		public void setBundled(boolean bundled) {
			this.bundled = bundled;
		}

		public void setEnd(LocalDate end) {
			this.end = end;
		}

		public void setStart(LocalDate start) {
			this.start = start;
		}

		public void setTerm(Term term) {
			this.term = term;
		}

		@Override
		public String toString() {
			return "Service [start=" + start + ", end=" + end + ", term=" + term + ", bundled=" + bundled + "]";
		}

	}

	public static class ServiceAscendingEndComparator implements Comparator<Service> {
		private static final Logger log = LogManager.getLogger(ServiceAscendingEndComparator.class);

		@Override
		public int compare(Service o1, Service o2) {
			return o2.getEnd().compareTo(o1.getEnd());
		}

	}

	public static class ServiceAscendingStartComparator implements Comparator<Service> {
		private static final Logger log = LogManager.getLogger(ServiceAscendingStartComparator.class);

		@Override
		public int compare(Service o1, Service o2) {
			return o1.getStart().compareTo(o2.getStart());
		}

	}

	public enum Term {
		MONTHLY, QUARTERLY, YEARLY
	}

	private static final Logger log = LogManager.getLogger(Bundles.class);

	public static void main(String[] args) {
		ServiceAscendingStartComparator serviceStartComparator = new ServiceAscendingStartComparator();
		ServiceAscendingEndComparator serviceEndComparator = new ServiceAscendingEndComparator();

		List<Service> allservices = new ArrayList<Service>(20);

		LocalDate now = LocalDate.now().withDayOfMonth(1);
		for (int i = 0; i < 20; i++) {
			LocalDate start = now.minusMonths((long) (Math.random() * 60) + 1);
			LocalDate end = start.plusMonths((long) (Math.random() * 60) + 1);
			;
			Service bundle = new Service(start, end, Term.values()[(int) (Math.random() * Term.values().length)],
					(int) (Math.random() * 2), 1000.00);
			allservices.add(bundle);
			log.info(bundle);
		}
		{
			int a = 5;
			int b = 7;
			int c = b - a;
			int d = c % 3;
			int e = b + ( 3 - d);
			log.info("a=" + a);
			log.info("b=" + b);
			log.info("c=" + c);
			log.info("d=" + d);
			log.info("e=" + e);
		}
		LocalDate now1 = LocalDate.now();
		log.info("now1=" + now1);
		LocalDate next = now1.plusMonths(26);
		log.info("next=" + next);
		Period diff = Period.between(now, next);
		int months = diff.getMonths() % 3;
		log.info("months=" + months);
		LocalDate plusMonths = next.plusMonths(3 - months);
		log.info("plusMonths=" + plusMonths);

		allservices.sort(serviceStartComparator);

		log.info("Sorted list");

		for (Service bundle : allservices) {
			log.info(bundle);
		}
		log.info("Earliest Start Date: " + allservices.get(0).getStart());

		allservices.sort(serviceEndComparator);
		log.info("Latest End Date: " + allservices.get(0).getEnd());

		Stream<Service> stream = allservices.stream();
		List<Service> filtered = stream.filter((b) -> now.compareTo(b.getStart()) >= 0)
				.filter((b) -> now.compareTo(b.getEnd()) < 0).collect(Collectors.toList());
		List<Service> bundled = stream.filter((b) -> now.compareTo(b.getStart()) >= 0)
				.filter((b) -> now.compareTo(b.getEnd()) < 0).filter((b) -> b.isBundled()).collect(Collectors.toList());

		filtered.sort(serviceStartComparator);
		LocalDate start = filtered.get(0).getStart();
		filtered.sort(serviceEndComparator);
		LocalDate end = filtered.get(0).getEnd();

		log.info("Filtered list");

		for (Service bundle : filtered) {
			log.info(bundle);
		}

		LocalDate currentDate = start;
		while (currentDate.compareTo(now) < 0) {
			log.info("CurrentDate: " + currentDate);
			currentDate = currentDate.plusMonths(1);
			for (Service service : bundled) {

			}
			for (Service service : filtered) {

			}
		}
	}
}
