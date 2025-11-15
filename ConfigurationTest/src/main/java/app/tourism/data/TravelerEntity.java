package app.tourism.data;

import java.util.ArrayList;
import java.util.List;

public class TravelerEntity {
    private String id;
    private int rating;
    
    //for storing the trips made by the traveller one many relation ship 1 traveller many trips
    private List<TripEntity> tours = new ArrayList<>();//init here because not Null pointer exception

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<TripEntity> getTours() {
        return tours;
    }

    public void setTours(List<TripEntity> tours) {
        this.tours = tours;
    }
    
    
}
