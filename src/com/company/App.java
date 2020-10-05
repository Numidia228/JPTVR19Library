package com.company;

import entity.Book;
import entity.Reader;
import java.util.Scanner;
import tools.CreatorBook;
import tools.CreatorReader;

class App {
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[10];
    public void run() {
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        System.out.println();
        do {
            System.out.p      \rintln("-----------------------------------");
            System.out.println("Задачи: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Список книг");
            System.out.println("3. Зарегистрировать читателя");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Вернуть книгу читателю");
            System.out.println();
            System.out.print("Что вы выберите?: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("--- Конец программы ---");
                    repeat = false;
                    break;

                case "1":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 1: Добавить новую книгу");
                    System.out.println("-----------------------------------");
                    System.out.println();
                    CreatorBook creatorBook = new CreatorBook();
                    Book book = creatorBook.getBook();
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            books[i] = book;
                            break;
                        }
                    }
                    System.out.println();
                    System.out.println("Создана книга: ");
                    System.out.println("Название книги: " + book.getName());
                    System.out.println("Автор книги: " + book.getAuthor());
                    System.out.println("Год издания книги: " + book.getPublishedYear());
                    System.out.println("ISBN книги: " + book.getIsbn());
                    break;

                case "2":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 2: Список книг");
                    System.out.println("-----------------------------------");
                    System.out.println();
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] != null){
                            System.out.println(i+1+". " + books[i].toString());
                        }
                    }
                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    break;

                case "3":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 3: Зарегистрировать читателя");
                    System.out.println("-----------------------------------");
                    System.out.println();
                    CreatorReader creatorReader = new CreatorReader();
                    Reader reader = creatorReader.getReader();
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] == null){
                            readers[i] = reader;
                            break;
                        }
                    }
                    System.out.println();
                    System.out.println("Создана книга: ");
                    System.out.println("Имя читателя: " + reader.getFirstname());
                    System.out.println("Фамилия читателя: " + reader.getLastname());
                    System.out.println("Номер телефона читателя: " + reader.getPhone());
                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    break;

                case "4":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 4: Список читателей");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] != null){
                            System.out.println(i+1+". " + readers[i]);
                        }
                    }
                    System.out.println("--- Конец программы ---");
                    break;

                case "5":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 5: Выдать книгу читателю");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    System.out.println("--- Конец программы ---");
                    break;

                case "6":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 6: Вернуть книгу читателю");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    System.out.println("--- Конец программы ---");
                    break;

                default:
                    System.out.println("Такой задачи нет");
            }
        } while(repeat);
    }
}
