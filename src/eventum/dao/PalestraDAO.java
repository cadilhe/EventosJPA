package eventum.dao;

import eventum.model.Palestra;
import java.util.List;

public class PalestraDAO extends DAO<Palestra> {

    @Override
    public Palestra getById(final Long id) {
        return em.find(Palestra.class, id);
    }

    @Override
    public boolean removeById(final Long id) {

        boolean result = true;

        try {
            Palestra palestra = this.getById(id);
            super.remove(palestra);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Palestra> findAll() {
        return em.createQuery("FROM Palestra").getResultList();
    }

    public Palestra consultarPorId(Long id) {

        Palestra l = null;
        try {
            l = em.find(Palestra.class, id); // executa o select
        } finally {
            em.close();
        }
        return l;
    }
}
