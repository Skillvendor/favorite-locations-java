package spring5.webapp.spring5webapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
	private Set<Spot> spot = new HashSet<>();
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    public Set<Spot> getSpot() {
        return spot;
    }

    public void setSpot(Set<Spot> spot) {
        this.spot = spot;
    }	
}


