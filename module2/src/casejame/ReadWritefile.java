package casejame;

import java.io.*;
import java.util.LinkedList;

public class ReadWritefile {
    public static void writeFile(LinkedList linkedList, String file) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try (fileOutputStream; ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(linkedList);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static LinkedList readFile(String file) throws FileNotFoundException {
        LinkedList linkedList=new LinkedList();
        FileInputStream fileInputStream=new FileInputStream(file);
        try (fileInputStream;ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream)){
            linkedList= (LinkedList)objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return linkedList;
    }
}
