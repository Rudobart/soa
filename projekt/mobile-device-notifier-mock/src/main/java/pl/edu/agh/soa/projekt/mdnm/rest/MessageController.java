package pl.edu.agh.soa.projekt.mdnm.rest;

import pl.edu.agh.soa.projekt.mdnm.MessageBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/message")
public class MessageController {


    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public Response getMessage() {
        return Response
                .status(Response.Status.OK)
                .entity(MessageBean.message)
                .build();
    }

}
