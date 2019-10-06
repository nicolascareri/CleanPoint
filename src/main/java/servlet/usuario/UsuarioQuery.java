package servlet.usuario;

import servlet.EMF;
import servlet.reporte.Reporte;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class UsuarioQuery {

    public Usuario getUsuario(int id){
        return UsuarioDAO.getInstance().findById(id);
    }

    public List<Usuario> getAll(){
        return UsuarioDAO.getInstance().findAll();
    }

    public List<Reporte> getReportesByUsuario(int id){
        return UsuarioDAO.getInstance().getReportes(id);
    }

    public List<Reporte> getReportesByFecha(int id, Date f1, Date f2){
        return UsuarioDAO.getInstance().getReportesByFecha(id, f1, f2);
    }

    public void createUsuario(Usuario usuario){
        UsuarioDAO.getInstance().persist(usuario);
    }
}
