package servlet.usuario;

import servlet.EMF;
import servlet.reporte.Reporte;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.List;

@Path("/usuario")
public class UsuarioController {
    private UsuarioQuery query = new UsuarioQuery();
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioById(@PathParam("id") String msg) {
        int id = Integer.valueOf(msg);
        Usuario usuario = query.getUsuario(id);
        return Response.status(200).entity(usuario).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        List<Usuario> usuarios = query.getAll();

        return Response.status(200).entity(usuarios).build();
    }
    @GET
    @Path("/{id}/reporte")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportesPorUsuario(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        List<Reporte> reportes = query.getReportesByUsuario(id);
        return Response.status(200).entity(reportes).build();
    }
    @GET
    @Path("/{id}/reporte/{f1}/{f2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportesPorFecha(@PathParam("id") String msg, @PathParam("f1") String f1, @PathParam("f2") String f2){
        Date fecha1 = Date.valueOf(f1);
        Date fecha2 = Date.valueOf(f2);
        int id = Integer.valueOf(msg);
        List<Reporte> reportes = query.getReportesByFecha(id, fecha1, fecha2);
        return Response.status(200).entity(reportes).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUsuario(Usuario usuario) {
        query.createUsuario(usuario);
        return Response.status(201).entity(null).build();
    }
}
