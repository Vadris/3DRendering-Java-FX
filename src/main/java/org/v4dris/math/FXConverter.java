package org.v4dris.math;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import org.v4dris.math.body.Body3D;
import org.v4dris.math.point.*;
import org.v4dris.math.vector.Vector3D;

public class FXConverter {
    public static Line vectorToLine(Vector3D vector){
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        Line line = new Line();

        Point3D tempPoint = (Point3D) vector.getStartPoint();
        Point2D pointA = convertPoint(tempPoint);
        Point2D pointB = convertPoint(vector.getEndPoint());
        line.setStartX(pointA.getX());
        line.setStartY(pointA.getY());
        line.setEndX(pointB.getX());
        line.setEndY(pointB.getY());
        return line;
    }

    public static Line[] bodyToLines(Body3D body){
        Line[] lines = new Line[body.vectors.length];
        for(int i = 0; i < body.vectors.length; i++){
            lines[i] = vectorToLine(body.vectors[i]);
        }
        return lines;
    }

    public static Line[] updateLines(Line[] lines, Body3D body){
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        for(int i = 0; i < lines.length; i++){
            Point2D pointA = convertPoint((Point3D) body.vectors[i].getStartPoint());
            Point2D pointB = convertPoint(body.vectors[i].getEndPoint());
            lines[i].setStartX(pointA.getX());
            lines[i].setStartY(pointA.getY());
            lines[i].setEndX(pointB.getX());
            lines[i].setEndY(pointB.getY());
        }
        return lines;
    }

    public static Point2D convertPoint(Point3D point){
        double rt = 2 * Math.sqrt(2);
        Point2D result = new Point2D(point.getX() + point.getY() / rt, point.getZ() - point.getY() / rt);
        result = convertPixelLocation(result);
        return result;
    }
    public static Point2D convertPixelLocation(Point2D point){
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double offsetX = screenBounds.getMaxX()/2;
        double offsetY = screenBounds.getMaxY()/2;

        Point2D result = new Point2D(0,0);
        result.setX(point.getX() + offsetX);
        result.setY(offsetY - point.getY());
        return result;
    }
}
