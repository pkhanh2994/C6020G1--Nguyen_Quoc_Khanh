package javacolectionframework.thuc_hanh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AgeComparator implements Comparator<Student1> {
    @Override
    public int compare(Student1 o1, Student1 o2) {
        if(o1.getAge() > o2.getAge()){
            return 1;
        }else if(o1.getAge() == o2.getAge()){
            return 0;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
            Student1 student = new Student1("Kien", 30, "HT");
            Student1 student1 = new Student1("Nam", 26, "HN");
            Student1 student2 = new Student1("Anh", 38, "HT" );
            Student1 student3 = new Student1("Tung", 38, "HT" );

            List<Student1> lists = new ArrayList<Student1>();
            lists.add(student);
            lists.add(student1);
            lists.add(student2);
            lists.add(student3);
            Collections.sort(lists);
            for(Student1 st : lists){
                System.out.println(st.toString());
            }

            AgeComparator ageComparator = new AgeComparator();
            Collections.sort(lists,ageComparator);
            System.out.println("So sanh theo tuoi:");
            for(Student1 st : lists){
                System.out.println(st.toString());
            }
    }
}
