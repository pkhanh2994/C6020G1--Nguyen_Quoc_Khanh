package exceptionanddebug.bai_tap;

public class Triangle {
    private int side1;
    private int side2;
    private int side3;

    public Triangle(int side1, int side2, int side3) throws TriangleInvalidException {
       setSide1(side1);
       setSide2(side2);
       setSide3(side3);
    }

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) throws TriangleInvalidException {
        if (side1 <= 0) {
            throw new TriangleInvalidException("This is not the side of triangle or  the side of the triangle must be positive and greater than 0");
        }else
            this.side1=side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) throws TriangleInvalidException {
        if (side2 <= 0) {
            throw new TriangleInvalidException("This is not the side of triangle or  the side of the triangle must be positive and greater than 0");
        }else
            this.side2=side2;
    }

    public int getSide3() {
        return side3;
    }

    public void setSide3(int side3) throws TriangleInvalidException {
        if (side3 <= 0) {
            throw new TriangleInvalidException("This is not the side of triangle or  the side of the triangle must be positive and greater than 0");
        }else
            this.side3=side3;
    }
    public void getPremiter() throws TriangleInvalidException {
        if((this.side1+this.side2<this.side3)||(this.side1+this.side3<this.side2)||(this.side2+this.side3<this.side1)){
            throw new TriangleInvalidException("This is not the side of triangle");
        }
    }
}
