package CaseStudy.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Villa extends Services implements Serializable {
    private String standardRoom;
    private double poolArea;
    private String otherExclusives;
    private int floors;
    public static ArrayList<Villa>listVilla=new ArrayList<>();

    public Villa(String id, String servicesType, int rentCost, int guestAmount, String rentType, double area, String standardRoom, double poolArea, String otherExclusives, int floors) {
        super(id, servicesType, rentCost, guestAmount, rentType, area);
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.otherExclusives = otherExclusives;
        this.floors = floors;
    }

    public Villa() {
    }

    @Override
    public void showInfor() {
        System.out.println(
                "ID: "+this.id+"\n"+"Services type: "+this.servicesType+"\n"+
                "Rent cost: "+this.rentCost+"\n"+"Guest amount: "+this.guestAmount+"\n"+"Rent type: "+this.rentType+"\n"+
                "Area: "+this.area+"\n"+"Standard room: "+this.standardRoom+"\n"+"Pool area: "+this.poolArea+"\n"+
                "Other exclusives: "+this.otherExclusives+"\n"+"Floors: "+this.floors);
    }


    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }


    public String getOtherExclusives() {
        return otherExclusives;
    }

    public void setOtherExclusives(String otherExclusives) {
        this.otherExclusives = otherExclusives;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString(){
        return super.toString()+
                " , "+standardRoom+" ,"+ poolArea+
                " ,"+otherExclusives+ ","+floors ;

    }

}
