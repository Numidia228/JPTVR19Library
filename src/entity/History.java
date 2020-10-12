package entity;

import java.io.Serializable;
import java.util.Date;

public class History implements Serializable {
    private Book book;
    private Reader reader;
    private Date takeOnDate;
    private Date returnDate;

    public History() {
    }

    public History(Book book, Reader reader, Date takeOnDate, Date returnDate) {
        this.book = book;
        this.reader = reader;
        this.takeOnDate = takeOnDate;
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getTakeOnDate() {
        return takeOnDate;
    }

    public void setTakeOnDate(Date takeOnDate) {
        this.takeOnDate = takeOnDate;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Название книги = " + book.getName()
                + ", Читатель = " + reader.getFirstname()+" "+reader.getLastname()
                + ", Дата взятия книги = " + takeOnDate
                + ", Дата возврата  =" + returnDate
                + '}';
=======
        return "Книга = " + book.getName()
                + ", Читатель = " + reader.getFirstname()+" "+reader.getLastname()
                + ", Дата аренды = " + takeOnDate
                + ", Даат возврата = " + returnDate;
>>>>>>> b5f7cc4ecd5c46031a299b0b347ca50413069309
    }
}