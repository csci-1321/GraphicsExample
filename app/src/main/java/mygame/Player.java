package mygame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends GameEntity{
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(Color.BLACK);
        g.fillOval(this.position.x, this.position.y, size.x, size.y);
    }

    public Bullet shoot() {
        Bullet b = new Bullet(new Vec2D(0,-5));
        b.position.x = this.position.x + 20;
        b.position.y = this.position.y;
        b.size.x = 10;
        b.size.y = 20;
        return b;
    }
}
