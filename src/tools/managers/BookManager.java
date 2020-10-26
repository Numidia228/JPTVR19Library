package tools.managers;

import entity.Book;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    private Scanner scanner = new Scanner(System.in);

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
        System.out.println("Создана книга: "+book.getName());
        return book;
    }

    public void addBookToArray(Book book, List<Book> listBooks) {
        listBooks.add(book);
    }

    public void printListBooks(List<Book> listBooks) {
        for (int i = 0; i < listBooks.size(); i++) {
            if(listBooks.get(i) != null){
                System.out.println(i+1+". " + listBooks.get(i).toString());
            }
        }
    }

}