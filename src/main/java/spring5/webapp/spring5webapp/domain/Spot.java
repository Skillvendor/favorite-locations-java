package spring5.webapp.spring5webapp.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Spot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Min(0)
	@Max(100)
	private BigDecimal wind;
	
	@NotNull
	@ManyToOne()
	private Country country;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spot")
	private Set<Favorite> favorite = new HashSet<>();
	
	
	public Spot(){
	}
	
	public Spot(String name, BigDecimal wind){
		this.name = name;
		this.wind = wind;
		//this.favorite = favorite;
	}
	

	public Long getId() {
		return id;
	}
	
	public BigDecimal getWind() {
		return wind;
	}

	public void setWind(BigDecimal wind) {
		this.wind = wind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<Favorite> getFavorite() {
		return favorite;
	}

	public void setFavorite(Set<Favorite> favorite) {
		this.favorite = favorite;
	}

	


}
