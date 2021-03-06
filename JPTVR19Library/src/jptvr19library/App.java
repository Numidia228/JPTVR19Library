package jptvr19library;

import entity.User;
import security.SecureManager;
import ui.ManagerUI;
import ui.ReaderUI;

public class App {
    private SecureManager secureManager = new SecureManager();
    
    public static User loginedUser;
    
    public App() {
    }
    
    public void run(){
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        this.loginedUser = secureManager.checkTask();
        if (SecureManager.role.MANAGER.toString().equals(this.loginedUser.getRole())){
            ManagerUI managerUI = new ManagerUI();
            managerUI.getManagerUI();
        } else if (SecureManager.role.READER.toString().equals(this.loginedUser.getRole())){
            ReaderUI readerUI = new ReaderUI();
            readerUI.getReaderUI();
        }
    }
}
