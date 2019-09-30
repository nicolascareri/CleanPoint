package servlet.reporte;

import servlet.item.Item;
import servlet.usuario.Usuario;

import javax.persistence.EntityManager;
import java.sql.Date;
public class ReporteParam {
    int id;
    Date fechaAlta;
    int usuario;
    int item;

    public ReporteParam() {
    }

    public ReporteParam(Reporte rep){
        this.id = rep.getId();
        this.fechaAlta = rep.getFechaAlta();
        this.usuario = rep.getUsuario().getId();
        this.item = rep.getItem().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Reporte toReporte(EntityManager em){
        Reporte reporte = new Reporte();
        reporte.setId(this.id);
        reporte.setFechaAlta(this.fechaAlta);
        reporte.setUsuario(em.find(Usuario.class, this.usuario));
        reporte.setItem(em.find(Item.class, this.item));
        return reporte;
    }
}
