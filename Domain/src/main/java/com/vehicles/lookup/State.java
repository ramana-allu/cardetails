package com.vehicles.lookup;

import java.util.List;

public class State {

	private Long 			StateId;
	private Long 			CounrtyId;
	private String 			StateName;
	private String 			StateCode;
	private List<City> 		cities;
	
	public Long getStateId() {
		return StateId;
	}
	public void setStateId(Long stateId) {
		StateId = stateId;
	}
	
	public Long getCounrtyId() {
		return CounrtyId;
	}
	public void setCounrtyId(Long counrtyId) {
		CounrtyId = counrtyId;
	}

	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public String getStateCode() {
		return StateCode;
	}
	public void setStateCode(String stateCode) {
		StateCode = stateCode;
	}
}
