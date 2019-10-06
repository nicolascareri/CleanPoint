package servlet.Ong;

import servlet.DAO.DAO;
import servlet.EMF;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OngDAO implements DAO<Ong , Integer> {

    private static OngDAO daoOng;

    private OngDAO(){}

    public static OngDAO getInstance(){
        if (daoOng == null)
            daoOng = new OngDAO();
        return daoOng;
    }

    public Ong findById(Integer id) {
        EntityManager em = EMF.createEntityManager();
        Ong ong = em.find(Ong.class, id);
        em.close();
        return ong;
    }

    public Ong persist(Ong ong) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(ong);
        em.getTransaction().commit();
        em.close();
        return ong;
    }

    public Ong delete(Integer integer) {
        return null;
    }

    public List<Ong> findAll() {
        EntityManager em = EMF.createEntityManager();
        Query query = em.createQuery("SELECT o from Ong o");
        List<Ong> ongs = query.getResultList();
        em.close();
        return ongs;
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
