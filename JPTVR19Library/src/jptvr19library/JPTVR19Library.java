package jptvr19library;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import entity.factory.ConnectSingleton;

public class JPTVR19Library {

    public static void main(String[] args) {
        App app = new App();
        try {
            app.run();
        } finally {
            ConnectSingleton connectSingleton = ConnectSingleton.getInstance();
            if (connectSingleton.getEntityManager() != null) {
                connectSingleton.getEntityManager().close();
            }
            if (connectSingleton.getEntityManagerFactory() != null) {
                connectSingleton.getEntityManagerFactory().close();
            }
        }
    }
}
