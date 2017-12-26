/*
 * Esta classe DAO é a abordagem do professor Lucas Venezian
 */
package eventum.dao;

import eventum.model.Local;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<E> { // E de element

    protected EntityManager em; // cria uma variável do tipo EntityManager

    public DAO() {
        em = getEntityManager(); // inicializa a variável com o retorno do método getEntityManager()        
    }

// FÁBRICA DE SESSÃO    
    private EntityManager getEntityManager() {
        // Este método cria a fábrica de EntityManager para a UP e a associa ao EntityManager em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EventosPU");

        if (em == null) {
            em = emf.createEntityManager();
        }

        return em;
    }

// MÉTODOS DE PERSISTÊNCIA
    // salvar objeto
    public boolean salvar(E object) {

        boolean result = true;

        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        return result;
    }

    // atualizar objeto
    public boolean atualizar(E object) {

        boolean result = true;

        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        return result;
    }

    // remover objeto
    public boolean remover(E object) {

        boolean result = true;

        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        return result;
    }
    
    // Listar todos objetos
    public abstract List<E> findAll();

    // Obter o objeto por seu id
    public abstract E getById(final Long id);

    // Remover o objeto por seu id
    public abstract boolean removeById(final Long id);
    
   

// MÉTODOS ALTERNATIVOS PROPOSTOS EM ARTIGOS E TUTORIALS 

    /*    
    public Local salvarAtualizar(E object) {

        boolean result = true;

        try {
            em.getTransaction().begin();         
            if (object.getId() == null) { // 
                em.persist(object); // persistir o objeto no banco
            } else {
                if (!em.contains(object)) { // verificando se o campo existe
                    if (em.find(E.getClass(), object.getId()) == null) {
                        throw new Exception("Erro ao atualizar o objeto!");
                    }
                }
                object = em.merge(object); // executa update
            }
            em.getTransaction().commit();
        } catch (Exception e) {  
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return result;
    }
    
    public T consultarPorId(Long id) {       
        E object = null;
        try {
            t = em.find(E.getClass(), id); // executa o select
        } finally {
            em.close();
        }
        return t;
    }
*/



}
