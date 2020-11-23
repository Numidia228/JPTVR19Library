package entity.dbcontroller;

import entity.Reader;
import entity.factory.ConnectSingleton;
import javax.persistence.EntityManager;

public class ReaderFacade extends AbstractFacade<Reader>{
    private EntityManager em;

    public ReaderFacade() {
        super(Reader.class);
        ConnectSingleton connectSingleton = ConnectSingleton.getInstance();
        em = connectSingleton.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
