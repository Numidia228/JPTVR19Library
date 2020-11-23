package entity.factory;

import entity.dbcontroller.BookFacade;
import entity.dbcontroller.HistoryFacade;
import entity.dbcontroller.ReaderFacade;
import entity.dbcontroller.UserFacade;

public class FactoryFacade {

    public static BookFacade getBookFacade() {
        return new BookFacade();
    }

    public static ReaderFacade getReaderFacade() {
        return new ReaderFacade();
    }

    public static UserFacade getUserFacade() {
        return new UserFacade();
    }

    public static HistoryFacade getHistoryFacade() {
        return new HistoryFacade();
    }
}
