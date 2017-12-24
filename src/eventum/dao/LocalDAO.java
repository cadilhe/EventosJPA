package eventum.dao;

import exemplo.jpa.modelo.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocalDAO {

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
     * Método Salvar. Pelo fato de estarmos gerenciando localmente os serviço de
     * conexão e transações com o BD, precisamos inicializar e fechar as
     * transações com o método getTransantion()
     */
    public Local salvar(Local local) {
        EntityManager em = getEM(); // Chamar o trabalhador
        try {
            em.getTransaction().begin(); // iniciar uma transação                
            if (local.getId() == null) { // se o regsistro estiver vazio
                em.persist(local); // persistir o objeto no banco
            } else {
                if (!em.contains(local)) { // verificando se o campo existe
                    if (em.find(Local.class, local.getId()) == null) {
                        throw new Exception("Erro ao atualizar o local!");
                    }
                }
                local = em.merge(local); // executa update
            }
            em.getTransaction().commit(); // confirmar a transação
        } catch (Exception e) { //Tratar excessão 
            em.getTransaction().rollback(); // Desfazer tudo caso não de certo: rollback
        } finally {
            em.close();
        }
        return local;
    }

    public void remover(Long id) {
        EntityManager em = getEM();
        Local local = em.find(Local.class, id); // acha o registro do local com o método find()
        try {
            em.getTransaction().begin();
            em.remove(local); // executa o delete
            em.getTransaction().commit();
        } catch (Exception e) { //Tratar execessão 
            em.getTransaction().rollback(); // Desfazer tudo caso não de certo: rollback
        } finally {
            em.close();
        }
    }

    public Local consultarPorId(Long id) {
        EntityManager em = getEM();
        Local l = null;
        try {
            l = em.find(Local.class, id); // executa o select
        } finally {
            em.close();
        }
        return l;
    }
}
