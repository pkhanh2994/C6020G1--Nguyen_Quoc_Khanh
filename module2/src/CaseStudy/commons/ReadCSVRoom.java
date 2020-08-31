package CaseStudy.commons;

import CaseStudy.models.Room;
import CaseStudy.models.Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVRoom {
    public static List<Services> readCSVRoom(String file) throws FileNotFoundException {
        List<Services>listRoom=new ArrayList<>();
      Room room;
        FileReader fileReader=new FileReader(file);
        try (fileReader; BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                room = new Room(arr[0],arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),arr[4],
                        Double.parseDouble(arr[5]),arr[6]);
                listRoom.add(room);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listRoom;
    }
}
