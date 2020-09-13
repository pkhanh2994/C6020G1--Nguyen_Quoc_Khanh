package CaseStudy.models;

import java.io.Serializable;

public class House extends Services implements Serializable {
    private String standardRoom;
    private String otherExclusives;
    private int floors;
    public House(String id, String servicesType, int rentCost, int guestAmount, String rentType, double area, String standardRoom, String otherExclusives, int floors) {
        super(id, servicesType, rentCost, guestAmount, rentType, area);
        this.standardRoom = standardRoom;
        this.otherExclusives = otherExclusives;
        this.floors = floors;
    }

    public House() {
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
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
    public void showInfor() {
        System.out.println(
                "ID: "+this.id+"\n"+"Services type: "+this.servicesType+"\n"+
                        "Rent cost: "+this.rentCost+"\n"+"Guest amount: "+this.guestAmount+"\n"+"Rent type: "+this.rentType+"\n"+
                        "Area: "+this.area+"\n"+"Standard room: "+this.standardRoom+"\n"+"Pool area: "+"\n"+
                        "Other exclusives: "+this.otherExclusives+"\n"+"Floors: "+this.floors);
    }

    @Override
    public String toString() {
        return super.toString()+
                " ,"+standardRoom+
                ","+otherExclusives + ","+floors ;

    }

}
