package com.company;

import entity.Book;
import entity.Reader;

import java.util.Scanner;

class App {
    public void run() {
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
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
                    Book book = new Book("Voina i mir", "L.Tolstoy", 2010, "123-1234");
                    System.out.println("Название книги: " + book.getName());
                    System.out.println(book.toString());


                    System.out.println("--- Конец программы ---");
                    repeat = false;
                    break;

                case "2":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 2: Список книг");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    System.out.println("--- Конец программы ---");
                    repeat = false;
                    break;

                case "3":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 3: Зарегистрировать читателя");
                    System.out.println("-----------------------------------");
                    System.out.println();
                    Reader reader = new Reader("Kirill", "Goritski", "55555555");
                    System.out.printf("Имя читателя: %s%n", reader.toString());

                    System.out.println("--- Конец программы ---");
                    repeat = false;
                    break;

                case "4":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 4: Список читателей");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    System.out.println("--- Конец программы ---");
                    repeat = false;
                    break;

                case "5":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 5: Выдать книгу читателю");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    System.out.println("--- Конец программы ---");
                    repeat = false;
                    break;

                case "6":
                    System.out.println();
                    System.out.println("-----------------------------------");
                    System.out.println("Выбрана задача 6: Вернуть книгу читателю");
                    System.out.println("-----------------------------------");
                    System.out.println();

                    System.out.println("--- Конец программы ---");
                    repeat = false;
                    break;

                default:
                    System.out.println("Такой задачи нет");
            }
        } while(repeat);
    }
}
