package tools.managers;

import entity.Reader;
import java.util.List;
import java.util.Scanner;

public class ReaderManager {
    private Scanner scanner = new Scanner(System.in);
    public Reader createReader() {
        Reader reader = new Reader();
        System.out.println("--- Регистрация нового пользователя ---");
        System.out.print("Введите имя: ");
        reader.setName(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Введите телефон: ");
        reader.setPhone(scanner.nextLine());
        this.printReader(reader);
        return reader;
    }

    public void addReaderToArray(Reader reader, List<Reader> listReaders) {
        listReaders.add(reader);
    }

    public void printReader(Reader reader) {
        System.out.println("Имя читателя: "
                +reader.getName()
                +" "
                + reader.getLastname()
        );
    }

    public void printListReaders(List<Reader> listReaders) {
        for (int i = 0; i < listReaders.size(); i++) {
            if(listReaders.get(i) != null) {
                System.out.println(i+1+". " + listReaders.get(i).toString());
            }
        }
    }
}
