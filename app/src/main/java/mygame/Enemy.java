package mygame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends GameEntity implements Collidable{
    public Vec2D force = new Vec2D();

    public void draw(GraphicsContext g) {
        g.setFill(Color.RED);
        g.fillRect(this.position.x, this.position.y, size.x, size.y);
        position.y = position.y + force.y;
        position.x = position.x + force.x;
        if (position.x > g.getCanvas().getWidth() - 100)
            force.x *= -1;
        if (position.x < size.x)
            force.x *= -1;
    }

    @Override
    public void onCollision(GameEntity other) {
        System.out.println("I collided!");
    }

    @Override
    public boolean checkCollision(GameEntity other) {
        if (other.position.x > position.x && other.position.x < position.x + size.x) {
            if (other.position.y > position.y && other.position.y < position.y + size.y) {
                return true;
            }
        }
        if (position.x > other.position.x && position.x < other.position.x + other.size.x) {
            if (position.y > other.position.y && position.y < other.position.y + other.size.y) {
                return true;
            }
        }
        
        return false;
    }
}
