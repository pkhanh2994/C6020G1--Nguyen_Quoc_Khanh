package CaseStudy.commons;

import CaseStudy.models.Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVCustomer {
    public static final String COMMA=",";
    public static void writeCSVCustomer(String file, Customer customer) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            stringBuilder.append(customer.getName()).append(COMMA).append(customer.getBirthday()).append(COMMA).
                    append(customer.getGender()).append(COMMA).append(customer.getIdentifyCard()).append(COMMA).
                    append(customer.getPhoneNumber()).append(COMMA).append(customer.getEmail()).append(COMMA).
                    append(customer.getTypeGuest()).append(COMMA).append(customer.getAddress()).append("\n");
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
