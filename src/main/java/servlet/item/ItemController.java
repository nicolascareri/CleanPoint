package servlet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/item")
public class ItemController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems() {
        EntityManager em = EMF.createEntityManager();
        Query allItems = em.createQuery("SELECT i FROM Item i");
        List<Item> items = allItems.getResultList();
        return Response.status(200).entity(items).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemById(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        EntityManager em = EMF.createEntityManager();
        Item item = em.find(Item.class, id);
        return Response.status(200).entity(item).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemByIdReciclable(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        EntityManager em = EMF.createEntityManager();
        Item item = em.find(Item.class, id);
        return Response.status(200).entity(item.isReciclable()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response creataeItem(Item item) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
        return Response.status(201).entity(null).build();
    }

}
