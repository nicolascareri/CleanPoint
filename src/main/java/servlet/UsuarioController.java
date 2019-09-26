package servlet;

import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
public class UsuarioController {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioById(@PathParam("id") String msg) {
        int id = Integer.valueOf(msg);
        EntityManager em = EMF.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        return Response.status(201).entity(usuario).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        EntityManager em = EMF.createEntityManager();
        Query allUsuarios = em.createNativeQuery("SELECT * FROM Usuario");
        List usuarios = allUsuarios.getResultList();
        return Response.status(201).entity(usuarios).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUsuario(Usuario usuario) {
        EntityManager em = EMF.createEntityManager();
        em.persist(usuario);
        return Response.status(201).entity(null).build();

    }
}
