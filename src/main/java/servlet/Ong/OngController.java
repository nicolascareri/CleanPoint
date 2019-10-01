package servlet.Ong;

import servlet.reporte.Reporte;

import javax.persistence.Query;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ong")
public class OngController {
    private static OngQuery query = new OngQuery();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOng(){
        List<Ong> ongs = query.getAll();
        return Response.status(200).entity(ongs).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getOngById(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        Ong ong = query.getOng(id);
        return Response.status(200).entity(ong).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOng(Ong ong){
        query.createOng(ong);
        return Response.status(201).entity(null).build();
    }
    @POST
    @Path("/{id}/{beneficio}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setBeneficio(@PathParam("beneficio") String msg, @PathParam("id") String idParam){
        double beneficio = Double.valueOf(msg);
        int id = Integer.valueOf(idParam);
        query.setBeneficio(beneficio, id);
        return Response.status(201).entity(null).build();
    }
}
