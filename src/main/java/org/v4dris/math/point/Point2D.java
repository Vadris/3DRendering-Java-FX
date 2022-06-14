package org.v4dris.math.point;

public class Point2D extends Point {

    public Point2D(double x, double y){
        super("P");
        coordinates = new double[]{x,y};
    }
    public Point2D(String name, double x, double y){
        super(name);
        coordinates = new double[]{x,y};
    }

    public double getX(){
        return coordinates[0];
    }
    public double getY(){
        return coordinates[1];
    }

    public void setX(double x){
        coordinates[0] = x;
    }
    public void getY(double y){
        coordinates[1] = y;
    }
}
