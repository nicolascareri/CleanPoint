package servlet.reporte;

import servlet.EMF;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ReporteQuery {

    public List<Reporte> getAll(){
        return ReporteDAO.getInstance().findAll();
    }

    public Reporte getReporte(int id){
        return ReporteDAO.getInstance().findById(id);
    }
    public Reporte createReporte(Reporte reporte){
        return ReporteDAO.getInstance().persist(reporte);
    }
}
