package ca.blackperl.struts.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class AirlinesForm extends ValidatorForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int firstClassSeats;
	private int businessSeats;
	private int economySeats;
	private double firstClassLevelFactor;
	private double distanceDiscount;
	private double basicRate;
	private String airlineFull;
	private String airline;
	
	public String getAirline() {
		return airline;
	}
	
	public String getAirlineFull() {
		return airlineFull;
	}

	public double getBasicRate() {
		return basicRate;
	}

	public int getBusinessSeats() {
		return businessSeats;
	}

	public double getDistanceDiscount() {
		return distanceDiscount;
	}

	public int getEconomySeats() {
		return economySeats;
	}

	public double getFirstClassLevelFactor() {
		return firstClassLevelFactor;
	}

	public int getFirstClassSeats() {
		return firstClassSeats;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		if ( "POST".equals(request.getMethod())) {
			
		}
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setAirlineFull(String airlineFull) {
		this.airlineFull = airlineFull;
	}

	public void setBasicRate(double basicRate) {
		this.basicRate = basicRate;
	}

	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}

	public void setDistanceDiscount(double distanceDiscount) {
		this.distanceDiscount = distanceDiscount;
	}

	public void setEconomySeats(int economySeats) {
		this.economySeats = economySeats;
	}

	public void setFirstClassLevelFactor(double firstClassLevelFactor) {
		this.firstClassLevelFactor = firstClassLevelFactor;
	}

	public void setFirstClassSeats(int firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}

	@Override
	public String toString() {
		return "AirlinesForm [firstClassSeats=" + firstClassSeats + ", businessSeats=" + businessSeats
				+ ", economySeats=" + economySeats + ", firstClassLevelFactor=" + firstClassLevelFactor
				+ ", distanceDiscount=" + distanceDiscount + ", basicRate=" + basicRate + ", airlineFull=" + airlineFull
				+ ", airline=" + airline + "]";
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.validate(mapping, request);
	}
}
