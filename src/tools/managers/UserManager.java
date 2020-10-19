package tools.managers;

import entity.User;
import java.util.Scanner;

public class UserManager {

    public User createUser() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("--- Регистрация пользователя ---");
        System.out.print("Логин: ");
        user.setLogin(scanner.nextLine());
        System.out.print("Пароль: ");
        user.setPassword(scanner.nextLine());
        System.out.print("Роль: ");
        user.setRole(scanner.nextLine());
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