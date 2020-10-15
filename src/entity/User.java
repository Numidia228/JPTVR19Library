package entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String login;
    private String password;
    private String role;
    private Reader reader;

    public User() {
    }

    public User(String login, String password, String role, Reader reader) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.reader = reader;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String returnDate) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String book) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String reader) {
        this.role = role;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Date takeOnDate) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Логин = " + login
                + ", пароль = " + password
                + ", роль = " + role
                + ", читатель = " + reader;
    }
}
