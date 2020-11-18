package jptvr19library;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import security.SecureManager;
import tools.savers.SaveInterface;
import tools.savers.SaverToBase;
import tools.savers.SaverToFile;
import ui.ManagerUI;
import ui.ReaderUI;

public class App {

    private SecureManager secureManager = new SecureManager();
    private SaveInterface saver = new SaverToBase();

    public static User loginedUser;

    public App() {

    }

    public void run(){
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        this.loginedUser = secureManager.checkTask();
        if(SecureManager.role.MANAGER.toString().equals(this.loginedUser.getRole())){
            ManagerUI managerUI = new ManagerUI();
            managerUI.getManagerUI();
        }else if(SecureManager.role.READER.toString().equals(this.loginedUser.getRole())){
            ReaderUI readerUI = new ReaderUI();
            readerUI.getReaderUI();
        }
    }
}