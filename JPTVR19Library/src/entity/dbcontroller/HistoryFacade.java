package entity.dbcontroller;

import entity.History;
import entity.Reader;
import entity.factory.ConnectSingleton;
import java.util.List;
import javax.persistence.EntityManager;

public class HistoryFacade extends AbstractFacade<History>{
    private EntityManager em;

    public HistoryFacade() {
        super(History.class);
        ConnectSingleton connectSingleton = ConnectSingleton.getInstance();
        em = connectSingleton.getEntityManager();
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