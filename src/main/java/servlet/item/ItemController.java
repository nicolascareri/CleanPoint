package servlet.item;

import servlet.EMF;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/item")
public class ItemController {
    private ItemQuery query = new ItemQuery();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems() {
        List items = query.getAllItem();
        return Response.status(200).entity(items).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemById(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        Item item = query.getItem(id);
        return Response.status(200).entity(item).build();
    }
    @GET
    @Path("/{id}/reciclable")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemByIdReciclable(@PathParam("id") String msg){
        int id = Integer.valueOf(msg);
        Item item = query.getItemReciclable(id);
        return Response.status(200).entity(item.isReciclable()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response creataItem(Item item) {
        query.createItem(item);
        return Response.status(201).entity(null).build();
    }

}
