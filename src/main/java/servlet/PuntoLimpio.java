package servlet;

import javax.persistence.*;
import java.util.List;

@Entity
public class PuntoLimpio {
    @Id @GeneratedValue
    @Column
    int id;
    @Column
    String direccion;
    @Column
    @OneToMany
    List<Reporte> reportes;

    public PuntoLimpio(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public List<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }
}

