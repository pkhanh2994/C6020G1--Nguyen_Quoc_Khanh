package OOP.bai_tap;

import java.util.Arrays;

public class Point3D extends Point2D {
    public float z=0.0f;
    public Point3D(){

    }
    public Point3D(float x, float y, float z){
        super(x,y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ(){
        return new float[] {x,y,z};
    }
    public void setXYZ(float x,float y,float z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    @Override
    public String toString(){
        return " z is: "+getZ()
                +" array of x,y,z "+ Arrays.toString(getXYZ());

    }
}
