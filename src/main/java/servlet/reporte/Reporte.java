package servlet.reporte;

import servlet.Ong.Ong;
import servlet.item.Item;
import servlet.puntolimpio.PuntoLimpio;
import servlet.usuario.Usuario;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Reporte {

    @Id @GeneratedValue
    @Column
    int id;
    @Column
    Date fechaAlta;
    @ManyToOne(cascade = CascadeType.REMOVE)
    Usuario usuario;
    @OneToOne(cascade = CascadeType.REMOVE)
    Item item;
    @Column
    double volumen;
    @ManyToOne(cascade = CascadeType.REMOVE)
    PuntoLimpio puntoLimpio;
    @Column
    double ahorro;
    @OneToOne(cascade = CascadeType.REMOVE)
    Ong ong;

    public Reporte() {

    }

    public Reporte copiar(){
        Reporte resultado = new Reporte();
        resultado.setAhorro(this.ahorro);
        resultado.setFechaAlta(this.fechaAlta);
        resultado.setId(this.id);
        resultado.setItem(this.item);
        resultado.setOng(this.ong);
        resultado.setUsuario(this.usuario);
        resultado.setVolumen(this.volumen);
        PuntoLimpio pl = new PuntoLimpio();
        pl.setId(this.puntoLimpio.getId());
        pl.setCargaActual(this.puntoLimpio.getCargaActual());
        pl.setDireccion(this.puntoLimpio.getDireccion());
        pl.setCargaMaxima(this.puntoLimpio.getCargaMaxima());
        resultado.setPuntoLimpio(pl);
        return resultado;
    }

    public double getAhorro() {
        return ahorro;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    public void setAhorro(double ahorro) {
        this.ahorro = ahorro;
    }

    public double getVolumen(){
        return this.volumen;
    }
    public PuntoLimpio getPuntoLimpio() {
        return puntoLimpio;
    }
    public void setPuntoLimpio(PuntoLimpio puntoLimpio) {
        this.puntoLimpio = puntoLimpio;
    }

    public void setVolumen(double volumen){
        this.volumen = volumen;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
