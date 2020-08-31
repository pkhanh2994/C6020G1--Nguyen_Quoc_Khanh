package CaseStudy.models;

public class Employee {
    String id;
    String name;
    int ageEmployee;
    String address;

    public Employee() {
    }

    public Employee(String id, String name, int ageEmployee, String address) {
        this.id = id;
        this.name = name;
        this.ageEmployee = ageEmployee;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(int ageEmployee) {
        this.ageEmployee = ageEmployee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString(){
        return "name:"+name+",age: "+ageEmployee+",address: "+address;
    }
}
