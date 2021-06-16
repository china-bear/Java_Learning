package deserializationTest;

import java.io.IOException;
import java.io.Serializable;

public class DefaultSerial implements Serializable {

    private String name;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String digest = "rO0ABXNyACFkZXNlcmlhbGl6YXRpb25UZXN0LkRlZmF1bHRTZXJpYWy+zzCY4njGnAIAAUwABG5hbWV0ABJMamF2YS9sYW5nL1N0cmluZzt4cHA=";
        DefaultSerial instance = (DefaultSerial) DeserializationUtility.deSerializeObjectFromString(digest);

        System.out.println(instance);
    }
}