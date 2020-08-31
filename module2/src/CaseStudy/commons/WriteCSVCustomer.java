package CaseStudy.commons;

import CaseStudy.models.Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVCustomer {

    public static void writeCSVCustomer(String file, Customer customer) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder = stringBuilder.append(customer.toString()).append("\n");
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
