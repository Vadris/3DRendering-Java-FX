package org.v4dris.math.vector;

import org.v4dris.math.point.Point2D;

public class Vector2D extends Vector {
    public Vector2D(double x, double y){
        values = new double[]{x,y};
        startPoint = new Point2D(0, 0);
    }
    public Vector2D(Point2D point){
        values = new double[]{point.getX(), point.getY()};
        startPoint = new Point2D(0,0);
    }
    public Vector2D(Point2D startPoint, Point2D endPoint){
        this.startPoint = new Point2D(startPoint.getName(), startPoint.getX(), startPoint.getY());
        this.values = new double[]{endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY()};
    }

    public double getX(){
        return values[0];
    }
    public double getY(){
        return values[1];
    }
}
