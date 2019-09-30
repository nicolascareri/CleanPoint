package servlet.item;

import servlet.EMF;

import javax.persistence.*;
import java.util.List;

public class ItemQuery {
    public List<Item> getAllItem(){
        EntityManager em = EMF.createEntityManager();
        Query allItems = em.createQuery("SELECT i FROM Item i");
        List<Item> items = allItems.getResultList();
        em.close();
        return items;
    }

    public Item getItem(int id){
        EntityManager em = EMF.createEntityManager();
        Item item = em.find(Item.class, id);
        em.close();
        return item;
    }

    public Item getItemReciclable(int id){
        EntityManager em = EMF.createEntityManager();
        Item item = em.find(Item.class, id);
        em.close();
        return item;
    }

    public void createItem(Item item){
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
    }
}
