package org.v4dris.math.matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Matrix {
    public double[][] values;

    public Matrix(double[]... values){
        this.values = new double[values.length][values[1].length];
        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values[0].length; j++){
                this.values[i][j] = values[i][j];
            }
        }
    }
    public int getSizeA(){
        return values.length;
    }
    public int getSizeB(){
        return values[0].length;
    }
}
