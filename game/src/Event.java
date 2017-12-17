
import java.util.*;

/**
 * 
 */
public abstract class Event extends MinizoneEvent {

    /**
     * Default constructor
     */
    public Event() {
    }

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    protected String message;


    /**
     * @param id 
     * @param message
     */
    public void Event(int id, String message) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void setId(int id) {
        // TODO implement here
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getMessage() {
        // TODO implement here
        return "";
    }

    /**
     * 
     */
    public void run() {
        // TODO implement here
    }

}