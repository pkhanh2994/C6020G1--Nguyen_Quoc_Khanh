package OOP.bai_tap;

import java.util.Arrays;

public class Point2D {
    protected float x = 0.0f;
    protected float y = 0.0f;

    public Point2D() {

    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        return new float[] {x,y};
    }
    public void setXY(float x,float y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
      return  "x is "+getX() +
              " y is "+getY() +
              " array of x,y is: "+ Arrays.toString(getXY());
    }
}
