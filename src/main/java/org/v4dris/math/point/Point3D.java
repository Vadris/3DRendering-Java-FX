package org.v4dris.math.point;

public class Point3D extends Point{
    public Point3D(String name, double x, double y, double z) {
        super(name);
        coordinates = new double[]{x,y,z};
    }
    public Point3D(double x, double y, double z) {
        super("P");
        coordinates = new double[]{x,y,z};
    }

    public double getX(){
        return coordinates[0];
    }
    public double getY(){
        return coordinates[1];
    }
    public double getZ(){
        return coordinates[2];
    }

    public void setX(double x){
        coordinates[0] = x;
    }
    public void getY(double y){
        coordinates[1] = y;
    }
    public void setZ(double z){
        coordinates[2] = z;
    }
}
