package ui;

import tools.saver.ReaderSaver;
import tools.managers.ReaderManager;
import entity.Reader;
import entity.Book;
import entity.History;
import java.util.Scanner;
import tools.managers.BookManager;
import tools.managers.LibraryManager;
import tools.saver.BookSaver;
import tools.saver.HistorySaver;

public class ReaderUI {
    private Scanner scanner = new Scanner(System.in);
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    private LibraryManager libraryManager = new LibraryManager();
    private BookSaver booksStorageManager = new BookSaver();
    private ReaderSaver readersStorageManager = new ReaderSaver();
    private HistorySaver historiesStorageManager = new HistorySaver();
    public void getReaderUI(Book[] books, Reader[] readers, History[] histories) {
        boolean repeat = true;
        do{
            System.out.println("=============================");
            System.out.println("Задачи:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Список книг");
            System.out.println("2. Взять книгу");
            System.out.println("3. Вернуть книгу");
            System.out.print("Выберите задачу: ");
            String task = scanner.nextLine();
            System.out.println("=============================");
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Список книг ---");
                    bookManager.printListBooks(books);
                    break;
                case "2":
                    System.out.println("--- Взять книгу ---");
                    History history = libraryManager.takeOnBook(books, readers);
                    libraryManager.addHistoryToArray(history, histories);
                    libraryManager.printListReadBooks(histories);
                    booksStorageManager.saveBooks(books);
                    break;
                case "3":
                    System.out.println("--- Вернуть книгу ---");
                    libraryManager.returnBook(histories);
                    historiesStorageManager.saveHistories(histories);
                    break;
                default:
                    System.out.println("Нет такой задачи");;
            }
        }while(repeat);
    }

}