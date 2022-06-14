package org.v4dris.math;

import org.v4dris.math.point.*;
import org.v4dris.math.vector.*;

public class Test {
    public static void main(String[] args){
        Point2D p1 = new Point2D(200, 500);
        Point2D p2 = new Point2D(400, 400);

        Vector2D vec1 = new Vector2D(p1);
        Vector2D vec2 = new Vector2D(p1, p2);
        
        System.out.println(vec1.getX());
        System.out.println(vec1.getY());
        System.out.println(vec2.getX());
        System.out.println(vec2.getY());
        System.out.println(vec2.getStartPoint());
    }
}
