package mygame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet extends GameEntity{
    public Vec2D force = new Vec2D();

    public Bullet (Vec2D v) {
        force.x = v.x;
        force.y = v.y;
    }
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(Color.BLUE);
        g.fillRect(this.position.x, this.position.y, 10, 20);
        position.y = position.y + force.y;
        position.x = position.x + force.x;
    }
    
}
