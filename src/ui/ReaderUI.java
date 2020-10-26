package ui;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.List;
import java.util.Scanner;
import security.SecureManager;
import tools.managers.BookManager;
import tools.managers.LibraryManager;
import tools.managers.ReaderManager;
import tools.saver.BookSaver;
import tools.saver.HistorySaver;
import tools.saver.ReaderSaver;
import tools.saver.UserSaver;

public class ReaderUI {
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    private LibraryManager libraryManager = new LibraryManager();
    private BookSaver bookSaver = new BookSaver();
    private ReaderSaver readerSaver = new ReaderSaver();
    private HistorySaver historySaver = new HistorySaver();
    private SecureManager secureManager = new SecureManager();
    private UserSaver userSaver = new UserSaver();

    public void getReaderUI(List<Reader> listReaders, List<User> listUsers, List<Book> listBooks, List<History> listHistories){
        boolean repeat = true;
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Список книг");
            System.out.println("2. Выдать книгу читателю");
            System.out.println("3. Вернуть книгу в библиотеку");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Список книг ---");
                    bookManager.printListBooks(listBooks);
                    break;
                case "2":
                    System.out.println("--- Выдать книгу читателю ---");
                    History history = libraryManager.takeOnBook(listBooks, listReaders);
                    libraryManager.addHistoryToArray(history,listHistories);
                    historySaver.saveHistories(listHistories);
                    break;
                case "3":
                    System.out.println("--- Вернуть книгу в библиотеку ---");
                    libraryManager = new LibraryManager();
                    libraryManager.returnBook(listHistories);
                    historySaver = new HistorySaver();
                    historySaver.saveHistories(listHistories);
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}