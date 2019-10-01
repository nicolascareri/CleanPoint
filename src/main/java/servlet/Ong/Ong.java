package servlet.Ong;

import javax.persistence.*;

@Entity
public class Ong {
    @Id @GeneratedValue
    @Column
    int id;
    @Column
    String nombre;
    @Column
    double beneficioRecibido;

    public Ong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getBeneficioRecibido() {
        return beneficioRecibido;
    }

    public void setBeneficioRecibido(double beneficioRecibido) {
        this.beneficioRecibido = beneficioRecibido;
    }
}

