package entity.dbcontroller;

import entity.History;
import entity.Reader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HistoryFacade extends AbstractFacade<History>{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();

    public HistoryFacade(Class<History> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<History> findReadAll(Reader reader, Boolean read) {
        if(read == true){
            try {
                return em.createQuery("SELECT h FROM History h WHERE h.reader = :reader AND h.returnDate = NULL")
                        .setParameter("reader", reader)
                        .getResultList();
            } catch (Exception e) {
                return null;
            }
        }else{
            try {
                return em.createQuery("SELECT h FROM History h WHERE h.reader = :reader")
                        .setParameter("reader", reader)
                        .getResultList();
            } catch (Exception e) {
                return null;
            }
        }
    }



}
