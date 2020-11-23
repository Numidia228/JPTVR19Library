package tools.creators;

import entity.Book;
import entity.dbcontroller.BookFacade;
import entity.factory.FactoryFacade;

import java.util.List;
import java.util.Scanner;

public class BookManager {
    private Scanner scanner = new Scanner(System.in);
    private BookFacade bookFacade = FactoryFacade.getBookFacade();

    public Book createBook() {
        Book book = new Book();
        System.out.println("--- Создание книги ---");
        System.out.print("Введите имя книги: ");
        book.setName(scanner.nextLine());
        System.out.print("Введите автора книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("Введите год издания книги: ");
        book.setPublishedYear(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Введите ISBN книги: ");
        book.setIsbn(scanner.nextLine());
        System.out.println("Создана книга: "+book.getName());
        bookFacade.create(book);
        return book;
    }

    public void printListBooks() {
        List<Book> listBooks = bookFacade.findAll();
        for (int i = 0; i < listBooks.size(); i++) {
            if(listBooks.get(i) != null){
                System.out.println(listBooks.get(i).getId()+". " + listBooks.get(i).toString());
            }
        }
    }
}
