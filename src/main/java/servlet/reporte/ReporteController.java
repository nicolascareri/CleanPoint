package servlet.reporte;

import servlet.EMF;
import servlet.Ong.Ong;
import servlet.puntolimpio.PuntoLimpio;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reporte")
public class ReporteController {
    private ReporteQuery query = new ReporteQuery();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportes(){
        List<Reporte> reportes = query.getAll();
        return Response.status(200).entity(reportes).build();
    }
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReporteById(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        Reporte reporte = query.getReporte(id);
        return Response.status(201).entity(reporte).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReporte(ReporteParam reporte){
        EntityManager em = EMF.createEntityManager();
        Reporte rep = reporte.toReporte(em);
        query.createReporte(rep);
        return Response.status(201).entity(null).build();
    }
}
