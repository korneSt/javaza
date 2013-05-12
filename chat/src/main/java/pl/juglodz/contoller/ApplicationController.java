package pl.juglodz.contoller;

import pl.juglodz.MessageSubmited;
import pl.juglodz.model.Model;

public class ApplicationController implements MessageSubmited{

    private Model model;
    
    @Override
    public void messege(String message) {
        model.addMessga(message);
    }

}
