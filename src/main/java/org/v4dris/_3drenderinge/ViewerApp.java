package org.v4dris._3drenderinge;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.v4dris.math.point.Point;
import org.v4dris.math.point.Point2D;
import org.v4dris.math.point.Point3D;
import org.v4dris.math.vector.Vector3D;

import java.io.IOException;

public class ViewerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double size = 100;

        Point3D p1 = new Point3D(0,0,0);
        Point3D p2 = new Point3D(size,0,0);
        Point3D p3 = new Point3D(size,size,0);
        Point3D p4 = new Point3D(0,size,0);

        Point3D p5 = new Point3D(0,0,-size);
        Point3D p6 = new Point3D(size,0,-size);
        Point3D p7 = new Point3D(size,size,-size);



        Group root = new Group(createLine(new Vector3D(p1, p2)), createLine(new Vector3D(p2, p3)), createLine(new Vector3D(p3, p4)), createLine(new Vector3D(p4,p1)), createLine(new Vector3D(p1, p5)), createLine(new Vector3D(p2, p6)), createLine(new Vector3D(p5, p6)), createLine(new Vector3D(p3, p7)));


        Scene scene = new Scene(root, screenBounds.getMaxX(), screenBounds.getMaxY() - 72);
        stage.setScene(scene);
        stage.show();
    }

    public Line createLine(Vector3D vector){
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

    public static void main(String[] args) {
        launch();
    }
}