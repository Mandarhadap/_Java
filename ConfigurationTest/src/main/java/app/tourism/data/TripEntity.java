package app.tourism.data;

public class TripEntity {
    
    private int id;
    private java.util.Date checkin = new java.util.Date();
    private TravelerEntity guest;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public java.util.Date getCheckin() {
        return checkin;
    }
    public void setCheckin(java.util.Date checkin) {
        this.checkin = checkin;
    }
    public TravelerEntity getGuest() {
        return guest;
    }
    public void setGuest(TravelerEntity guest) {
        this.guest = guest;
    }
    



}
