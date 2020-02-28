package spring5.webapp.spring5webapp.api.v1.model;

import java.math.BigDecimal;

import lombok.Data;
import spring5.webapp.spring5webapp.domain.Country;

@Data
public class SpotDTO {
    private Long id;
    private String name;
    private BigDecimal wind;
   // private Country country;
}
