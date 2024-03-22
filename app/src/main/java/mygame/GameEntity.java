package mygame;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameEntity {
    public Vec2D position = new Vec2D();
    public abstract void draw(GraphicsContext x);
}
