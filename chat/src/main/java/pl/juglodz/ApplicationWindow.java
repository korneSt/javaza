package pl.juglodz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pl.juglodz.contoller.ApplicationController;
import pl.juglodz.view.WriteMessagePannel;

public class ApplicationWindow extends JFrame  {

    private static final String APPLICATION_NAME = "Chat v 1.01";
    private static final int WINDOW_SIZE = 600;
    private MessageDisplayerPanel messageDisplayPanel;
    private WriteMessagePannel writeMessagePannel;
    private ApplicationController appController;

    public ApplicationWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        setTitle(APPLICATION_NAME);
        appController = new ApplicationController();
        getContentPane().setLayout(new BorderLayout());
        
        messageDisplayPanel = new MessageDisplayerPanel();
        writeMessagePannel = new WriteMessagePannel(appController);

        appController.registerModelListener(messageDisplayPanel);
        appController.registerModelListener(writeMessagePannel);
        
        add(messageDisplayPanel, BorderLayout.CENTER);
        add(writeMessagePannel, BorderLayout.SOUTH);
    }

    public void showApp() {
        setVisible(true);
    }

   
    
}

