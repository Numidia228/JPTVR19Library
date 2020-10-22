package com.company;

import tools.saver.HistorySaver;
import tools.managers.LibraryManager;
import tools.saver.BookSaver;
import tools.managers.ReaderManager;
import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.Scanner;
import security.SecureManager;
import tools.managers.BookManager;
import tools.saver.ReaderSaver;
import tools.saver.UserSaver;

class App {
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[10];
    private History[] histories = new History[10];
    private User[] users = new User[10];
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    private LibraryManager libraryManager = new LibraryManager();
    private BookSaver bookSaver = new BookSaver();
    private ReaderSaver readerSaver = new ReaderSaver();
    private HistorySaver historySaver = new HistorySaver();
    private SecureManager secureManager = new SecureManager();
    private UserSaver userSaver = new UserSaver();

    private static User loginedUser;

    public App() {
        books = bookSaver.loadFile();
        readers = readerSaver.loadFile();
        histories = historySaver.loadFile();
        users = userSaver.loadFile();
    }

    public void run() {
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        System.out.println();
        System.out.println("==============================================");
        this.loginedUser = secureManager.checkTask(users, readers);
        System.out.println();
        do {
            System.out.println("-----------------------------------");
            System.out.println("Задачи: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Список книг");
            System.out.println("3. Зарегистрировать читателя");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Вернуть книгу читателю");
            System.out.println("7. Список читаемых книг");
            System.out.println();
            System.out.print("Что вы выберите?: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    repeat = false;
                    break;

                case "1":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 1: Добавить новую книгу");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    Book book = bookManager.createBook();
                    bookManager.addBookToArray(book, books);
                    bookManager.printListBooks(books);
                    BookSaver bookSaver = new BookSaver();
                    bookSaver.saveBooks(books);

                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    break;

                case "2":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 2: Список книг");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    bookManager.printListBooks(books);

                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    break;

                case "3":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 3: Зарегистрировать читателя");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    Reader reader = readerManager.createReader();
                    readerManager.addReaderToArray(reader, readers);
                    readerManager.printListReaders(readers);
                    ReaderSaver readerSaver = new ReaderSaver();
                    readerSaver.saveReaders(readers);

                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    break;

                case "4":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 4: Список читателей");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    readerManager.printListReaders(readers);

                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    break;

                case "5":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 5: Выдать книгу читателю");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    System.out.println("--- Выдать книгу читателю ---");
                    History history = libraryManager.takeOnBook(books, readers);
                    libraryManager.addHistoryToArray(history,histories);
                    libraryManager.printListReadBooks(histories);
                    historySaver.saveHistories(histories);

                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    break;

                case "6":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 6: Вернуть книгу библиотеке");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    libraryManager = new LibraryManager();
                    libraryManager.returnBook(histories);
                    historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);

                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    break;

                case "7":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 7: Список читаемых книг");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    libraryManager.printListReadBooks(histories);

                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    System.out.println();
                    break;
                default:
                    System.out.println("Такой задачи нет");
            }
        }
        while (repeat);
    }
}

