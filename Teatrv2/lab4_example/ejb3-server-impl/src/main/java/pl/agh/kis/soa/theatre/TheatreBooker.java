package pl.agh.kis.soa.theatre;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.*;


@Stateful
@Data
public class TheatreBooker
{
    int money;

    private Map<Integer,String> ticketsMap = new HashMap<>();

    @EJB
    Theatre theatre;
    @PostConstruct
    public void createCustomer() {
        this.money=100;
    }

    public String bookSeat(int seatId) throws SeatBookedException,
            NotEnoughMoneyException {
        Seat seat = theatre.getSeatById(seatId);
        if (seat == null){
            return "Nie ma takiego miejsca";
        }
        if (seat.isBooked()) {
            throw new SeatBookedException("To miejsce jest już zarezerwowane!");
        }
        if (seat.getPrice() > money) {
            throw new NotEnoughMoneyException("Nie masz wystarczających środków ");
        }
        theatre.buyTicket(seatId);
        money = money -seat.getPrice();
        ticketsMap.put(seatId, theatre.getSeatById(seatId).getSeatName());
        return "Rezerwacja przyjęta.";
    }
    public List<Map.Entry<Integer, String>> getTickets() {
        Set<Map.Entry<Integer, String>> ticketsSet =
                ticketsMap.entrySet();
        return new ArrayList<Map.Entry<Integer, String>>(ticketsSet);
    }

}
