package spring5.webapp.spring5webapp.searchfilters;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    @Builder.Default
    private boolean orPredicate = false;
    
//	private SpotSearchParameters spotSearchParameters;
//	public SearchCriteria (SpotSearchParameters spotSearchParameters) {
//		this.spotSearchParameters = spotSearchParameters;
//		}
    
    public boolean isOrPredicate() {
        return orPredicate;
    }	
}
