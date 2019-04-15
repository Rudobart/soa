package pl.agh.kis.soa.theatre;

import lombok.Data;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
@Data
public class ReservationView implements Serializable {
    @EJB
    SeatAvailabilityChecker seatAvailabilityChecker;

    @EJB
    TheatreBooker theatreBooker;

    @EJB
    Theatre theatre;


    private int seatId;
    private String selectedType;

    public ReservationView() {
    }





}
