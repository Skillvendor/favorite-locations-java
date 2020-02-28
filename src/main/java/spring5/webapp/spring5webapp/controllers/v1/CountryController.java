package spring5.webapp.spring5webapp.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring5.webapp.spring5webapp.api.v1.model.CountryListDTO;
import spring5.webapp.spring5webapp.services.CountryService;

@RestController
@RequestMapping("/api/spots/countries")
public class CountryController {
	private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CountryListDTO index(){
        return new CountryListDTO(countryService.getAllCountries());
    }
}
