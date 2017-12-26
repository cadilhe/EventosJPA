package eventum.dao;

import eventum.model.T;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericoDAO <T extends EntidadeBase> {

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
     * Método Salvar. Pelo fato de estarmos gerenciando tmente os serviço de
     * conexão e transações com o BD, precisamos inicializar e fechar as
     * transações com o método getTransantion()
     */
    public T salvar(T t) {
        EntityManager em = getEM(); // Chamar o trabalhador
        try {
            em.getTransaction().begin(); // iniciar uma transação                
            if (t.getId() == null) { // se o regsistro estiver vazio
                em.persist(t); // persistir o objeto no banco
            } else {
                if (!em.contains(t)) { // verificando se o campo existe
                    if (em.find(T.getClass(), t.getId()) == null) {
                        throw new Exception("Erro ao atualizar o t!");
                    }
                }
                t = em.merge(t); // executa update
            }
            em.getTransaction().commit(); // confirmar a transação
        } catch (Exception e) { //Tratar excessão 
            em.getTransaction().rollback(); // Desfazer tudo caso não de certo: rollback
        } finally {
            em.close();
        }
        return t;
    }

    public void remover(Long id) {
        EntityManager em = getEM();
        T t = em.find(T.getClass(), id); // acha o registro do t com o método find()
        try {
            em.getTransaction().begin();
            em.remove(t); // executa o delete
            em.getTransaction().commit();
        } catch (Exception e) { //Tratar execessão 
            em.getTransaction().rollback(); // Desfazer tudo caso não de certo: rollback
        } finally {
            em.close();
        }
    }

    public T consultarPorId(Long id) {
        EntityManager em = getEM();
        T t = null;
        try {
            t = em.find(T.getClass(), id); // executa o select
        } finally {
            em.close();
        }
        return t;
    }
}
