package eventum.dao;

import eventum.model.Evento;
import java.util.List;

public class EventoDAO extends DAO<Evento> {

    @Override
    public Evento getById(final Long id) {
        return em.find(Evento.class, id);
    }

    @Override
    public boolean removeById(final Long id) {

        boolean result = true;

        try {
            Evento evento = this.getById(id);
            super.remover(evento);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Evento> findAll() {
        return em.createQuery("FROM Evento").getResultList();
    }

    public Evento consultarPorId(Long id) {

        Evento l = null;
        try {
            l = em.find(Evento.class, id); // executa o select
        } finally {
            em.close();
        }
        return l;
    }
}
