package CaseStudy.commons;

import CaseStudy.models.Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {

    public static void writeCSV(String file, Services type) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder = stringBuilder.append(type.toString()).append("\n");
            bufferedWriter.write(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            if (stringBuilder != null) {
                bufferedWriter.close();
            }
        }
    }
}
