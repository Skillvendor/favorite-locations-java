package spring5.webapp.spring5webapp.searchfilters;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import spring5.webapp.spring5webapp.domain.Spot;

public class SpotSearchParameters {

//	private String key;
//    private String operation;
//    private Object value;
//    @Builder.Default
//    private boolean orPredicate = false;
	  private SearchCriteria criteria;
	
	public SpotSearchParameters( Map<String, String> params){
		
		Map m=(Map) params.entrySet();
		SearchCriteria s = (SearchCriteria) m.entrySet();
		//String paramsSpot = ((Entry<String, String>) params).getKey();
		//String key = entry.getKey();
		this.criteria.setKey(s.getKey());
		
		String operationAndValue =   ((Entry<String, String>) s).getValue();
		String[] arrOfStr = operationAndValue.split(" "); 
		this.criteria.setOperation(arrOfStr[0]);
		//this.operation = arrOfStr[0];
		//this.value = arrOfStr[1];
		this.criteria.setValue(arrOfStr[1]);
		if( arrOfStr[2] != null ) {
			//this.orPredicate = Boolean.parseBoolean(arrOfStr[2]);	
			this.criteria.setOrPredicate(Boolean.parseBoolean(arrOfStr[2]));
		}
	}
	
	//new SearchCriteria(filters.wind.camp, "country:", "Tara fara spot")
	
	public final Specification<Spot> getAllFilteredSpots() {
	    	SpotSpecificationsBuilder builder = new SpotSpecificationsBuilder();
	    	builder.with(new SearchCriteria(this.criteria.getKey(),this.criteria.getOperation(),
	    			this.criteria.getValue(), this.criteria.isOrPredicate()));
	    	
	    	//builder.with(new SearchCriteria("name", "country:", "Tara fara spot", false));
	    	//builder.with(new SearchCriteria("wind", ">", 0.0, true));
	    	
	    	Specification<Spot> spec = builder.build();
	    	return spec;
	}
    	     
}
