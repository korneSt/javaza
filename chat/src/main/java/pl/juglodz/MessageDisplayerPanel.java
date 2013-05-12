package pl.juglodz;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import pl.juglodz.model.Model;
import pl.juglodz.model.ModelListener;

public class MessageDisplayerPanel extends JPanel implements ModelListener{

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
    
    @Override
    public void modelChanged(Model model) {
        List<String> modelApplikacji = model.getMessages(); 
        listModel.clear();
        for (String wiadomosc : modelApplikacji) {
            listModel.addElement(wiadomosc);
        }
    }
    
}
