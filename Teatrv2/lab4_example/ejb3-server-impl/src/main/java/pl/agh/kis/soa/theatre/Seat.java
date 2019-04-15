package pl.agh.kis.soa.theatre;

public class Seat {


    private int id;
    private String seatName;
    private int price;
    private boolean booked;


    public Seat(int id, String seat, int price) {
        this.id = id;
        this.seatName = seat;
        this.price = price;
        this.booked = false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getSeatName() {
        return seatName;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}