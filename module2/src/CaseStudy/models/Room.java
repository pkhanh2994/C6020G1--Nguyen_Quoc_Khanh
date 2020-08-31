package CaseStudy.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Room extends Services implements Serializable {
    private String freeServiceIncluded;
    public static ArrayList<Room>listRoom=new ArrayList<>();

    public Room(String id, String servicesType, int rentCost, int guestAmount, String rentType, double area, String freeServiceIncluded) {
        super(id, servicesType, rentCost, guestAmount, rentType, area);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room() {
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public void showInfor() {
        System.out.println(
                "ID: "+this.id+"\n"+"Services type: "+this.servicesType+"\n"+
                        "Rent cost: "+this.rentCost+"\n"+"Guest amount: "+this.guestAmount+"\n"+"Rent type: "+this.rentType+"\n"+
                        "Area: "+this.area+"\n"+"Free service included"+this.freeServiceIncluded);
    }

    @Override
    public String toString() {
        return super.toString()+","+freeServiceIncluded;
    }

}
