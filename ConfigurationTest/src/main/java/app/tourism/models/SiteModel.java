package app.tourism.models;

import java.util.List;

import app.tourism.data.TravelerEntity;
import app.tourism.data.TripEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SiteModel {
    //factory is to make the objects of Entity manager those objects are used to make transaction on the database
    //private- used in this class only. final- emf can never be re assigned. static- only one factory is made 
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("app.data");

    public List<Visitor> geVisitors(){
        //creates object of EntityManager (em) and this em is used to make make queries and do the transaction
        try(var em = emf.createEntityManager()){
            var query = em.createQuery("SELECT e FROM TravelerEntity e WHERE LENGTH(e.id)>3",TravelerEntity.class);
            return query.getResultStream()
                .map(Visitor::fromTravaler)//transforms the traveller to visitor type to store in record
                .toList();
        }
    }

    public boolean handleVisit(String visitorId, int visitorRating){
        if(visitorId == null|| visitorRating <1|| visitorRating>5)
            return false;
        try(var em =emf.createEntityManager()){
            var traveler = em.find(TravelerEntity.class, visitorId);
            //new object below
            if(traveler == null){
                traveler = new TravelerEntity();
                traveler.setId(visitorId);
            }
            traveler.setRating(visitorRating);
            var trip = new TripEntity();
            trip.setGuest(traveler);
            traveler.getTours().add(trip);
            var tx = em.getTransaction();
            tx.begin();//starts database transaction all the above changes will be made from here 
            //if traveller a new object it tells JPA to schedule the insert
            //cascading - if you are adding new trip to travelers tours then travler is also saved in new trip 
            em.persist(traveler); 
            tx.commit();// now the scheduled inset is done here 
            return true;
        }


    }

}
