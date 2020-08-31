package CaseStudy.commons;

import CaseStudy.models.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVEmployee {
    public static List<Employee> readCSVEmployee() throws FileNotFoundException {
         List<Employee> list=new ArrayList<>();
        Employee employee;
        FileReader fileReader=new FileReader("C:\\C0620G1- Nguyen Quoc Khanh\\module2\\src\\CaseStudy\\data\\employee.csv");
        try(fileReader; BufferedReader bufferedReader=new BufferedReader(fileReader)) {
            String line;
            String[] arr = null;
            while ((line=bufferedReader.readLine())!=null){
                arr=line.split(",");
                employee=new Employee(arr[0],arr[1],Integer.parseInt(arr[2]),arr[3]);
                list.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
