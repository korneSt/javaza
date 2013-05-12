
package pl.juglodz.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<ModelListener> modelListeners = new ArrayList<ModelListener>();
    
    
    public void addListener(ModelListener listener){
        modelListeners.add(listener);
    }
    
    private List<String> messages;
    
    //blok inicjalizacyjny
    {
        messages = new ArrayList<String>();
    }
    
    public void addMessge(String message) {
        messages.add(message);
        powiadomOZmianach();
    }
    public void reset() {
        messages.clear();
        powiadomOZmianach();
    }
    
    private void powiadomOZmianach() {
        for (ModelListener lisner : modelListeners) {
            lisner.modelChanged(this);
        }
    }

    public List<String> getMessages() {
        return messages;
    }
    
}
