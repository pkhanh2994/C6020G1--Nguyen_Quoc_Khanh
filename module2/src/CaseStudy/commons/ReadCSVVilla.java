package CaseStudy.commons;

import CaseStudy.models.Services;
import CaseStudy.models.Villa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVVilla {
    public static List<Services> readCSV(String file) throws IOException {
        List<Services>listVilla=new ArrayList<>();
        Villa villa;
        FileReader fileReader=new FileReader(file);
        try (fileReader; BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                villa = new Villa(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), arr[4], Double.parseDouble(arr[5]),
                        arr[6], Double.parseDouble(arr[7]), arr[8], Integer.parseInt(arr[9]));
                listVilla.add(villa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listVilla;
    }
}
