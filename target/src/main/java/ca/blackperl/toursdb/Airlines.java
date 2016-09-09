package ca.blackperl.toursdb;
// Generated Mar 27, 2016 10:34:39 PM by Hibernate Tools 4.3.1.Final

/**
 * Airlines generated by hbm2java
 */
public class Airlines implements java.io.Serializable {

	private String airline;
	private String airlineFull;
	private Double basicRate;
	private Double distanceDiscount;
	private Double businessLevelFactor;
	private Double firstclassLevelFactor;
	private Integer economySeats;
	private Integer businessSeats;
	private Integer firstclassSeats;

	public Airlines() {
	}

	public Airlines(String airline) {
		this.airline = airline;
	}

	public Airlines(String airline, String airlineFull, Double basicRate, Double distanceDiscount,
			Double businessLevelFactor, Double firstclassLevelFactor, Integer economySeats, Integer businessSeats,
			Integer firstclassSeats) {
		this.airline = airline;
		this.airlineFull = airlineFull;
		this.basicRate = basicRate;
		this.distanceDiscount = distanceDiscount;
		this.businessLevelFactor = businessLevelFactor;
		this.firstclassLevelFactor = firstclassLevelFactor;
		this.economySeats = economySeats;
		this.businessSeats = businessSeats;
		this.firstclassSeats = firstclassSeats;
	}

	public String getAirline() {
		return this.airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAirlineFull() {
		return this.airlineFull;
	}

	public void setAirlineFull(String airlineFull) {
		this.airlineFull = airlineFull;
	}

	public Double getBasicRate() {
		return this.basicRate;
	}

	public void setBasicRate(Double basicRate) {
		this.basicRate = basicRate;
	}

	public Double getDistanceDiscount() {
		return this.distanceDiscount;
	}

	public void setDistanceDiscount(Double distanceDiscount) {
		this.distanceDiscount = distanceDiscount;
	}

	public Double getBusinessLevelFactor() {
		return this.businessLevelFactor;
	}

	public void setBusinessLevelFactor(Double businessLevelFactor) {
		this.businessLevelFactor = businessLevelFactor;
	}

	public Double getFirstclassLevelFactor() {
		return this.firstclassLevelFactor;
	}

	public void setFirstclassLevelFactor(Double firstclassLevelFactor) {
		this.firstclassLevelFactor = firstclassLevelFactor;
	}

	public Integer getEconomySeats() {
		return this.economySeats;
	}

	public void setEconomySeats(Integer economySeats) {
		this.economySeats = economySeats;
	}

	public Integer getBusinessSeats() {
		return this.businessSeats;
	}

	public void setBusinessSeats(Integer businessSeats) {
		this.businessSeats = businessSeats;
	}

	public Integer getFirstclassSeats() {
		return this.firstclassSeats;
	}

	public void setFirstclassSeats(Integer firstclassSeats) {
		this.firstclassSeats = firstclassSeats;
	}

}