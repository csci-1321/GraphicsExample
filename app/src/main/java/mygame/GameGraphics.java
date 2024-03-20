package mygame;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafxintro.Clicks;

public class GameGraphics extends Application{

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(600,600);
        Scene scene = new Scene(new StackPane(canvas));
        GraphicsContext g = canvas.getGraphicsContext2D();

        ArrayList<GameEntity> allEntities = new ArrayList<GameEntity>();

        Enemy enemy1 = new Enemy();
        enemy1.x = 300;
        enemy1.y = 300;
        //enemy1.draw(g);
        Player p = new Player();
        p.x = 100;
        p.y = 100;

        allEntities.add(enemy1);
        allEntities.add(p);

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                for(GameEntity ge : allEntities) {
                    if(ge instanceof Enemy) {
                        ge.x += 1;
                    }
                    ge.draw(g);
                }
            }
            
        };
        canvas.requestFocus();
        timer.start();
        

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
