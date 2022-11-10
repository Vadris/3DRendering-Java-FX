package org.v4dris.math.point;

import org.v4dris.math.matrix.Matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

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
    public void multiply(Matrix matrixIn){
        double[][]matrix = matrixIn.values;
        double[] result = Arrays.stream(matrix)
                .mapToDouble(row -> IntStream.range(0, row.length)
                        .mapToDouble(col -> row[col] * coordinates[col])
                        .sum())
                .toArray();
        this.coordinates = result;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
