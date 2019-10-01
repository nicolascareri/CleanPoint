package servlet.puntolimpio;

import servlet.reporte.Reporte;

import javax.persistence.*;
import java.util.List;

@Entity
public class PuntoLimpio {
    @Id @GeneratedValue
    @Column
    int id;
    @Column
    String direccion;
    @OneToMany(mappedBy = "puntoLimpio")
    List<Reporte> reportes;
    @Column
    double cargaActual;
    @Column
    double cargaMaxima;
    public PuntoLimpio(){

    }

    public double getCargaMaxima(){
        return this.cargaMaxima;
    }
    public double getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(double cargaActual) {
        this.cargaActual = cargaActual;
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

