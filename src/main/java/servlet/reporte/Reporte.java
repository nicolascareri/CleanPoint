package servlet.reporte;

import servlet.item.Item;
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

    public Reporte() {

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
