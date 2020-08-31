package CaseStudy.commons;

import CaseStudy.models.House;
import CaseStudy.models.Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVHouse {
    public static List<Services>readCSVHouse(String file) throws FileNotFoundException {
        List<Services>listHouse=new ArrayList<>();
        House house;
        FileReader fileReader=new FileReader(file);
        try (fileReader; BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                house = new House(arr[0],arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),arr[4],Double.parseDouble(arr[5]),arr[6],
                       arr[7],Integer.parseInt(arr[8]));
                listHouse.add(house);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listHouse;

    }
}
