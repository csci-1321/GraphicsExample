package mygame;

public interface Collidable {
    public void onCollision(GameEntity other);
    public boolean checkCollision(GameEntity other);
}
