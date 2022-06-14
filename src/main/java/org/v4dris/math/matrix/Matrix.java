package org.v4dris.math.matrix;

public class Matrix {
    public double[][] values;

    public Matrix(double[]... values){
        this.values = new double[values.length][values[1].length];
        for(int i = 0; i < values.length; i++){
            this.values[i][0] = values[i][0];
            this.values[i][1] = values[i][1];
            this.values[i][2] = values[i][2];
        }
    }
    public int getSizeA(){
        return values.length;
    }
    public int getSizeB(){
        return values[0].length;
    }
}
