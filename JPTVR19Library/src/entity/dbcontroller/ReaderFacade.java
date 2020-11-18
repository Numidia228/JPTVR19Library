package entity.dbcontroller;

import entity.Reader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReaderFacade extends AbstractFacade<Reader>{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();

    public ReaderFacade(Class<Reader> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
