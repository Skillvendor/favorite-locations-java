package spring5.webapp.spring5webapp.api.v1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryListDTO {
	List<CountryDTO> countries;
}