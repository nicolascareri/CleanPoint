package servlet.reporte;

import servlet.EMF;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ReporteQuery {
    public List<Reporte> getAll(){
        EntityManager em = EMF.createEntityManager();
        Query allReportes = em.createQuery("SELECT r FROM Reporte r");
        List<Reporte> reportes = allReportes.getResultList();
        em.close();
        return reportes;
    }
    public Reporte getReporte(int id){
        EntityManager em = EMF.createEntityManager();
        Reporte reporte = em.find(Reporte.class, id);
        em.close();
        return reporte;
    }
    public void createReporte(ReporteParam reporte){
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(reporte.toReporte(em));
        em.getTransaction().commit();
        em.close();
    }
}
