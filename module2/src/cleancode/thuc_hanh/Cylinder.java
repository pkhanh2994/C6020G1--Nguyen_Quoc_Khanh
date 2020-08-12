package cleancode.thuc_hanh;

public class Cylinder {
    int height;
    int radius;
    public static double getVolume(int height,int radius){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }
    private static double getBaseArea(int radius){
        return  Math.PI * radius * radius;
    }
    private static double getPerimeter(int radius){
        return 2 * Math.PI  * radius;
    }
}
