package org.v4dris.math;

import org.v4dris.math.matrix.Matrix;
import org.v4dris.math.point.*;
import org.v4dris.math.vector.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Point2D p1 = new Point2D(2, 4);
        Point2D p2 = new Point2D(4, 4);
        Point3D p3 = new Point3D(2,2,3);

        Vector2D vec1 = new Vector2D(p1);
        Vector2D vec2 = new Vector2D(p2);
        Vector3D vec3 = new Vector3D(p3);
        Matrix matrix = new Matrix(
                new double[]{2,2,2},
                new double[]{2,2,2},
                new double[]{2,2,2}
        );
        vec3.mul(matrix);

        System.out.println(vec3.getX());
        System.out.println(vec3.getY());
        System.out.println(vec3.getZ());
    }
}
