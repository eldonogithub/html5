package ca.blackperl.toursdb;
// Generated Mar 27, 2016 10:34:39 PM by Hibernate Tools 4.3.1.Final

/**
 * Flightavailability generated by hbm2java
 */
public class Flightavailability implements java.io.Serializable {

	private FlightavailabilityId id;
	private Integer economySeatsTaken;
	private Integer businessSeatsTaken;
	private Integer firstclassSeatsTaken;

	public Flightavailability() {
	}

	public Flightavailability(FlightavailabilityId id) {
		this.id = id;
	}

	public Flightavailability(FlightavailabilityId id, Integer economySeatsTaken, Integer businessSeatsTaken,
			Integer firstclassSeatsTaken) {
		this.id = id;
		this.economySeatsTaken = economySeatsTaken;
		this.businessSeatsTaken = businessSeatsTaken;
		this.firstclassSeatsTaken = firstclassSeatsTaken;
	}

	public FlightavailabilityId getId() {
		return this.id;
	}

	public void setId(FlightavailabilityId id) {
		this.id = id;
	}

	public Integer getEconomySeatsTaken() {
		return this.economySeatsTaken;
	}

	public void setEconomySeatsTaken(Integer economySeatsTaken) {
		this.economySeatsTaken = economySeatsTaken;
	}

	public Integer getBusinessSeatsTaken() {
		return this.businessSeatsTaken;
	}

	public void setBusinessSeatsTaken(Integer businessSeatsTaken) {
		this.businessSeatsTaken = businessSeatsTaken;
	}

	public Integer getFirstclassSeatsTaken() {
		return this.firstclassSeatsTaken;
	}

	public void setFirstclassSeatsTaken(Integer firstclassSeatsTaken) {
		this.firstclassSeatsTaken = firstclassSeatsTaken;
	}

}