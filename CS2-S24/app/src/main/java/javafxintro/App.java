package javafxintro;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class App extends Application {
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(600,600);
        Scene scene = new Scene(new StackPane(canvas));

        Blob b = new Blob();
        b.x = canvas.getWidth()/2.0;
        b.y = canvas.getHeight()/2.0;
        ArrayList<Clicks> clicks = new ArrayList<Clicks>();

        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setStroke(Color.LIGHTSALMON);
        g.strokeOval(250, 250, 100, 100);
        g.setFill(Color.RED);
        g.fillOval(300, 300, 100, 100);

        canvas.setOnMousePressed((MouseEvent e) -> {
            System.out.println("Mouse Pressed");
            System.out.println("x: " + e.getX() + ", y: " + e.getY());
            Clicks c = new Clicks();
            c.x = e.getX();
            c.y = e.getY();
            clicks.add(c);
        });

        canvas.setOnKeyPressed((KeyEvent k ) -> {
            if (k.getCode().equals(KeyCode.LEFT)) {
                b.x -= 5;
                if (b.x < 0) {
                    b.x = canvas.getWidth();
                }
            }
            if (k.getCode().equals(KeyCode.RIGHT)) {
                b.x += 5;
                if (b.x > canvas.getWidth()) {
                    b.x = 0;
                }
            }
        });

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                g.setStroke(Color.BLACK);
                g.strokeOval(b.x, b.y, 50, 50);
            

                for(Clicks c : clicks) {
                    g.setFill(Color.rgb(57, 57, 57));
                    g.fillRect(c.x-10,c.y-10,20,20);
                    c.y -= 1;
                    if (c.y < 0) {
                        c.y = canvas.getHeight();
                    }
                }
            }
            
        };
        canvas.requestFocus();
        timer.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
