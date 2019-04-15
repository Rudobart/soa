package pl.agh.kis.soa.theatre;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

@Singleton
@Startup
public class Theatre {
    private ArrayList<Seat> seatList;

    @PostConstruct
    public void setupTheatre(){
        seatList = new ArrayList<>();
        for (int i=1;i<20;i++) {
            seatList.add(new Seat(i, "Normalny", 30));
        }
        for (int i=20;i<30;i++) {
            seatList.add(new Seat(i, "VIP", 50));
        }


    }
    @Lock(READ)
    public ArrayList<Seat> getSeatList() {
        return seatList;
    }
    @Lock(READ)
    public int getSeatPrice(int id) {
        return getSeatById(id).getPrice();
    }
    @Lock(WRITE)
    public void buyTicket(int seatId ) {
        Seat seat = getSeatById(seatId);
        seat.setBooked(true);
    }
    @Lock(READ)
    public int getSeatPriceByType(String type) {
        switch (type){
            case "Normalny" : return 30;
            case "VIP": return 50;
        }
        return 0;
    }
    public Seat getSeatById(int seatId){
        for (Seat s : getSeatList() ) {
            if (s.getId() == seatId){
                return s;
            }
        }
        return null;
    }
}