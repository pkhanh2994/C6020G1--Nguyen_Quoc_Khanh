package CaseStudy.models;

public abstract class Services  {
    public String id;
    public String servicesType;
    public int rentCost;
    public int guestAmount;
    public String rentType;
    public double area;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Services(String id, String servicesType, int rentCost, int guestAmount, String rentType,double area) {
        this.id = id;
        this.servicesType = servicesType;
        this.rentCost = rentCost;
        this.guestAmount = guestAmount;
        this.rentType = rentType;
        this.area=area;
    }

    public Services() {
    }

    public abstract void showInfor();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServicesType() {
        return servicesType;
    }

    public void setServicesType(String servicesType) {
        this.servicesType = servicesType;
    }

    public int getRentCost(int rentCost) {
        return this.rentCost;
    }

    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }

    public int getGuestAmount() {
        return guestAmount;
    }

    public void setGuestAmount(int guestAmount) {
        this.guestAmount = guestAmount;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return    id +
                "," + servicesType +
                "," + rentCost +
                "," + guestAmount +
                "," + rentType
                +","+area;
    }
}
