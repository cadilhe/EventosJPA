package eventum.dao;

import eventum.model.Palestrante;
import java.util.List;

public class PalestranteDAO extends DAO<Palestrante> {

    @Override
    public Palestrante getById(final Long id) {
        return em.find(Palestrante.class, id);
    }

    @Override
    public boolean removeById(final Long id) {

        boolean result = true;

        try {
            Palestrante palestrante = this.getById(id);
            super.remove(palestrante);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Palestrante> findAll() {
        return em.createQuery("FROM Palestrante").getResultList();
    }

    public Palestrante consultarPorId(Long id) {

        Palestrante l = null;
        try {
            l = em.find(Palestrante.class, id); // executa o select
        } finally {
            em.close();
        }
        return l;
    }
}
