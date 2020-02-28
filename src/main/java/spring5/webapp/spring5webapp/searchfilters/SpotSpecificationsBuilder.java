package spring5.webapp.spring5webapp.searchfilters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import spring5.webapp.spring5webapp.domain.Spot;

public class SpotSpecificationsBuilder {
    
    private final List<SearchCriteria> params;
 
    public SpotSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
 
    public SpotSpecificationsBuilder with(String key, String operation, Object value, boolean orPredicate) {
        params.add(new SearchCriteria(key, operation, value, false));
        return this;
    }
 
    public Specification<Spot> build() {
        if (params.size() == 0) {
            return null;
        }

        List<SpotSpecification> specs = params.stream()
          .map(SpotSpecification::new)
          .collect(Collectors.toList());
         
        Specification<Spot> result = specs.get(0);
        
        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                ? Specification.where(result).or(specs.get(i))
                : Specification.where(result).and(specs.get(i));
        }       
        return result;
    }
    
    public final SpotSpecificationsBuilder with(SearchCriteria criteria) {
        params.add(criteria);
        return this;
    }
}