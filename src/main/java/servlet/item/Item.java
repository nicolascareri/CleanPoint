package servlet.item;

import javax.persistence.*;

@Entity
public class Item {
    @Id @GeneratedValue
    @Column
    int id;
    @Column
    int cantidad;
    @Column
    String tipo;
    @Column
    boolean reciclable;

    public Item() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isReciclable() {
        return reciclable;
    }

    public void setReciclable(boolean reciclable) {
        this.reciclable = reciclable;
    }
}
