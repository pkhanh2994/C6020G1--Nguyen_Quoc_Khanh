package io_textfile.bai_tap;

import java.io.*;

public class CSVReader {
    public static void main(String[] args) throws IOException {
        File file = new File("country.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        try {

            while ((line = bufferedReader.readLine()) != null) {
                String[] country = line.split(",");
                System.out.println("country name: " + country[5]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                    fileReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
