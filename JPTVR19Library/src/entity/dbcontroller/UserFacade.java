package entity.dbcontroller;

import entity.User;
import entity.factory.ConnectSingleton;
import javax.persistence.EntityManager;

public class UserFacade extends AbstractFacade<User> {
    private EntityManager em;

    public UserFacade() {
        super(User.class);
        ConnectSingleton connectSingleton = ConnectSingleton.getInstance();
        em = connectSingleton.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
