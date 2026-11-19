import java.io.*;

public class SerializationRunner {

    private static final String EVENT_SERIALIZE_FILE = "res/event.ser";

    public static void main(String[] args) {
        SerializationRunner runner = new SerializationRunner();

        Event event1 = new Event(1,"Calgary");
        System.out.println("Event Object before serialization");
        System.out.println(event1);

        try {
            runner.SerializeEvent(event1, EVENT_SERIALIZE_FILE);
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }


        Event event2 = null;
        try {
            event2 = runner.DeserializeEvent(EVENT_SERIALIZE_FILE);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }

        System.out.println("\nChild Object after deserialization");
        System.out.println(event2);

    }

    private void SerializeEvent(Event eventObj, String fileName) throws IOException {
            File file = new File(fileName);
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))) {
            objOut.writeObject(eventObj);
        }
    }

    private Event DeserializeEvent(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        Event eventObj = null;
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))) {
            eventObj = (Event) objIn.readObject();
        }
        return eventObj;
    }
}
