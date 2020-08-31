package CaseStudy.models;

import CaseStudy.commons.ReadCSVEmployee;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Stack;

public class Cabinet {
    public static Stack<Employee>employeesStack=new Stack<>();
    public  Cabinet() throws FileNotFoundException {
        List<Employee>employees= ReadCSVEmployee.readCSVEmployee();
        for(Employee employee:employees){
            employeesStack.push(employee);
        }
    }
}
