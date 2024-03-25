package mygame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Bullet extends GameEntity implements Collidable{
    public Vec2D force = new Vec2D();
    public Image image4 = new Image("file:cheese.jpg", 10, 20, false, false);

    public Bullet (Vec2D v) {
        force.x = v.x;
        force.y = v.y;
    }
    @Override
    public void draw(GraphicsContext g) {
        //g.setFill(Color.BLUE);
        //g.fillRect(this.position.x, this.position.y, size.x, size.y);
        g.drawImage(image4, this.position.x, this.position.y);
        position.y = position.y + force.y;
        position.x = position.x + force.x;
    }
    
    @Override
    public void onCollision(GameEntity other) {
        System.out.println("I (bullet) collided!");
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
