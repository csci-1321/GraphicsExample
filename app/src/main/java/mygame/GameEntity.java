package mygame;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameEntity {
    public double x,y;
    public abstract void draw(GraphicsContext x);
}
