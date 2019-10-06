package servlet.puntolimpio;

import servlet.EMF;
import servlet.reporte.Reporte;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import java.util.List;

public class PuntoLimpioQuery {
    public List<PuntoLimpio> getAll(){
        return PuntoLimpioDAO.getInstance().findAll();
    }
    public PuntoLimpio getPuntoLimpio(int id){
       return PuntoLimpioDAO.getInstance().findById(id);
    }
    public PuntoLimpio createPuntoLimpio(PuntoLimpio pl){
        return PuntoLimpioDAO.getInstance().persist(pl);
    }
    public List<Double> getVolumen(){
        return PuntoLimpioDAO.getInstance().getVolumen();
    }
    public List<Reporte> getReportes(int id){
        return PuntoLimpioDAO.getInstance().getReportes(id);
    }
}
