package CaseStudy.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadObject {
    public static ArrayList readObject(String file){
        try(FileInputStream fileInputStream=new FileInputStream(file);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream)) {
            return(ArrayList) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
