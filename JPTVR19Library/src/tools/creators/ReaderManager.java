package tools.creators;

import entity.Reader;
import entity.dbcontroller.ReaderFacade;
import entity.factory.FactoryFacade;

import java.util.List;
import java.util.Scanner;

public class ReaderManager {
    private Scanner scanner = new Scanner(System.in);
    private ReaderFacade readerFacade = FactoryFacade.getReaderFacade();

    public Reader createReader() {
        Reader reader = new Reader();
        System.out.println("--- Регистрация нового пользователя ---");
        System.out.print("Введите имя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Введите телефон: ");
        reader.setPhone(scanner.nextLine());
        this.printReader(reader);
        return reader;
    }


    public void printReader(Reader reader) {
        System.out.println("Имя читателя: "
                +reader.getFirstname()
                +" "
                + reader.getLastname()
        );
    }

    public void printListReaders() {
        List<Reader> listReaders = readerFacade.findAll();
        for (int i = 0; i < listReaders.size(); i++) {
            if(listReaders.get(i) != null){
                System.out.println(listReaders.get(i).getId()+". " + listReaders.get(i).toString());
            }
        }
    }

}
