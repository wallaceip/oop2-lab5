import java.io.*;

public class Event implements Serializable {
    int eventNumber;
    String location;

    public Event() {
    }

    public Event(int eventNumber, String location) {
        this.eventNumber = eventNumber;
        this.location = location;
    }

    @Override
    public String toString() {
        return
                "eventNumber = " + eventNumber +
                "\nlocation = " + location;
    }
}
