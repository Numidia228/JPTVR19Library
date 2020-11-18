package entity.dbcontroller;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookFacade extends AbstractFacade<Book>{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();

    public BookFacade(Class<Book> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}
