package servlet.reporte;

import servlet.Ong.Ong;
import servlet.item.Item;
import servlet.puntolimpio.PuntoLimpio;
import servlet.usuario.Usuario;

import javax.persistence.EntityManager;
import java.sql.Date;
public class ReporteParam {
    int id;
    Date fechaAlta;
    int usuario;
    int item;
    double ahorro;
    double volumen;
    int puntolimpio;
    int ong;



    public ReporteParam(Reporte rep){
        this.id = rep.getId();
        this.fechaAlta = rep.getFechaAlta();
        this.usuario = rep.getUsuario().getId();
        this.item = rep.getItem().getId();
        this.puntolimpio = rep.getPuntoLimpio().getId();
        this.ong = rep.getOng().getId();
        this.ahorro = rep.getAhorro();
        this.volumen = rep.getVolumen();
    }
    public double getAhorro() {
        return ahorro;
    }

    public void setAhorro(double ahorro) {
        this.ahorro = ahorro;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public ReporteParam() {
    }
    public int getPuntolimpio() {
        return puntolimpio;
    }

    public void setPuntolimpio(int puntolimpio) {
        this.puntolimpio = puntolimpio;
    }

    public int getOng() {
        return ong;
    }

    public void setOng(int ong) {
        this.ong = ong;
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
        reporte.setAhorro(this.ahorro);
        reporte.setVolumen(this.volumen);
        reporte.setPuntoLimpio(em.find(PuntoLimpio.class, this.puntolimpio));
        reporte.setOng(em.find(Ong.class, this.ong));
        reporte.setUsuario(em.find(Usuario.class, this.usuario));
        reporte.setItem(em.find(Item.class, this.item));
        return reporte;
    }
}
