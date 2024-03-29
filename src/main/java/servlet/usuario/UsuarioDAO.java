package servlet.usuario;

import servlet.DAO.DAO;
import servlet.EMF;
import servlet.reporte.Reporte;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario, Integer> {
    private static UsuarioDAO daoUsuario;

    public static UsuarioDAO getInstance(){
        if (daoUsuario == null)
            daoUsuario = new UsuarioDAO();
        return daoUsuario;
    }
    public Usuario findById(Integer id) {
        EntityManager em = EMF.createEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return usuario;
    }
    public List<Reporte> getReportesByFecha(Integer id, Date f1, Date f2){
        EntityManager em = EMF.createEntityManager();
        Query allReportes = em.createQuery("SELECT r.item FROM Reporte r " +
                "WHERE r.usuario.id = :id " +
                "AND r.fechaAlta BETWEEN :f1 AND :f2");
        allReportes.setParameter("id", id);
        allReportes.setParameter("f1", f1);
        allReportes.setParameter("f2", f2);
        List<Reporte> reportes = allReportes.getResultList();
        em.close();
        return reportes;
    }
    public Usuario persist(Usuario usuario) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
        return usuario;
    }

    public List<Reporte> getReportes(Integer id){
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        Query allReportes = em.createQuery("SELECT r.item FROM Reporte r WHERE r.usuario.id = :id ");
        allReportes.setParameter("id", id);
        List<Reporte> reportes = allReportes.getResultList();
        em.getTransaction().commit();
        em.close();
        return reportes;
    }

    public List<Usuario> findAll() {
        EntityManager em = EMF.createEntityManager();
        Query allUsuarios = em.createQuery("SELECT u FROM Usuario u");
        List<Usuario> usuarios = allUsuarios.getResultList();
        em.close();
        return usuarios;
    }

    public void deleteAll() {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNativeQuery("DELETE FROM Usuario");
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    public Usuario delete(Integer integer) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        Query deleteUsuario = em.createQuery("DELETE FROM Usuario u WHERE u.id = :integer");
        deleteUsuario.setParameter("integer", integer);
        deleteUsuario.executeUpdate();
        em.getTransaction().commit();
        em.close();
        return null;
    }
}
