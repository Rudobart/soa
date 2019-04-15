package pl.agh.kis.soa.theatre;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class SeatAvailabilityChecker {

    @EJB
    Theatre theatre;

    public boolean checkAvailabilityByType(String type){
        ArrayList<Seat> seats = theatre.getSeatList();
        for (Seat seat : seats) {
            if (seat.getSeatName().equals(type) && !seat.isBooked()){
                return true;
            }

        }
        return false;
    }
    public String showAvailabilityMessage(String type){
        boolean available = checkAvailabilityByType(type);
        if (available){
            return "Dostępne";
        }
        return "Zajęte";
    }
    public int showNumberOfAvailableByType(String type){
        int result = 0;
        ArrayList<Seat> seats = theatre.getSeatList();
        for (Seat seat : seats) {
            if (seat.getSeatName().equals(type) && !seat.isBooked()){
                result++;
            }

        }
        return result;
    }
    public ArrayList<Integer> showAvailableSeats(String type){
        ArrayList<Integer> seatsIds = new ArrayList<>();
        ArrayList<Seat> seats = theatre.getSeatList();
        for (Seat seat : seats) {
            if (seat.getSeatName().equals(type) && !seat.isBooked()){
                seatsIds.add(seat.getId());
            }

        }
        return seatsIds;
    }


}
