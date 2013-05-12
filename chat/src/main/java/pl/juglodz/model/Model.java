
package pl.juglodz.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public List<String> messages;
    
    //blok inicjalizacyjny
    {
        messages = new ArrayList<String>();
    }
    
    public void addMessga(String message) {
        messages.add(message);
    }
    
    public void reser() {
        messages.clear();
    }

}
