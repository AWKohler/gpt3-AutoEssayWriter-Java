package me.aronne.app;

import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.*;

public class main {

    public static void main(String[] args) {

        LafManager.install(new OneDarkTheme());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                LoginFrame loginFrame = new LoginFrame();

                loginFrame.setLocationRelativeTo(null);

                loginFrame.setVisible(true);
            }
        });
    }
}
