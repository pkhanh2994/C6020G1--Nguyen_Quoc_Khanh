package CaseStudy.models;

import java.util.Comparator;

public class Customer implements Comparator<Customer> {
    private  String name;
    private  String birthday;
    private  String gender;
    private  String identifyCard;
    private  String phoneNumber;
    private  String email;
    private  String typeGuest;
    private  String address;
    Services  services;

    public Customer() {
    }

    public Customer(String name, String birthday, String gender, String identifyCard, String phoneNumber, String email, String typeGuest, String address) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.identifyCard = identifyCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentifyCard() {
        return identifyCard;
    }

    public void setIdentifyCard(String identifyCard) {
        this.identifyCard = identifyCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeGuest() {
        return typeGuest;
    }

    public void setTypeGuest(String typeGuest) {
        this.typeGuest = typeGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return this.services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
    public  String toString(){
       if(services==null) {
           return "Name: " + name + ",Birthday: " + birthday + ",Gender: " + gender + ",Identify card number: " + identifyCard +
                   ",Phone number: " + phoneNumber + ",Email: " + email + ",TypeGuest: " + typeGuest + ",address: " + address;
       }else return "Name: " + name + ",Birthday: " + birthday + ",Gender: " + gender + ",Identify card number: " + identifyCard +
               ",Phone number: " + phoneNumber + ",Email: " + email + ",TypeGuest: " + typeGuest + ",address: " + address+ ",services: "+services;
    }
    public void showInfor(){
        System.out.println("Name: "+name+",Birthday: "+birthday+",Gender: "+gender+",Identify card number: "+identifyCard+
                ",Phone number: "+phoneNumber+",Email: "+email+",TypeGuest: "+typeGuest+",Address: "+address);

    }


    @Override
    public int compare(Customer o1, Customer o2) {
       int result=o1.getName().compareTo(o2.getName());
       int b;
       if(result!=0){
           return result;
       }else {
           b = Integer.parseInt(o1.getBirthday().substring(6))-Integer.parseInt(o2.getBirthday().substring(6));
           return Integer.compare(0, b);
       }
    }
}
