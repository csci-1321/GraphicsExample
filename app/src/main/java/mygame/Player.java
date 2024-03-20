package mygame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends GameEntity{
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(Color.BLACK);
        g.fillOval(this.x, this.y, 50, 50);
    }
}
