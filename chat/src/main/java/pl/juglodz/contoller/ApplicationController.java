package pl.juglodz.contoller;

import pl.juglodz.MessageDisplayerPanel;
import pl.juglodz.MessageSubmited;
import pl.juglodz.model.Model;
import pl.juglodz.model.ModelListener;

public class ApplicationController implements MessageSubmited{

    private Model model;
    private CommulicatorController communicator;
    
    public ApplicationController() {
        model = new Model();
        communicator = new CommulicatorController(model);
    }

    public void registerModelListener(ModelListener ml) {
        model.addListener(ml);
    }
    
    @Override
    public void messege(String message) {
        communicator.send(message);
    }


}
