package com.vehicles.lookup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicles.lookup.City;
import com.vehicles.lookup.Country;
import com.vehicles.lookup.State;
import com.vehicles.lookup.repository.LookupRepository;

@Service
public class LookupServiceImpl implements LookupService {

	@Autowired
	private LookupRepository lookupRepository;
	
	public int totalCountries() {
		
		return lookupRepository.totalCountries();
	}

	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		return lookupRepository.getCountries();
	}

	public List<State> getStates(int countryId) {
		// TODO Auto-generated method stub
		return lookupRepository.getStates(countryId);
	}

	public List<City> getCities(int stateId) {
		// TODO Auto-generated method stub
		return lookupRepository.getCities(stateId);
	}

}