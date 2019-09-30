package servlet;

import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.List;

@Path("/usuario")
public class UsuarioController {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioById(@PathParam("id") String msg) {
        int id = Integer.valueOf(msg);
        EntityManager em = EMF.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        return Response.status(200).entity(usuario).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        EntityManager em = EMF.createEntityManager();
        Query allUsuarios = em.createQuery("SELECT u FROM Usuario u");
        List<Usuario> usuarios = allUsuarios.getResultList();
        return Response.status(200).entity(usuarios).build();
    }
    @GET
    @Path("/{id}/reporte")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportesPorUsuario(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        EntityManager em = EMF.createEntityManager();
        Query allReportes = em.createQuery("SELECT r.item FROM Reporte r WHERE r.usuario = :id ");
        allReportes.setParameter("id", id);
        List<Reporte> reportes = allReportes.getResultList();
        return Response.status(200).entity(reportes).build();
    }
    @GET
    @Path("/{id}/reporte/{f1}/{f2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportesPorFecha(@PathParam("id") String msg, @PathParam("f1") String f1, @PathParam("f2") String f2){
        Date fecha1 = Date.valueOf(f1);
        Date fecha2 = Date.valueOf(f2);
        int id = Integer.valueOf(msg);
        EntityManager em = EMF.createEntityManager();
        Query allReportes = em.createQuery("SELECT r.item FROM Reporte r " +
                "WHERE r.usuario = :id " +
                "AND r.fechaAlta BETWEEN :f1 AND :f2");
        allReportes.setParameter("id", id);
        allReportes.setParameter("f1", fecha1);
        allReportes.setParameter("f2", fecha2);
        List<Reporte> reportes = allReportes.getResultList();
        return Response.status(200).entity(reportes).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUsuario(Usuario usuario) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
        return Response.status(201).entity(null).build();
    }
}
