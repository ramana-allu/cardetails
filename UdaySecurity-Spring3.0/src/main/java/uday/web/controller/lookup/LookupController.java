package uday.web.controller.lookup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vehicles.lookup.Country;
import com.vehicles.lookup.service.LookupService;

@Controller
public class LookupController {

	@Autowired
	private LookupService lookupService;

	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public List<Country> getCountries()
	{
		return (List<Country>) lookupService.getCountries();
	}
	
	@RequestMapping(value = "/states/{countryId}", method = RequestMethod.GET)
	public String getStates(@PathVariable Integer countryId)
	{
		lookupService.getStates(countryId);
		return null;
	}
	
	@RequestMapping(value = "/city/{stateId}", method = RequestMethod.GET)
	public String getCities(@PathVariable Integer stateId)
	{
		lookupService.getCities(stateId);
		return null;
	}
}
