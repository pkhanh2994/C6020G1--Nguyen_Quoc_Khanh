package CaseStudy.commons;

import java.io.*;
import java.util.ArrayList;

public class WriteObject {
    public static void writeObject(ArrayList arrayList, String file) throws FileNotFoundException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
            outputStream.writeObject(arrayList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
