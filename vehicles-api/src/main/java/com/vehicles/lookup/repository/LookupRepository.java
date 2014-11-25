package com.vehicles.lookup.repository;

import java.util.List;

import com.vehicles.lookup.City;
import com.vehicles.lookup.Country;
import com.vehicles.lookup.State;

public interface LookupRepository {


	int totalCountries();
	List<Country> getCountries();
	List<State> getStates();
	List<City> getCities();
	List<State> getStates(int countryId);
	List<City> getCities(int stateId);
}
