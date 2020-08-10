package OOP.bai_tap;

import java.util.Scanner;

public class LopHinhChuNhat {
   private double width;
   private double height;

//    public LopHinhChuNhat(double width, double height) {
//        this.width = width;
//        this.height = height;
//    }
    //Nếu không có phương thức khởi tạo constructor thì chúng ta phải sử dụng getter và setter để lấy giá trị
    //chiều dài và chiều rộng của hình chữ nhật
    public void setWidth(double width){
        this.width=width;
    }
    public double getWidth(){
        return this.width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "width=" + this.width + ", height=" +this.height + "}";
    }

}
