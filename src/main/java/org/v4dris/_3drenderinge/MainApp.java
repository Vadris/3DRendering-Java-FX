package org.v4dris._3drenderinge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.v4dris.math.point.Point2D;
import org.v4dris.math.vector.Vector2D;
import org.v4dris.math.vector.Vector3D;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Point2D p1 = new Point2D(200, 500);
        Point2D p2 = new Point2D(400, 400);

        Vector2D vec1 = new Vector2D(p1);
        Vector2D vec2 = new Vector2D(p1, p2);
        Line line = new Line();
        Point2D startPoint = (Point2D) (vec2.getStartPoint());
        line.setStartX(startPoint.getX());
        line.setStartY(startPoint.getY());

        line.setEndY(startPoint.getY()+vec2.getY());
        line.setEndX(startPoint.getX()+vec2.getX());

        Group root = new Group(line);
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();

        Scene scene = new Scene(root, screenBounds.getMaxX(), screenBounds.getMaxY() - 72);
        stage.setScene(scene);
        stage.show();
    }

    public void draw(Vector3D vector){
        
    }

    public static void main(String[] args) {
        launch();
    }
}