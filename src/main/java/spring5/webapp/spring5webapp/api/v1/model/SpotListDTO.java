package spring5.webapp.spring5webapp.api.v1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import spring5.webapp.spring5webapp.api.v1.model.SpotDTO;

@Data
@AllArgsConstructor
public class SpotListDTO {
	List<SpotDTO> spots;
}
