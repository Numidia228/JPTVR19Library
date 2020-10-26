package com.company;

import tools.saver.HistorySaver;
import tools.saver.BookSaver;
import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import security.SecureManager;
import tools.saver.ReaderSaver;
import tools.saver.UserSaver;
import ui.ManagerUI;
import ui.ReaderUI;

public class App {
    private List<Book> listBooks = new ArrayList<>();
    private List<Reader> listReaders = new ArrayList<>();
    private List<History> listHistories = new ArrayList<>();
    private List<User> listUsers = new ArrayList<>();

    private BookSaver bookSaver = new BookSaver();
    private ReaderSaver readerSaver = new ReaderSaver();
    private HistorySaver historySaver = new HistorySaver();
    private UserSaver userSaver = new UserSaver();

    private SecureManager secureManager = new SecureManager();

    public static User loginedUser;

    public App() {
        listBooks = bookSaver.loadFile();
        listReaders = readerSaver.loadReaders();
        listHistories = Arrays.asList(historySaver.loadFile());
        listUsers = userSaver.loadFile();
    }

    public void run(){
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        this.loginedUser = secureManager.checkTask(listUsers,listReaders);
        if (SecureManager.role.MANAGER.toString().equals(this.loginedUser.getRole())){
            ManagerUI managerUI = new ManagerUI();
            managerUI.getManagerUI(listReaders, listUsers, listBooks, listHistories);
        } else if (SecureManager.role.READER.toString().equals(this.loginedUser.getRole())){
            ReaderUI readerUI = new ReaderUI();
            readerUI.getReaderUI(listReaders, listUsers, listBooks, listHistories);
        }
    }
}

