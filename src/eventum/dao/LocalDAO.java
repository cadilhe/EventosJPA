package eventum.dao;

import eventum.model.Local;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocalDAO extends DAO<Local> {

    public Local getById(final Long id) {
        return em.find(Local.class, id);
    }
 
    public boolean removeById(final Long id) {
    	
    	boolean result = true;
    	
        try {
            Local local = this.getById(id);
            super.remover(local);
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }
 
    @SuppressWarnings("unchecked")
	public List<Local> findAll() {
    	return em.createQuery("FROM Local").getResultList();
    }

    public Local consultarPorId(Long id) {
        
        Local l = null;
        try {
            l = em.find(Local.class, id); // executa o select
        } finally {
            em.close();
        }
        return l;
    }

    
}
