package pl.edu.agh.soa.projekt.pas.rest;

import pl.edu.agh.soa.projekt.pas.model.dto.ParkingPlaceDTO;
import pl.edu.agh.soa.projekt.pas.model.dto.StreetDTO;
import pl.edu.agh.soa.projekt.pas.service.area.AreaService;
import pl.edu.agh.soa.projekt.pas.service.parkingplace.ParkingPlaceService;
import pl.edu.agh.soa.projekt.pas.service.street.StreetService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/street")
public class StreetController {
    @EJB
    private StreetService streetService;

    @EJB
    private ParkingPlaceService parkingPlaceService;

    @EJB
    private AreaService areaService;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getStreet(@PathParam("id") Long id) {
        return Response.ok(streetService.getStreetDTO(id)).build();
    }

    @GET
    @Path("/{id}/parkingplace")
    @Produces(APPLICATION_JSON)
    public List<ParkingPlaceDTO> getParkingPlacesForStreet(@PathParam("id") Long id) {
        return parkingPlaceService.getParkingPlaceDTOsForStreet(id);
    }

    @GET
    @Path("/{id}/area")
    @Produces(APPLICATION_JSON)
    public Response getAreaForStreet(@PathParam("id") Long id) {
        return Response.ok(areaService.getAreaDTOByStreetId(id)).build();
    }

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public List<StreetDTO> getStreets() {
        return streetService.getStreetDTOs();
    }
}
