package spring.objects;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Eoller on 27-Aug-17.
 */
@Component
public class SearchCriteria implements Serializable{

    private String searchString;

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
