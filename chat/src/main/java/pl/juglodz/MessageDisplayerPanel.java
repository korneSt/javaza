package pl.juglodz;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class MessageDisplayerPanel extends JPanel {

    private JList messegeList;
    private DefaultListModel listModel; 
    public MessageDisplayerPanel() {
        messegeList = new JList();
        addListModel();
        add(messegeList);
    }
    private void addListModel() {
        listModel = new DefaultListModel();
        
        messegeList.setModel(listModel);
    }
    public void addMessgage(String message) {
        listModel.addElement(message);
    }
    
}
