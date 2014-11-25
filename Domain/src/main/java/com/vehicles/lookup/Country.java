package com.vehicles.lookup;

import java.util.List;

public class Country {

	private Long   		countryId;
	private String 		countryName;
	private String 		countryCode;
	private List<State> states;
	
	
 	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the states
	 */
	public List<State> getStates() {
		return states;
	}
	/**
	 * @param states the states to set
	 */
	public void setStates(List<State> states) {
		this.states = states;
	}	
}
