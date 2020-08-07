package OOP.bai_tap;

public class Fan {
    private final int slow = 1;
    private final int medium = 2;
    private final int fast = 3;
    private int speed = slow;
    private boolean on;
    private double radius = 5;
    private String color = "blue";

    public Fan() {

    }

    public int getSlow() {
        return slow;
    }

    public int getMedium() {
        return medium;
    }

    public int getFast() {
        return fast;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getOn() {
        return this.on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        if (on) {
            System.out.println("Tốc độ là: " + this.speed + "; màu sắc là: " + this.color + "; bán kính của lồng quạt là: " + this.radius + ": Fan is on");
        } else
            System.out.println("\"Màu sắc là: "+ this.color + "; bán kính của lồng quạt là: "+ this.radius + ": Fan is off");
    }


    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        //Quạt thứ nhất
        System.out.println("Trạng thái quạt thứ nhất");
        fan1.setSpeed(fan1.getFast());
        fan1.setColor("yellow");
        fan1.setRadius(10);
        fan1.setOn(true);
        fan1.display();
        //Quạt thứ 2
        System.out.println("Trạng thái quạt thứ hai");
        fan2.setSpeed(fan2.getMedium());
        fan2.setColor("blue");
        fan2.setRadius(fan2.getRadius());
        fan2.setOn(false);
        fan2.display();

    }
}
