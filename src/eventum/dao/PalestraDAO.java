package eventum.dao;

import eventum.model.Palestra;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PalestraDAO {

    /**
     * Criar a fábrica de gerenciadores de Entidades: EntityManagerFactory.
     * Neste método, primeiro é criada a factory e ela se encarrega de criar o
     * EntityManager
     * @return 
     */
    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EventosPU");
        return factory.createEntityManager();
    }

    /**
     * Método Salvar. Pelo fato de estarmos gerenciando palestramente os serviço de
     * conexão e transações com o BD, precisamos inicializar e fechar as
     * transações com o método getTransantion()
     */
    public Palestra salvar(Palestra palestra) {
        EntityManager em = getEM(); // Chamar o trabalhador
        try {
            em.getTransaction().begin(); // iniciar uma transação                
            if (palestra.getId() == null) { // se o regsistro estiver vazio
                em.persist(palestra); // persistir o objeto no banco
            } else {
                if (!em.contains(palestra)) { // verificando se o campo existe
                    if (em.find(Palestra.class, palestra.getId()) == null) {
                        throw new Exception("Erro ao atualizar o palestra!");
                    }
                }
                palestra = em.merge(palestra); // executa update
            }
            em.getTransaction().commit(); // confirmar a transação
        } catch (Exception e) { //Tratar excessão 
            em.getTransaction().rollback(); // Desfazer tudo caso não de certo: rollback
        } finally {
            em.close();
        }
        return palestra;
    }

    public void remover(Long id) {
        EntityManager em = getEM();
        Palestra palestra = em.find(Palestra.class, id); // acha o registro do palestra com o método find()
        try {
            em.getTransaction().begin();
            em.remove(palestra); // executa o delete
            em.getTransaction().commit();
        } catch (Exception e) { //Tratar execessão 
            em.getTransaction().rollback(); // Desfazer tudo caso não de certo: rollback
        } finally {
            em.close();
        }
    }

    public Palestra consultarPorId(Long id) {
        EntityManager em = getEM();
        Palestra l = null;
        try {
            l = em.find(Palestra.class, id); // executa o select
        } finally {
            em.close();
        }
        return l;
    }
}
