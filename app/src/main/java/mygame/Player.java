package mygame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends GameEntity{
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(Color.BLACK);
        g.fillOval(this.position.x, this.position.y, 50, 50);
    }

    public Bullet shoot() {
        Bullet b = new Bullet(new Vec2D(0,-5));
        b.position.x = this.position.x + 20;
        b.position.y = this.position.y;
        return b;
    }
}
