package servlet.reporte;

import servlet.DAO.DAO;
import servlet.EMF;
import servlet.Ong.Ong;
import servlet.puntolimpio.PuntoLimpio;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

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
        PuntoLimpio pl = em.find(PuntoLimpio.class, reporte.getPuntoLimpio().getId());
        Ong ong = em.find(Ong.class, reporte.getOng().getId());
        double volumen = reporte.getVolumen();
        double ahorro = reporte.getAhorro();
        volumen += pl.getCargaActual();
        ahorro += ong.getBeneficioRecibido();
        pl.setCargaActual(volumen);
        ong.setBeneficioRecibido(ahorro);
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
        em.getTransaction().begin();
        Query allReportes = em.createQuery("SELECT r FROM Reporte r");
        List<Reporte> reportes = allReportes.getResultList();
        reportes = reportes.stream().map(r->r.copiar()).collect(Collectors.toList());
        em.getTransaction().commit();
        em.close();
        return reportes;
    }
}
