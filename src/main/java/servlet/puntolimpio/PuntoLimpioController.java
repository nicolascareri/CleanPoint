package servlet.puntolimpio;

import servlet.EMF;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("PuntoLimpio")
public class PuntoLimpioController {
    private PuntoLimpioQuery query = new PuntoLimpioQuery();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntosLimpios(){
        List<PuntoLimpio> allPL = query.getAll();
        return Response.status(200).entity(allPL).build();
    }
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntoLimpioById(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        PuntoLimpio pl = query.getPuntoLimpio(id);
        return Response.status(200).entity(pl).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPuntoLimpio(PuntoLimpio pl){
        query.createPuntoLimpio(pl);
        return Response.status(201).entity(null).build();
    }
}
