package tools;

import entity.Reader;
import java.util.Scanner;

public class CreatorReader {
    Scanner scanner = new Scanner(System.in);

    public Reader getReader() {
        Reader reader = new Reader();
        System.out.println("--- Создание книги ---");
        System.out.print("Введите имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Введите номер телефона читателя: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }
}

