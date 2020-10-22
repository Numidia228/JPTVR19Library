package tools.managers;

import entity.Reader;
import entity.User;
import security.SecureManager;
import java.util.Scanner;

public class UserManager {

    public User createUser() {
        User user = new User();
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("--- Регистрация пользователя ---");
        System.out.print("Логин: ");
        user.setLogin(scanner.nextLine());
        System.out.print("Пароль: ");
        user.setPassword(scanner.nextLine());
        int numRole;
        do {
            System.out.println("Список ролей:");
            for (int i = 0; i < SecureManager.role.values().length; i++) {
                System.out.printf("%d. %s%n"
                        , i + 1
                        , SecureManager.role.values()[i]);
            }
            System.out.print("Роль: ");
            String numRoleStr = scanner.nextLine();
            try {
                numRole = Integer.parseInt(numRoleStr);
                break;
            } catch (Exception e){
                System.out.println("Ошибка ввода, необходимо вводить цифры!");
            }
        }while(true);
        user.setRole(SecureManager.role.values()[numRole - 1].toString());
        user.setReader(reader);
        return user;
    }

    public void addUserToArray(User user, User[] users) {
        for (int i = 0; i < users.length; i++) {
            if(users[i] == null){
                users[i]=user;
                break;
            }
        }
    }
    public void printListUsers(User[] readers) {
        for (int i = 0; i < readers.length; i++) {
            if(readers[i]!= null){
                System.out.printf("%3d. Добавлен пользователь: %s %s%n     Пароль: %s%n     Роль: %s%n"
                        ,i+1
                        ,readers[i].getLogin()
                        ,readers[i].getPassword()
                        ,readers[i].getRole()
                );
                System.out.println("--------------------------------");
            }
        }
    }
}