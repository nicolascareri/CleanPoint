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
    @ManyToOne
    Usuario usuario;
    @OneToOne
    Item item;
    @Column
    double volumen;
    @ManyToOne
    PuntoLimpio puntoLimpio;
    @Column
    double ahorro;
    @OneToOne
    Ong ong;

    public Reporte() {

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
