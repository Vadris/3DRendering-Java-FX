package org.v4dris.math.vector;

import org.v4dris.math.point.Point2D;
import org.v4dris.math.point.Point3D;

public class Vector3D extends Vector {
    public Vector3D(double x, double y, double z){
        values = new double[]{x,y,z};
        startPoint = new Point2D(0, 0);
    }
    public Vector3D(Point3D point){
        values = new double[]{point.getX(), point.getY(), point.getZ()};
        startPoint = new Point3D(0,0 ,0);
    }
    public Vector3D(Point3D startPoint, Point3D endPoint){
        this.startPoint = new Point2D(startPoint.getName(), startPoint.getX(), startPoint.getY());
        this.values = new double[]{endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY(), endPoint.getZ() - startPoint.getZ()};
    }

    public double getX(){
        return values[0];
    }
    public double getY(){
        return values[1];
    }
    public double getZ(){
        return values[2];
    }
}
