package servlet.Ong;

import servlet.EMF;

import javax.persistence.*;
import java.util.List;

public class OngQuery {
    public List<Ong> getAll(){
       return OngDAO.getInstance().findAll();
    }
    public Ong getOng(int id){
       return OngDAO.getInstance().findById(id);
    }
    public Ong createOng(Ong ong){
        return OngDAO.getInstance().persist(ong);
    }
    public void setBeneficio(Double beneficio, int id){
       OngDAO.getInstance().setBeneficio(beneficio, id);
    }
}
