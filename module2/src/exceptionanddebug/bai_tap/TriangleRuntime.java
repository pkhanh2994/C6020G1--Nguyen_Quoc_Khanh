package exceptionanddebug.bai_tap;

public class TriangleRuntime {
    private int side1;
    private int side2;
    private int side3;

    public TriangleRuntime(int side1, int side2, int side3) {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
    }

    public TriangleRuntime() {
    }

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        if (side1 <= 0) {
            throw new TriangleRuntimeException("This is not the side of triangle or  the side of the triangle must be positive and greater than 0");
        }else
            this.side1=side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        if (side2 <= 0) {
            throw new TriangleRuntimeException("This is not the side of triangle or  the side of the triangle must be positive and greater than 0");
        }else
            this.side2=side2;
    }

    public int getSide3() {
        return side3;
    }

    public void setSide3(int side3) {
        if (side3 <= 0) {
            throw new TriangleRuntimeException("This is not the side of triangle or  the side of the triangle must be positive and greater than 0");
        }else
            this.side3=side3;
    }

    public void getPremiter()  {
        if ((this.side1 + this.side2 < this.side3) || (this.side1 + this.side3 < this.side2) || (this.side2 + this.side3 < this.side1)) {
            throw new TriangleRuntimeException("This is not the side of triangle");
        }
    }
}
