package mygame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends GameEntity{
    
    public void draw(GraphicsContext g) {
        g.setFill(Color.RED);
        g.fillRect(this.x, this.y, 50, 50);
    }
}
