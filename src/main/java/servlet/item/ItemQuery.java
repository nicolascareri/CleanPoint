package servlet.item;

import servlet.EMF;

import javax.persistence.*;
import java.util.List;

public class ItemQuery {
    public List<Item> getAllItem(){
        return ItemDAO.getInstance().findAll();
    }

    public Item getItem(int id){
        return ItemDAO.getInstance().findById(id);
    }

    public Item getItemReciclable(int id){
        return ItemDAO.getInstance().getItemReciclable(id);
    }

    public Item createItem(Item item){
        return ItemDAO.getInstance().persist(item);
    }
}
