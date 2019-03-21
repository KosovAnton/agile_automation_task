package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {

    private List<Post> data;

    public List<Post> getData() {
        return data;
    }
}
