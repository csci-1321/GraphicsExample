package mygame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends GameEntity{
    public Vec2D force = new Vec2D();

    public void draw(GraphicsContext g) {
        g.setFill(Color.RED);
        g.fillRect(this.position.x, this.position.y, 50, 50);
        position.y = position.y + force.y;
        position.x = position.x + force.x;
        if (position.x > g.getCanvas().getWidth() - 100)
            force.x *= -1;
        if (position.x < 50)
            force.x *= -1;
    }
}
