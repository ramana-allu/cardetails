package com.vehicles.lookup.service;

import java.util.List;

import com.vehicles.lookup.City;
import com.vehicles.lookup.Country;
import com.vehicles.lookup.State;

public interface LookupService {

	int totalCountries();
	List<Country> getCountries();
	List<State> getStates(int CountryId);
	List<City> getCities(int stateId);
	
}
