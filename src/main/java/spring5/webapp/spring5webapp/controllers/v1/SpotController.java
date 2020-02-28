package spring5.webapp.spring5webapp.controllers.v1;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import spring5.webapp.spring5webapp.api.v1.model.SpotDTO;
import spring5.webapp.spring5webapp.api.v1.model.SpotListDTO;
import spring5.webapp.spring5webapp.searchfilters.SpotSearchParameters;
import spring5.webapp.spring5webapp.services.SpotService;

@RestController
@RequestMapping("/api/spots/")
public class SpotController {
    private final SpotService spotService;

    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SpotListDTO index( @RequestParam Map<String,String> params){
    	SpotSearchParameters spotSearchParameters = new SpotSearchParameters(params);
    	//params.entrySet();
    	spotSearchParameters.getAllFilteredSpots();
        return new SpotListDTO(spotService.getAllSpots(spotSearchParameters));
    }
    
    @GetMapping({"{id}"})
    @ResponseStatus(HttpStatus.OK)
    public SpotDTO getSpotById(@PathVariable Long id){
        return spotService.getSpotById(id);
    }
}
