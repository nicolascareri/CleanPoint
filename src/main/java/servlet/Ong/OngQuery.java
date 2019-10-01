package servlet.Ong;

import servlet.EMF;

import javax.persistence.*;
import java.util.List;

public class OngQuery {
    public List<Ong> getAll(){
        EntityManager em = EMF.createEntityManager();
        Query query = em.createQuery("SELECT o from Ong o");
        List<Ong> ongs = query.getResultList();
        em.close();
        return ongs;
    }
    public Ong getOng(int id){
        EntityManager em = EMF.createEntityManager();
        Ong ong = em.find(Ong.class, id);
        em.close();
        return ong;
    }
    public void createOng(Ong ong){
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(ong);
        em.getTransaction().commit();
        em.close();
    }
    public void setBeneficio(Double beneficio, int id){
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();

        Ong ong = em.find(Ong.class, id);
        ong.setBeneficioRecibido(beneficio);

        em.getTransaction().commit();
        em.close();
    }
}
