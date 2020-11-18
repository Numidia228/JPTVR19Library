package entity.dbcontroller;

import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserFacade extends AbstractFacade<User>{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();

    public UserFacade(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
