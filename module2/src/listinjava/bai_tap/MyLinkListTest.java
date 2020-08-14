package listinjava.bai_tap;

public class MyLinkListTest {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1, "khánh0");
        Student student2 = new Student(1, "khánh1");
        Student student3 = new Student(1, "khánh2");
        Student student4 = new Student(1, "khánh3");
        Student student5 = new Student(1, "khánh4");
        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addFirst(student3);
        myLinkedList.addFirst(student4);
        myLinkedList.addFirst(student5);

        MyLinkedList<Student> cloneLinkedList = myLinkedList.clone();

//        for(int i=0;i<myLinkedList.size();i++){
//        Student student = (Student) myLinkedList.getLast();
//        System.out.println(student.getName());
        student1 = (Student) myLinkedList.getFirst();
        System.out.println(student1.getName());


//        }

    }

}
