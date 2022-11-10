package org.v4dris._3drenderinge;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.v4dris.TickEventListener;
import org.v4dris.math.FXConverter;
import org.v4dris.math.body.Cube;
import org.v4dris.math.matrix.Matrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewerApp extends Application {

    Line[] bodyLines;
    double phi = 0.1;

    Matrix rot = new Matrix(
            new double[]{Math.cos(phi), -Math.sin(phi), 0},
            new double[]{Math.sin(phi), Math.cos(phi) ,0 },
            new double[]{0, 0, 1}
    );

    /**
     Matrix rot = new Matrix(
            new double[]{1,0,0},
            new double[]{0,Math.cos(phi), -Math.sin(phi)},
            new double[]{0, Math.sin(phi), Math.cos(phi)}
     );
     **/
    /**
    Matrix rot = new Matrix(
            new double[]{Math.cos(phi), 0, Math.sin(phi)},
            new double[]{0,1,0},
            new double[]{-Math.sin(phi), 0, Math.cos(phi)}
    );
     **/
    boolean runAnimation = true;
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();


        Matrix t1 = new Matrix(
                new double[]{1,0,-20},
                new double[]{0,1,-20},
                new double[]{0,0,1}
        );
        Matrix t2 = new Matrix(
                new double[]{1,0,20},
                new double[]{0,1,20},
                new double[]{0,0,1}
        );



        Cube cube = new Cube(100);

        bodyLines = FXConverter.bodyToLines(cube);

        Group root = new Group();
        for(int i = 0; i < bodyLines.length; i++){
            root.getChildren().add(bodyLines[i]);
        }
        Scene scene = new Scene(root, screenBounds.getMaxX(), screenBounds.getMaxY() - 72);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W){
                phi += 0.01;
                rot = new Matrix(
                        new double[]{Math.cos(phi), -Math.sin(phi), 0},
                        new double[]{Math.sin(phi), Math.cos(phi) ,0 },
                        new double[]{0, 0, 1}
                );
            }
            if (e.getCode() == KeyCode.S){
                phi -= 0.01;
                rot = new Matrix(
                        new double[]{Math.cos(phi), -Math.sin(phi), 0},
                        new double[]{Math.sin(phi), Math.cos(phi) ,0 },
                        new double[]{0, 0, 1}
                );
            }
            if(e.getCode() == KeyCode.SPACE && runAnimation == false){
                runAnimation = true;
            }

            if(e.getCode() == KeyCode.SPACE && runAnimation == true){
                runAnimation = false;
            }

        });

        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();

        List<TickEventListener> listeners = new ArrayList<>();
        Task<Void> tick = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while(runAnimation){
                    Thread.sleep(25);
                    for(int i = 0; i < listeners.size(); i++){
                        listeners.get(i).onTickEvent();
                    }
                }
                return null;
            }
        };
        listeners.add(() -> {
            try {
                //cube.transform(t1);
                cube.transform(rot);
                //cube.transform(t2);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            FXConverter.updateLines(bodyLines, cube);
        });
        Thread th = new Thread(tick);
        th.setDaemon(true);
        th.start();
        System.out.println("Test");

    }
    public static void main(String[] args) {
        launch();
    }
}