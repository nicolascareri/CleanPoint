package servlet.item;

import servlet.DAO.DAO;
import servlet.EMF;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ItemDAO implements DAO<Item, Integer> {

    private static ItemDAO daoItem;

    private ItemDAO(){ }

    public static ItemDAO getInstance(){
        if (daoItem == null)
            daoItem = new ItemDAO();
        return daoItem;
    }

    public Item findById(Integer id) {
        EntityManager em = EMF.createEntityManager();
        Item item = em.find(Item.class, id);
        em.close();
        return item;
    }

    public Item persist(Item item) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
        return item;
    }

    public Item delete(Integer integer) {
        return null;
    }

    public List<Item> findAll() {
        EntityManager em = EMF.createEntityManager();
        Query allItems = em.createQuery("SELECT i FROM Item i");
        List<Item> items = allItems.getResultList();
        em.close();
        return items;
    }

    public Item getItemReciclable(int id){
        EntityManager em = EMF.createEntityManager();
        Item item = em.find(Item.class, id);
        em.close();
        return item;
    }

}
