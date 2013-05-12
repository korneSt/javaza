package pl.juglodz;

import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {

    private static final String APPLICATION_NAME = "Chat v 1.01";
    private static final int WINDOW_SIZE = 600;

    public ApplicationWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        setTitle(APPLICATION_NAME);
    }

    public void showApp() {
        setVisible(true);
    }
    
}

