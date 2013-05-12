package pl.juglodz.contoller;

import pl.juglodz.MessageDisplayerPanel;
import pl.juglodz.MessageSubmited;
import pl.juglodz.model.Model;
import pl.juglodz.model.ModelListener;

public class ApplicationController implements MessageSubmited{

    private Model model;
    
    public ApplicationController() {
        model = new Model();
    }
    
    @Override
    public void messege(String message) {
        model.addMessge(message);
    }

    public void registerModelListener(ModelListener ml) {
        model.addListener(ml);
    }

}
