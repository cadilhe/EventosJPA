package eventum.dao;

import eventum.model.Palestra;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PalestraDAO extends GenericoDAO <Palestra> {
    /**
     * Método Salvar. Pelo fato de estarmos gerenciando palestramente os serviço de
     * conexão e transações com o BD, precisamos inicializar e fechar as
     * transações com o método getTransantion()
     */
    public Palestra salvar(Palestra palestra) {
        EntityManager em = getEM(); // Chamar o trabalhador
        try {
            em.getTransaction().begin(); // iniciar uma transação                
            em.persist(palestra); 
            em.getTransaction().commit(); // confirmar a transação
        } finally {
            em.close();
        }
        return palestra;
    }

    public void remover(Long id) {
        EntityManager em = getEM();        
        try {
            em.getTransaction().begin();
			Palestra palestra = em.find(Palestra.class, id); // acha o registro do palestra com o método find()
            em.remove(palestra); // executa o delete
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Palestra consultarPorId(Long id) {
        EntityManager em = getEM();
        Palestra p = null;
        try {
            p = em.find(Palestra.class, id); // executa o select
        } finally {
            em.close();
        }
        return p;
    }
}
