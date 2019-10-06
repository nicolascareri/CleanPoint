package servlet.reporte;

import servlet.DAO.DAO;
import servlet.EMF;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ReporteDAO implements DAO<Reporte, Integer> {
    private static ReporteDAO daoReporte;

    public static ReporteDAO getInstance(){
        if (daoReporte == null)
            daoReporte = new ReporteDAO();
        return daoReporte;
    }

    public Reporte findById(Integer id) {
        EntityManager em = EMF.createEntityManager();
        Reporte reporte = em.find(Reporte.class, id);
        em.close();
        return reporte;
    }

    public Reporte persist(Reporte reporte) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(reporte);
        em.getTransaction().commit();
        em.close();
        return reporte;
    }

    public Reporte delete(Integer integer) {
        return null;
    }

    public List<Reporte> findAll() {
        EntityManager em = EMF.createEntityManager();
        Query allReportes = em.createQuery("SELECT r FROM Reporte r");
        List<Reporte> reportes = allReportes.getResultList();
        em.close();
        return reportes;
    }
}
