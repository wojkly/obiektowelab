package agh.cs.lab2;

public class Vector2d {
    public final int x;
    public final int y;
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other){
        return other.x <= this.x && other.y <= this.y;
    }
    public Vector2d upperRight(Vector2d other){
        return new Vector2d()
    }
    Vector2d lowerLeft(Vector2d other)
    Vector2d add(Vector2d other)
    Vector2d subtract(Vector2d other)
    boolean equals(Object other)
    Vector2d opposite()
}
