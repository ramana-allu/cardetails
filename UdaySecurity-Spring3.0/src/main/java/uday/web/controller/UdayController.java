package uday.web.controller;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import com.vehicles.lookup.service.LookupService;@Controllerpublic class UdayController {	@Autowired	LookupService lookupService;	@RequestMapping(value = "/things/{thingId}", method = RequestMethod.GET)	public Thing index(@PathVariable Integer thingId) {		System.out.println("HELLO<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>." + lookupService.totalCountries());		Thing t = new Thing();		t.setDescription("Something");		t.setId(thingId);		return t;	}}