package spring5.webapp.spring5webapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne(cascade = {})
	private Spot spot;

	@NotNull
	@ManyToOne(cascade = {})
	private ApplicationUser user;

	
	public Long getId() {
		return id;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot firstSpot) {
		this.spot = firstSpot;		
	}

	public ApplicationUser getUser() {
		return user;
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
	}

	
	
}
