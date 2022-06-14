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
        Point2D pointA = Point.convertPoint(tempPoint, screenBounds.getMaxX()/2, screenBounds.getMaxY()/2);
        Point2D pointB = Point.convertPoint(vector.getEndPoint(), screenBounds.getMaxX()/2, screenBounds.getMaxY()/2);
        line.setStartX(pointA.getX());
        line.setStartY(pointA.getY());
        line.setEndX(pointB.getX());
        line.setEndY(pointB.getY());
        return line;
    }

    public static Group bodyToGroup(Body3D body){
        Group group = new Group();
        for(int i = 0; i < body.vectors.length; i++){
            group.getChildren().add(vectorToLine(body.vectors[i]));
        }
        return group;
    }

    public static Point2D convertPoint(Point3D point){
        double rt = 2 * Math.sqrt(2);
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double offsetX = screenBounds.getMaxX()/2;
        double offsetY = screenBounds.getMaxY()/2;
        return new Point2D(point.getX() + point.getY()/rt + offsetX,  point.getZ() + point.getY()/rt + offsetY);
    }
}
