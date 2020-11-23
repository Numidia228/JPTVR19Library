package entity.dbcontroller;

import entity.Book;
import entity.factory.ConnectSingleton;
import javax.persistence.EntityManager;

public class BookFacade extends AbstractFacade<Book>{
    private EntityManager em;

    public BookFacade() {
        super(Book.class);
        ConnectSingleton connectSingleton = ConnectSingleton.getInstance();
        em = connectSingleton.getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}