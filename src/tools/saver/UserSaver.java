package tools.saver;

import entity.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserSaver {

    public void saveUsers(List<User> listUsers) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("users");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listUsers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    public List<User> loadFile() {
        List<User>  listUsers = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("users");
            ois = new ObjectInputStream(fis);
            listUsers = (List<User>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ошибка: не найден класс");
        }
        return listUsers;
    }

}