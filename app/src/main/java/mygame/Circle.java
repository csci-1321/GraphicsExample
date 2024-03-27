package mygame;

public class Circle implements Comparable<Circle> {

    public int x,y,radius;
    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    @Override
    public int compareTo(Circle o) {
        if (this.radius > o.radius) return 1;
        if (this.radius < o.radius) return -1;
        return 0;
    }
    
}
