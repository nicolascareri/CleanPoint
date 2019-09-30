package servlet.puntolimpio;

import servlet.EMF;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PuntoLimpioQuery {
    public List<PuntoLimpio> getAll(){
        EntityManager em = EMF.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM PuntoLimpio");
        List<PuntoLimpio> allPL = query.getResultList();
        em.close();
        return allPL;
    }
    public PuntoLimpio getPuntoLimpio(int id){
        EntityManager em = EMF.createEntityManager();
        PuntoLimpio pl = em.find(PuntoLimpio.class, id);
        em.close();
        return pl;
    }
    public void createPuntoLimpio(PuntoLimpio pl){
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(pl);
        em.getTransaction().commit();
        em.close();
    }
}
