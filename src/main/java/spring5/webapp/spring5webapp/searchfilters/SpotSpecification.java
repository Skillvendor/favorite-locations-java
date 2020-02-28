package spring5.webapp.spring5webapp.searchfilters;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import spring5.webapp.spring5webapp.api.v1.mapper.SpotMapper;
import spring5.webapp.spring5webapp.domain.Spot;
import spring5.webapp.spring5webapp.domain.Country;
import spring5.webapp.spring5webapp.repositories.SpotRepository;

public class SpotSpecification implements Specification<Spot> {
    private SearchCriteria criteria;
    
	public SpotSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}
    
    @Override
    public Predicate toPredicate
      (Root<Spot> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
  
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } 
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                  root.<String>get(criteria.getKey()), criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        else if (criteria.getOperation().equalsIgnoreCase("country:")) {
        	Join<Spot, Country> countries = root.join("country", JoinType.INNER);
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                		countries.get(criteria.getKey()),
                		criteria.getValue() + "%");
            } else {
                return builder.equal(
                		countries.get(criteria.getKey()),
                		criteria.getValue() + "%");
            }
        }
        return null;
    }
}
