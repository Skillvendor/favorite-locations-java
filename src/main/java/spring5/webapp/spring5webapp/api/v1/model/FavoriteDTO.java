package spring5.webapp.spring5webapp.api.v1.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FavoriteDTO {
	private ApplicationUserDTO user;
	private SpotDTO spot;
}
