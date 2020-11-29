package agh.cs.lab7;

public class Grass extends AbstractMapElement{

    public Grass (Vector2d position){
        this.position = position;
    }
    public String toString(){
        return "*";
    }
}
