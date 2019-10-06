package servlet.puntolimpio;

import servlet.EMF;
import servlet.reporte.Reporte;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/puntolimpio")
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
    @Path("/{id}/tamaño")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response isLleno(){
        List tamaño = query.getVolumen();
        return Response.status(200).entity(tamaño).build();
    }
    @Path("/{id}/reciclado")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportes(@PathParam("id") String msg) {
        int id = Integer.valueOf(msg);
        List<Reporte> reportes = query.getReportes(id);
        return Response.status(201).entity(reportes).build();
    }
}
