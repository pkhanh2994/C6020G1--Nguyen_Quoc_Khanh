package CaseStudy.commons;

import CaseStudy.models.Customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomerCSV {
    public static List<Customer> readCSVCustomer() throws FileNotFoundException {
        List<Customer> list = new ArrayList<>();
        Customer customer = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("C:\\C0620G1- Nguyen Quoc Khanh\\module2\\src\\CaseStudy\\data\\customer.csv");
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                customer = new Customer(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                list.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
