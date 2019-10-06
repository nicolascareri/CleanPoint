package servlet.puntolimpio;

import servlet.DAO.DAO;
import servlet.EMF;
import servlet.reporte.Reporte;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PuntoLimpioDAO implements DAO<PuntoLimpio, Integer> {
    private static PuntoLimpioDAO daoPuntoLimpio;

    public static PuntoLimpioDAO getInstance(){
        if (daoPuntoLimpio == null)
            daoPuntoLimpio = new PuntoLimpioDAO();
        return daoPuntoLimpio;
    }

    public PuntoLimpio findById(Integer id) {
        EntityManager em = EMF.createEntityManager();
        PuntoLimpio pl = em.find(PuntoLimpio.class, id);
        em.close();
        return pl;
    }

    public PuntoLimpio persist(PuntoLimpio pl) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(pl);
        em.getTransaction().commit();
        em.close();
        return pl;
    }

    public PuntoLimpio delete(Integer integer) {
        return null;
    }

    public List<PuntoLimpio> findAll() {
        EntityManager em = EMF.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM PuntoLimpio");
        List<PuntoLimpio> allPL = query.getResultList();
        em.close();
        return allPL;
    }

    public List<Reporte> getReportes(int id){
        EntityManager em = EMF.createEntityManager();
        Query query = em.createQuery("SELECT r from Reporte r where r.puntoLimpio = :id");
        query.setParameter("id", id);
        List<Reporte> reportes = query.getResultList();
        return reportes;
    }
    public List<Double> getVolumen(){
        EntityManager em = EMF.createEntityManager();
        Query query = em.createQuery("SELECT pl.cargaMaxima - pl.cargaActual from PuntoLimpio pl");
        List<Double> tamaño = query.getResultList();
        em.close();
        return tamaño;
    }
}
