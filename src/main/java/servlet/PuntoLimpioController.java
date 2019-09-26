package servlet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("PuntoLimpio")
public class PuntoLimpioController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntosLimpios(){
        EntityManager em = EMF.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM PuntoLimpio");
        List<PuntoLimpio> allPL = query.getResultList();
        return Response.status(200).entity(allPL).build();
    }
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntoLimpioById(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        EntityManager em = EMF.createEntityManager();
        PuntoLimpio pl = em.find(PuntoLimpio.class, id);
        return Response.status(200).entity(pl).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPuntoLimpio(PuntoLimpio pl){
        EntityManager em = EMF.createEntityManager();
        em.persist(pl);
        return Response.status(201).entity(null).build();
    }
}
