package servlet.DAO;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.util.List;

public interface DAO<Entity, ID extends Serializable> {
    public Entity findById(ID id);
    public Entity persist(Entity entity);
    public Entity delete(ID id);
    public List<Entity> findAll();
}
