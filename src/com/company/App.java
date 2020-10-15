package com.company;

import entity.Reader;
import entity.Book;
import entity.History;
import entity.User;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.managers.BookManager;
import tools.saver.BookSaver;
import tools.managers.HistoryManager;
import tools.saver.HistorySaver;
import tools.managers.ReaderManager;
import tools.saver.ReaderSaver;

class App {
    private Book[] books = new Book[100];
    private Reader[] readers = new Reader[100];
    private History[] histories = new History[100];
    private User[] users = new User[100];
    private ReaderManager readerManager = new ReaderManager();
    private BookManager bookManager = new BookManager();
    private HistoryManager historyManager = new HistoryManager();
    private user loginedUser;

    public App() {
        BookSaver bookSaver = new BookSaver();
        books = bookSaver.loadFile();
        ReaderSaver readerSaver = new ReaderSaver();
        readers = readerSaver.loadFile();
        HistorySaver historySaver = new HistorySaver();
        histories = historySaver.loadFile();
    }

    public void run() {
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        this.loginedUser = SecureManager.checkTask(users, readers);
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

                    History history = historyManager.takeOnBookToReader(books, readers);
                    historyManager.addBookToArray(history, histories);
                    historyManager.printListHistories(histories);
                    HistorySaver historySaver = new HistorySaver();
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

                    historyManager.returnBook(histories);
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

                    historyManager.printListHistories(histories);

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

