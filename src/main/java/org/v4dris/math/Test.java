package org.v4dris.math;

import org.v4dris.math.matrix.Matrix;
import org.v4dris.math.point.*;
import org.v4dris.math.vector.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Point2D p1 = new Point2D(2, 3);
        Point2D p2 = new Point2D(4, 4);

        Vector2D vec1 = new Vector2D(p1);
        Vector2D vec2 = new Vector2D(p2);
        Matrix matrix = new Matrix(
                new double[]{2,2},
                new double[]{2,2}
        );
        vec1.mul(matrix);

        System.out.println(vec1.getX());
        System.out.println(vec1.getY());
        System.out.println(vec2.getX());
        System.out.println(vec2.getY());
        System.out.println(vec2.getStartPoint());
    }
}
