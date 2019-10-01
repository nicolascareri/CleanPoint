package servlet.puntolimpio;

import servlet.EMF;
import servlet.reporte.Reporte;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
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
    public List<Double> getVolumen(){
        EntityManager em = EMF.createEntityManager();
        Query query = em.createQuery("SELECT pl.cargaMaxima - pl.cargaActual from PuntoLimpio pl");
        List<Double> tamaño = query.getResultList();
        em.close();
        return tamaño;
    }
    public List<Reporte> getReportes(int id){
        EntityManager em = EMF.createEntityManager();
        Query query = em.createQuery("SELECT r from Reporte r where r.puntoLimpio = :id");
        query.setParameter("id", id);
        List<Reporte> reportes = query.getResultList();
        return reportes;
    }
}
