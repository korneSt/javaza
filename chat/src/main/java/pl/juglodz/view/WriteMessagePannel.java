package pl.juglodz.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.juglodz.MessageDisplayerPanel;
import pl.juglodz.contoller.ApplicationController;
import pl.juglodz.model.Model;
import pl.juglodz.model.ModelListener;


public class WriteMessagePannel extends JPanel implements ActionListener, ModelListener {
    private static final int TEXTFIELD_SIZE = 40;
    private static final String SEND_BUTTON_LABEL = "Send";
    JTextField messageTextField;
    JButton okButton;
    private ApplicationController controller;
    
    public WriteMessagePannel(ApplicationController controller) {
        this.controller = controller;
        messageTextField = new JTextField();
        messageTextField.setColumns(TEXTFIELD_SIZE);
        okButton = new JButton(SEND_BUTTON_LABEL);
        okButton.addActionListener(this);
        add(messageTextField);
        add(okButton);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String message = messageTextField.getText();
        messageTextField.setText("");
        System.out.println(message);
        controller.messege(message);
    }


    @Override
    public void modelChanged(Model model) {
    }

}
