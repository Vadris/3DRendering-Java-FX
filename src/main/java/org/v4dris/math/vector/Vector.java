package org.v4dris.math.vector;

import org.v4dris.math.matrix.Matrix;
import org.v4dris.math.point.Point;

public class Vector {
    protected double[] values;
    protected Point startPoint;

    public void add(Vector vector) throws Exception {
        if(getSize() != vector.getSize()) {
            throw new Exception("Vectors must be same size");
        }
        for(int i = 0; i < getSize(); i++){
            this.values[i] += vector.values[i];
        }
    }
    public void sub(Vector vector) throws Exception {
        if(getSize() != vector.getSize()) {
            throw new Exception("Vectors must be same size");
        }
        for(int i = 0; i < getSize(); i++){
            this.values[i] -= vector.values[i];
        }
    }
    public void mul(Vector vector) throws Exception {
        if(getSize() != vector.getSize()) {
            throw new Exception("Vectors must be same size");
        }
        for(int i = 0; i < getSize(); i++){
            this.values[i] *= vector.values[i];
        }
    }
    public void mul(Matrix matrix) throws Exception {
        double[] v = new double[this.values.length];
        for(int i = 0; i < matrix.getSizeA(); i++){
            for(int j = 0; j < matrix.getSizeB(); j++){
                v[i] += this.values[j] * matrix.values[i][j];
            }
        }
        for(int i = 0; i < v.length; i++){
            values[i] = v[i];
        }
    }

    public void div(Vector vector) throws Exception {
        if(getSize() != vector.getSize()) {
            throw new Exception("Vectors must be same size");
        }
        for(int i = 0; i < getSize(); i++){
            this.values[i] /= vector.values[i];
        }
    }


    public int getSize(){
        return this.values.length;
    }
    public Point getStartPoint() {
        return startPoint;
    }


    public void setStartPoint(Point startPoint){
        this.startPoint = startPoint;
    }
}
