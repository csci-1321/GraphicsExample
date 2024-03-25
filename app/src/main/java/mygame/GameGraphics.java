package mygame;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafxintro.Clicks;

public class GameGraphics extends Application{

    private ArrayList<GameEntity> allEntities = new ArrayList<GameEntity>();

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(600,600);
        Scene scene = new Scene(new StackPane(canvas));
        GraphicsContext g = canvas.getGraphicsContext2D();

        Enemy enemy1 = new Enemy();
        enemy1.position.x = 300;
        enemy1.position.y = 100;
        enemy1.force.x = 2;
        enemy1.force.y = 0;
        enemy1.size.x = 50;
        enemy1.size.y = 50;
        //enemy1.draw(g);
        Player p = new Player();
        p.position.x = 275;
        p.position.y = 500;
        p.size.x = 50;
        p.size.y = 50;

        allEntities.add(enemy1);
        allEntities.add(p);

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                handleCollisions();
                for(GameEntity ge : allEntities) {
                    ge.draw(g);
                }
            }
            
        };

        canvas.setOnKeyPressed((KeyEvent k ) -> {
            if (k.getCode().equals(KeyCode.LEFT)) {
                if (p.position.x >= 10) {
                    p.position.x -= 5;
                }
            }
            if (k.getCode().equals(KeyCode.RIGHT)) {
                if (p.position.x < canvas.getWidth()-60) {
                    p.position.x += 5;
                }
            }
            if (k.getCode().equals(KeyCode.SPACE)) {
                allEntities.add(p.shoot());
            }
        });
        canvas.requestFocus();
        timer.start();
        

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void handleCollisions() {
        ArrayList<GameEntity> toDelete = new ArrayList<GameEntity>();
        for (GameEntity orig : allEntities) {
            for (GameEntity collided : allEntities) {
                if (!orig.equals(collided)) {
                    //checkCollision();
                    if (orig instanceof Collidable && collided instanceof Collidable) {
                        boolean isCollision = ((Collidable) orig).checkCollision(collided);
                        if (isCollision) {
                            ((Collidable) orig).onCollision(collided);
                            if (orig instanceof Bullet) toDelete.add(orig);
                        }
                    }
                }
            }
        }
        for (GameEntity del : toDelete) {
            allEntities.remove(del);
        }
    }
}
