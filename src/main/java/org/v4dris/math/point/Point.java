package org.v4dris.math.point;

import org.v4dris.math.matrix.Matrix;

public class Point {
    protected double[] coordinates;
    private String name;

    protected Point(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        String result = name + "(";
        int i;
        for(i = 0; i + 1 < coordinates.length; i++){
            result += String.valueOf(coordinates[i]);
            result += "|";
        }
        result += String.valueOf(coordinates[i]);
        result += ")";
        return result;
    }
    public void mul(Matrix matrix){
        double[] v = new double[this.coordinates.length];
        for(int i = 0; i < matrix.getSizeA(); i++){
            for(int j = 0; j < matrix.getSizeB(); j++){
                v[i] += this.coordinates[j] * matrix.values[i][j];
            }
        }
        for(int i = 0; i < v.length; i++){
            coordinates[i] = v[i];
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static Point2D convertPoint(Point3D point, double offsetX, double offsetY){
        double rt = 2 * Math.sqrt(2);
        return new Point2D(point.getX() + point.getY()/rt + offsetX, point.getZ() - point.getY()/rt + offsetY);
    }
}
