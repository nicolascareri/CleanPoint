package servlet;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reporte")
public class ReporteController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportes(){
        EntityManager em = EMF.createEntityManager();
        Query allReportes = em.createQuery("SELECT r FROM Reporte r");
        List<Reporte> reportes = allReportes.getResultList();
        return Response.status(200).entity(reportes).build();
    }
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReporteById(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        EntityManager em = EMF.createEntityManager();
        Reporte reporte = em.find(Reporte.class, id);
        return Response.status(201).entity(reporte).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReporte(Reporte reporte){
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(reporte);
        em.getTransaction().commit();
        em.close();
        return Response.status(201).entity(null).build();
    }
}
